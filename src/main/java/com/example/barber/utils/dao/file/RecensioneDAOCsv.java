package com.example.barber.utils.dao.file;

import com.example.barber.model.RecensioneModel;
import com.example.barber.utils.dao.RecensioneDao;
import com.example.barber.utils.dao.file.csv.AttributiRecensione;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RecensioneDAOCsv implements RecensioneDao {

    private static final String CSV_FILE_NAME = "C:\\Users\\fmaxp\\Documents\\GitHub\\gestionaleBarber\\src\\main\\java\\com\\example\\barber\\utils\\dao\\fileSystem\\fileCsv\\recensioni.csv";
    private final File fd;
    private int nextId = 1;

    public RecensioneDAOCsv() {
        this.fd = new File(CSV_FILE_NAME);
        initializeNextId();
    }

    private void initializeNextId() {
        try (CSVReader csvReader = new CSVReader(new FileReader(fd))) {
            String[] string;
            while ((string = csvReader.readNext()) != null) {
                int currentId = Integer.parseInt(string[AttributiRecensione.INDEX_ID_RECENSIONE]);
                if (currentId >= nextId) {
                    nextId = currentId + 1;
                }
            }
        } catch (IOException | CsvValidationException | NumberFormatException e) {
            nextId = 1;
        }
    }

    @Override
    public void insertRecensione(RecensioneModel recensioneModel) throws SystemException {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(fd, true))) {
            String[] string = new String[9];
            string[AttributiRecensione.INDEX_ID_RECENSIONE] = String.valueOf(nextId++);
            string[AttributiRecensione.INDEX_ID_CLIENTE] = String.valueOf(recensioneModel.getIdCliente());
            string[AttributiRecensione.INDEX_ID_APPUNTAMENTO] = String.valueOf(recensioneModel.getIdAppuntamento());
            string[AttributiRecensione.INDEX_VOTO] = String.valueOf(recensioneModel.getVoto());
            string[AttributiRecensione.INDEX_TESTO] = recensioneModel.getTesto();
            string[AttributiRecensione.INDEX_CREATED_AT] = recensioneModel.getCreatedAt().toString();
            string[AttributiRecensione.INDEX_NOME_CLIENTE] = recensioneModel.getNomeCliente();
            string[AttributiRecensione.INDEX_NOME_BARBIERE] = recensioneModel.getNomeBarbiere();
            string[AttributiRecensione.INDEX_REPORT] = String.valueOf(recensioneModel.getReport());
            csvWriter.writeNext(string);
            csvWriter.flush();
        } catch (IOException e) {
            throw new SystemException("Errore nella scrittura della recensione nel file CSV");
        }
    }

    @Override
    public List<RecensioneModel> getMyRecensioni(int id) throws SystemException {
        List<RecensioneModel> recensioni = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(fd))) {
            String[] string;
            while ((string = csvReader.readNext()) != null) {
                if (Integer.parseInt(string[AttributiRecensione.INDEX_ID_CLIENTE]) == id) {
                    recensioni.add(mapToRecensioneModel(string));
                }
            }
        } catch (IOException | CsvValidationException e) {
            ErrorDialog.getInstance().handleException(e);
        }
        return recensioni;
    }

    @Override
    public List<RecensioneModel> getMyRecensioniBarbiere(int id) throws SystemException {
        List<RecensioneModel> recensioni = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(fd))) {
            String[] string;
            while ((string = csvReader.readNext()) != null) {
                RecensioneModel recensione = mapToRecensioneModel(string);
                recensioni.add(recensione);
            }
        } catch (IOException | CsvValidationException e) {
            ErrorDialog.getInstance().handleException(e);
        }
        return recensioni;
    }

    @Override
    public void reportRecensione(int idRecensione) throws SystemException {
        updateRecensioneReport(idRecensione, 1);
    }

    @Override
    public List<RecensioneModel> getReportedRecensioni() throws SystemException {
        List<RecensioneModel> recensioni = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(fd))) {
            String[] string;
            while ((string = csvReader.readNext()) != null) {
                if (Integer.parseInt(string[AttributiRecensione.INDEX_REPORT]) == 1) {
                    recensioni.add(mapToRecensioneModel(string));
                }
            }
        } catch (IOException | CsvValidationException e) {
            ErrorDialog.getInstance().handleException(e);
        }
        return recensioni;
    }

    @Override
    public void approveRecensione(int idRecensione) throws SystemException {
        updateRecensioneReport(idRecensione, 0);
    }

    @Override
    public void deleteRecensione(int idRecensione) throws SystemException {
        List<String[]> allRecensioni = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(fd))) {
            String[] string;
            while ((string = csvReader.readNext()) != null) {
                if (Integer.parseInt(string[AttributiRecensione.INDEX_ID_RECENSIONE]) != idRecensione) {
                    allRecensioni.add(string);
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new SystemException("Errore nella lettura del file CSV durante l'eliminazione");
        }

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(fd, false))) {
            for (String[] recensione : allRecensioni) {
                csvWriter.writeNext(recensione);
            }
            csvWriter.flush();
        } catch (IOException e) {
            throw new SystemException("Errore nella scrittura del file CSV durante l'eliminazione");
        }
    }

    private void updateRecensioneReport(int idRecensione, int reportValue) throws SystemException {
        List<String[]> allRecensioni = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(fd))) {
            String[] string;
            while ((string = csvReader.readNext()) != null) {
                if (Integer.parseInt(string[AttributiRecensione.INDEX_ID_RECENSIONE]) == idRecensione) {
                    string[AttributiRecensione.INDEX_REPORT] = String.valueOf(reportValue);
                }
                allRecensioni.add(string);
            }
        } catch (IOException | CsvValidationException e) {
            throw new SystemException("Errore nella lettura del file CSV durante l'aggiornamento");
        }

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(fd, false))) {
            for (String[] recensione : allRecensioni) {
                csvWriter.writeNext(recensione);
            }
            csvWriter.flush();
        } catch (IOException e) {
            throw new SystemException("Errore nella scrittura del file CSV durante l'aggiornamento");
        }
    }

    private RecensioneModel mapToRecensioneModel(String[] string) {
        RecensioneModel recensione = new RecensioneModel();
        recensione.setIdRecensione(Integer.parseInt(string[AttributiRecensione.INDEX_ID_RECENSIONE]));
        recensione.setIdCliente(Integer.parseInt(string[AttributiRecensione.INDEX_ID_CLIENTE]));
        recensione.setIdAppuntamento(Integer.parseInt(string[AttributiRecensione.INDEX_ID_APPUNTAMENTO]));
        recensione.setVoto(Integer.parseInt(string[AttributiRecensione.INDEX_VOTO]));
        recensione.setTesto(string[AttributiRecensione.INDEX_TESTO]);
        recensione.setCreatedAt(Timestamp.valueOf(string[AttributiRecensione.INDEX_CREATED_AT]));
        recensione.setNomeCliente(string[AttributiRecensione.INDEX_NOME_CLIENTE]);
        recensione.setNomeBarbiere(string[AttributiRecensione.INDEX_NOME_BARBIERE]);
        recensione.setReport(Integer.parseInt(string[AttributiRecensione.INDEX_REPORT]));
        return recensione;
    }
}
