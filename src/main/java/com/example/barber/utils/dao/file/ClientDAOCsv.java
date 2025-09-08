package com.example.barber.utils.dao.file;

import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ClientModel;
import com.example.barber.utils.dao.ClientDao;
import com.example.barber.utils.dao.file.csv.AttributiCliente;
import com.example.barber.utils.dao.file.csv.AttributiCredentials;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;

public class ClientDAOCsv implements ClientDao {

    private static final String CSV_FILE_NAME = "C:\\Users\\aless\\Documents\\GitHub\\gestionaleBarber\\gestionaleBarber\\src\\main\\java\\com\\example\\barber\\utils\\dao\\fileSystem\\fileCsv\\clienti.csv";
    private static final String CSV_FILE_CREDENTIAL= "C:\\Users\\aless\\Documents\\GitHub\\gestionaleBarber\\gestionaleBarber\\src\\main\\java\\com\\example\\barber\\utils\\dao\\fileSystem\\fileCsv\\credentials.csv";
    private final File fd;
    private final File credFile;

    public ClientDAOCsv() {
        this.fd = new File(CSV_FILE_NAME);
        this.credFile = new File(CSV_FILE_CREDENTIAL);
    }


    @Override
    public ClientModel getUserByUsername(String username) throws SystemException {
        ClientModel clientModel = new ClientModel();
        try (CSVReader csvReader = new CSVReader(new FileReader(fd))) {
            String[] string;
            while ((string = csvReader.readNext()) != null) {
                if (string[AttributiCliente.INDEX_USERNAME].equals(username)) {
                    clientModel.setUsername(string[AttributiCliente.INDEX_USERNAME]);
                    clientModel.setName(string[AttributiCliente.INDEX_NAME]);
                    clientModel.setId(Integer.parseInt(string[AttributiCliente.INDEX_ID]));
                    clientModel.setEmail(string[AttributiCliente.INDEX_EMAIL]);
                    clientModel.setUsername(string[AttributiCliente.INDEX_USERNAME]);
                    clientModel.setSurname(string[AttributiCliente.INDEX_NAME]);
                    clientModel.setGender(string[AttributiCliente.INDEX_GENDER]);
                    clientModel.setPhone(string[AttributiCliente.INDEX_PHONE]);
                }
            }
        }catch (IOException | CsvValidationException e) {
            ErrorDialog.getInstance().handleException(e);
        }
        return clientModel;
    }
    @Override
    public boolean checkUsername(String username) throws SystemException {
        return true;
    }
    @Override
    public void addUser(CredentialsModel credentialModel, ClientModel clientModel)throws SystemException{
        try (CSVWriter csvWriter1 = new CSVWriter(new FileWriter(fd, true))) {
            String[] string1 = new String[20];
            string1[AttributiCliente.INDEX_USERNAME] = clientModel.getUsername();
            string1[AttributiCliente.INDEX_NAME] = clientModel.getName();
            string1[AttributiCliente.INDEX_EMAIL] = clientModel.getEmail();
            string1[AttributiCliente.INDEX_GENDER] = clientModel.getGender();
            string1[AttributiCliente.INDEX_PHONE] = clientModel.getPhone();
            csvWriter1.writeNext(string1);
            csvWriter1.flush();
        }catch (IOException e) {
            throw new SystemException("Errore nella scrittura degli attributi cliente csv");
        }try(CSVWriter csvWriter2 = new CSVWriter(new FileWriter(credFile,true));){
            String[] string2 = new String[3];
            string2[AttributiCredentials.INDEX_USERNAME] = credentialModel.getUsername();
            string2[AttributiCredentials.INDEX_PASSWORD] = credentialModel.getPassword();
            string2[AttributiCredentials.INDEX_ROLE] = credentialModel.getType().getRoleId();
            csvWriter2.writeNext(string2);
            csvWriter2.flush();
        }catch (IOException e) {
            throw new SystemException("Errore nella scrittura degli attributi credentians csv");
        }
    }
}
