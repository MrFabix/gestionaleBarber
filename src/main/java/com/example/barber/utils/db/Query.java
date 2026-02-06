package com.example.barber.utils.db;


import com.example.barber.model.*;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.enumeration.ruoli.Role;
import com.example.barber.utils.enumeration.statorichieste.StatoRichieste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query {

    private static final String USERNAME = "username";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";



    public void updateOrarioDB(BarberModel barberModel) throws SystemException {
        String query = "UPDATE barber SET orarioInizio = ?, orarioFine = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {

            preparedStatement.setString(1, barberModel.getOrarioInizio());
            preparedStatement.setString(2, barberModel.getOrarioFine());
            preparedStatement.setInt(3, barberModel.getId()); // condizione per trovare la riga giusta

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        } catch (SystemException e) {
            throw new IllegalArgumentException(e);
        }
    }




    //Restituzione Lista appuntamenti pendenti
    public List<RequestAppointmentsModel> searchAllAppointmentsById(int id, String role) throws SystemException {
        String query = switch (role) {
            case "BARBIERE" -> "SELECT appointments.idAppointments ,appointments.idbarber, appointments.idutente, appointments.data, " +
                    "appointments.name_user, appointments.name_barber, appointments.description, " +
                    "appointments.address_barber, appointments.service, appointments.state, " +
                    "appointments.orario, appointments.phone " +
                    "FROM appointments WHERE idBarber = ?";

            case "CLIENTE" -> "SELECT appointments.idAppointments ,appointments.idbarber, appointments.idutente, appointments.data, " +
                    "appointments.name_user, appointments.name_barber, appointments.description, " +
                    "appointments.address_barber, appointments.service, appointments.state, " +
                    "appointments.orario, appointments.phone " +
                    "FROM appointments WHERE idUtente = ?";
            default -> throw new IllegalArgumentException("Ruolo non supportato: " + role);

        };


        List<RequestAppointmentsModel> listRequestAppModel = new ArrayList<>();

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RequestAppointmentsModel rAppModel = new RequestAppointmentsModel();
                rAppModel.setAppId(rs.getInt("idAppointments"));
                rAppModel.setIdUser(rs.getInt("idUtente"));
                rAppModel.setIdBarber(rs.getInt("idbarber"));
                Date sqlDate = rs.getDate("data");
                rAppModel.setDate(sqlDate.toLocalDate());
                rAppModel.setNameUser(rs.getString("name_user"));
                rAppModel.setNameBarber(rs.getString("name_barber"));
                rAppModel.setDescription(rs.getString("description"));
                rAppModel.setAddressBarber(rs.getString("address_barber"));
                rAppModel.setService(rs.getString("service"));
                rAppModel.setOrario(rs.getString("orario"));
                rAppModel.setPhone(rs.getString(PHONE));
                StatoRichieste stato = StatoRichieste.fromString(rs.getString("state"));
                rAppModel.setState(stato);
                listRequestAppModel.add(rAppModel);

            }
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            ErrorDialog.getInstance().handleException(e);
            throw exception;
        }
        return listRequestAppModel;
    }

    public void updateAppointmentById(int appointmentId, String newState) throws SystemException {
        final String sql = "UPDATE appointments SET state = ? WHERE idappointments = ?";
        try (PreparedStatement ps = MySqlConnection.getInstance().connect().prepareStatement(sql)) {
            ps.setString(1, newState);   // "ACCETTATA" | "RIFIUTATA" | "PENDENTE"
            ps.setInt(2, appointmentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            SystemException ex = new SystemException();
            ex.initCause(e);
            throw ex;
        }
    }


    public void deleteService(ServiceModel serviceModel) throws SystemException {
            String query = "DELETE FROM service WHERE id_barber = ? AND servizi = ? AND prezzo = ?";
            try (PreparedStatement prpstmt = MySqlConnection.getInstance().connect().prepareStatement(query)) {
                prpstmt.setInt(1, serviceModel.getIdBarber());
                prpstmt.setString(2, serviceModel.getNomeServizio());
                prpstmt.setDouble(3, serviceModel.getPrezzo());
                prpstmt.executeUpdate();
            } catch (SQLException e) {
                SystemException exception = new SystemException();
                exception.initCause(e);
                throw exception;
            } catch (SystemException e) {
                throw new IllegalArgumentException(e);
            }
        }


    public void insertService(ServiceModel serviceModel) throws SystemException{
        String query = "INSERT INTO service (id_barber, servizi, prezzo) VALUES (?,?,?)";
        try (PreparedStatement ps = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            ps.setInt(1, serviceModel.getIdBarber());
            ps.setString(2, serviceModel.getNomeServizio());
            ps.setDouble(3, serviceModel.getPrezzo());

            ps.executeUpdate();

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        } catch (SystemException e) {
            throw new IllegalArgumentException(e);
        }
    }


    public void insertBarber(BarberModel barberModel) throws SystemException {
        String query = "INSERT INTO barber (username, name, address, city, phone, email) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            //Impostiamo i parametri della query
            preparedStatement.setString(1, barberModel.getUsername());
            preparedStatement.setString(2, barberModel.getName());
            preparedStatement.setString(3, barberModel.getAddress());
            preparedStatement.setString(4, barberModel.getCity());
            preparedStatement.setString(5, barberModel.getPhone());
            preparedStatement.setString(6, barberModel.getEmail());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        } catch (SystemException e) {
            throw new IllegalArgumentException(e);
        }


    }


    public void insertUser(ClientModel clientModel) throws SystemException {
        String query = "INSERT INTO user (name, surname, gender, email, username, phone) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {

            //Imposta i parametri della query
            preparedStatement.setString(1, clientModel.getName());
            preparedStatement.setString(2, clientModel.getSurname());

            preparedStatement.setString(3, clientModel.getGender());
            preparedStatement.setString(4, clientModel.getEmail());
            preparedStatement.setString(5, clientModel.getUsername());
            preparedStatement.setString(6, clientModel.getPhone());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            // Stampa un messaggio di errore e lancia una SystemException

            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;

        } catch (SystemException e) {
            throw new IllegalArgumentException(e);
        }

    }

    public void insertCredentials(CredentialsModel credentialsModel) throws SystemException {
        String query = "INSERT INTO credentials (username, password, type) VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {

            //Imposta i parametri della query
            preparedStatement.setString(1, credentialsModel.getUsername());
            preparedStatement.setString(2, credentialsModel.getPassword());
            preparedStatement.setString(3, credentialsModel.getType().getRoleId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // Stampa un messaggio di errore e lancia una SystemException
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        } catch (SystemException e) {
            throw new IllegalArgumentException(e);
        }
    }



    public Role getRoleByUsername(String username, String password) throws SystemException {
        Role ruolo = null;
        String query = "SELECT type FROM credentials WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                ruolo = Role.fromString(rs.getString("type"));

                return ruolo;

            } else {
                return null;
            }



        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }


    public ClientModel searchUserByUsername(String username) throws SystemException {
        String query = "SELECT id, name, surname, gender, email, username, phone FROM user WHERE username = ?";
        ClientModel clientModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                clientModel = new ClientModel();
                clientModel.setId(rs.getInt("id"));
                clientModel.setName(rs.getString("name"));
                clientModel.setSurname(rs.getString("surname"));
                clientModel.setGender(rs.getString("gender"));
                clientModel.setEmail(rs.getString(EMAIL));
                clientModel.setUsername(rs.getString(USERNAME));
                clientModel.setPhone(rs.getString(PHONE));
            }
            return clientModel;

        } catch (SQLException e) {

            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public boolean checkUsernameAlreadyTaken(String username) throws SystemException {
        String query = "SELECT COUNT(*) > 0 AS exists FROM user WHERE username = ? ";
        try (PreparedStatement prepState = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            prepState.setString(1, username);
            ResultSet rs = prepState.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch (SQLException e){
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
        return false;
    }

    public BarberModel searchBarberByUsername(String username) throws SystemException {
        String query = "SELECT id, username, name, address, city, phone, email  FROM barber WHERE username = ?";
        BarberModel barMod = null;
        try (PreparedStatement prepState = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            prepState.setString(1, username);
            ResultSet rs = prepState.executeQuery();
            if (rs.next()) {
                barMod = new BarberModel();
                barMod.setUsername(rs.getString(USERNAME));
                barMod.setName(rs.getString("name"));
                barMod.setAddress(rs.getString(ADDRESS));
                barMod.setCity(rs.getString("city"));
                barMod.setPhone(rs.getString(PHONE));
                barMod.setEmail(rs.getString(EMAIL));
                barMod.setId(rs.getInt("id"));
            }
            return barMod;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }


    }

    public List<BarberModel> searchAllBarber() throws SystemException {
        List<BarberModel> list = null;
        String query = "SELECT id, username, name, address, city, phone, email  FROM barber";
        list = new ArrayList<>();
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                BarberModel bm = new BarberModel();
                bm.setUsername(rs.getString(USERNAME));
                bm.setName(rs.getString("name"));
                bm.setAddress(rs.getString(ADDRESS));
                bm.setCity(rs.getString("city"));
                bm.setPhone(rs.getString(PHONE));
                bm.setEmail(rs.getString(EMAIL));
                bm.setId(rs.getInt("id"));
                list.add(bm);
            }
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
        return list;
    }


    public List<BarberModel> searchBarberbyName(String name) throws SystemException {
        List<BarberModel> list = null;
        String query = "SELECT id, username, name, address, city, phone, email FROM barber WHERE name LIKE ?";
        list = new ArrayList<>();
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1, name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                BarberModel barMod = new BarberModel();
                barMod.setUsername(rs.getString(USERNAME));
                barMod.setName(rs.getString("name"));
                barMod.setAddress(rs.getString(ADDRESS));
                barMod.setCity(rs.getString("city"));
                barMod.setPhone(rs.getString(PHONE));
                barMod.setEmail(rs.getString(EMAIL));
                barMod.setId(rs.getInt("id"));
                list.add(barMod);
            }
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
        return list;
    }

    //query per prendere i dettagli di un barbiere tramite l'id

    public BarberModel searchBarberById(int id) throws SystemException {
        String query = "SELECT id, username, name, address, city, phone, email FROM barber WHERE id = ?";
        BarberModel modelBarber = new BarberModel();
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                modelBarber.setUsername(rs.getString(USERNAME));
                modelBarber.setName(rs.getString("name"));
                modelBarber.setAddress(rs.getString(ADDRESS));
                modelBarber.setCity(rs.getString("city"));
                modelBarber.setPhone(rs.getString(PHONE));
                modelBarber.setEmail(rs.getString(EMAIL));
                modelBarber.setId(rs.getInt("id"));

            }
            return modelBarber;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }

    }

    public List<ServiceModel> serviceByIdBarber(int id) throws SystemException {
        String query = "SELECT id_barber, servizi, prezzo FROM service WHERE id_barber = ?";
        List<ServiceModel> servModel = new ArrayList<>();
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ServiceModel serviceModel = new ServiceModel();
                serviceModel.setIdBarber(rs.getInt("id_barber"));
                serviceModel.setNomeServizio(rs.getString("servizi"));
                serviceModel.setPrezzo(rs.getInt("prezzo"));
                servModel.add(serviceModel);
            }
            return servModel;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    //query per prendere i dettagli di un Moderator tramite Username
    public ModeratorModel searchModeratorByUsername(String username) throws SystemException {

        String query = "SELECT id, username, name, email, phone FROM moderator WHERE username = ?";
        ModeratorModel moderatorModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                moderatorModel = new ModeratorModel();
                moderatorModel.setUsername(rs.getString(USERNAME));
                moderatorModel.setName(rs.getString("name"));
                moderatorModel.setEmail(rs.getString(EMAIL));
                moderatorModel.setPhone(rs.getString(PHONE));
                moderatorModel.setId(rs.getInt("id"));
            }
            return moderatorModel;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public void insertAppointments(RequestAppointmentsModel requestAppointmentsModel) throws SystemException {
        String query = "INSERT INTO appointments (idbarber, idutente, data, name_user, name_barber, description, address_barber, service, state, orario, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            ps.setInt(1, requestAppointmentsModel.getIdBarber());
            ps.setInt(2, requestAppointmentsModel.getIdUser());
            ps.setDate(3, java.sql.Date.valueOf(requestAppointmentsModel.getDate()));
            ps.setString(4, requestAppointmentsModel.getNameUser());
            ps.setString(5, requestAppointmentsModel.getNameBarber());
            ps.setString(6, requestAppointmentsModel.getDescription());
            ps.setString(7, requestAppointmentsModel.getAddressBarber());
            ps.setString(8, requestAppointmentsModel.getService());
            ps.setString(9, requestAppointmentsModel.getState().getId());
            ps.setString(10, requestAppointmentsModel.getOrario());
            ps.setString(11, requestAppointmentsModel.getPhone());

            ps.executeUpdate();
        } catch (SQLException | SystemException e) {
            SystemException exception = new SystemException();
            ErrorDialog.getInstance().handleException(e);
            exception.initCause(e);
            throw exception;
        }
    }


    public RequestAppointmentsModel searchAppointmentsById(int id)throws SystemException{
        String query = "SELECT idAppointments, idbarber, idutente, data, name_user, name_barber, description, address_barber, state ,service, orario, phone  FROM appointments WHERE idBarber = ?";
        try (PreparedStatement pStmt = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                RequestAppointmentsModel ram = new RequestAppointmentsModel();
                ram.setAppId(rs.getInt("idAppointments"));
                ram.setIdUser(rs.getInt("idUtente"));
                ram.setIdBarber(rs.getInt("idbarber"));
                Date sqlDate = rs.getDate("data");
                ram.setDate(sqlDate.toLocalDate());
                ram.setNameUser(rs.getString("name_user"));
                ram.setNameBarber(rs.getString("name_barber"));
                ram.setDescription(rs.getString("description"));
                ram.setAddressBarber(rs.getString("address_barber"));
                ram.setService(rs.getString("service"));
                ram.setOrario(rs.getString("orario"));
                ram.setPhone(rs.getString(PHONE));
                StatoRichieste stato = StatoRichieste.fromString(rs.getString("state"));
                ram.setState(stato);

            }
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            ErrorDialog.getInstance().handleException(e);
            throw exception;
        }
        return new RequestAppointmentsModel();
    }

    public void insertRecensione(RecensioneModel recensioneModel) throws SystemException {
        String query = "INSERT INTO review (id_appuntamento, fk_user, star_review, note_review,created_at) VALUES (?, ?, ?, ?,?)";

        try (PreparedStatement ps = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            ps.setInt(1, recensioneModel.getIdAppuntamento());
            ps.setInt(2, recensioneModel.getIdCliente());
            ps.setInt(3, recensioneModel.getVoto());
            ps.setString(4, recensioneModel.getTesto());
            ps.setTimestamp(5, recensioneModel.getCreatedAt()  );

            ps.executeUpdate();
        } catch (SQLException | SystemException e) {
            SystemException exception = new SystemException();
            ErrorDialog.getInstance().handleException(e);
            exception.initCause(e);
            throw exception;
        }
    }


    public List<RecensioneModel> getMyRecensioni(int id) throws SystemException {
        String query = "SELECT id_appuntamento, fk_user, star_review, note_review, created_at, barber.name AS nome_barbiere FROM review JOIN appointments ON review.id_appuntamento = appointments.idAppointments JOIN barber ON appointments.idbarber = barber.id WHERE appointments.idUtente = ?";
        List<RecensioneModel> recensioneModels = new ArrayList<>();
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RecensioneModel recensioneModel = new RecensioneModel();
                recensioneModel.setIdAppuntamento(rs.getInt("id_appuntamento"));
                recensioneModel.setIdCliente(rs.getInt("fk_user"));
                recensioneModel.setVoto(rs.getInt("star_review"));
                recensioneModel.setTesto(rs.getString("note_review"));
                recensioneModel.setNomeBarbiere(rs.getString(6));
                recensioneModel.setCreatedAt(rs.getTimestamp("created_at"));
                recensioneModels.add(recensioneModel);
            }
            return recensioneModels;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public List<RecensioneModel> getMyRecensioniBarbiere(int id) throws SystemException {
        String query = "SELECT id_review, id_appuntamento, fk_user, star_review, note_review, created_at, user.name AS nome_cliente FROM review JOIN appointments ON review.id_appuntamento = appointments.idAppointments JOIN user ON appointments.idUtente = user.id WHERE appointments.idBarber = ?";
        List<RecensioneModel> recensioneModels = new ArrayList<>();
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RecensioneModel recensioneModel = new RecensioneModel();
                recensioneModel.setIdRecensione(rs.getInt("id_review"));
                recensioneModel.setIdAppuntamento(rs.getInt("id_appuntamento"));
                recensioneModel.setIdCliente(rs.getInt("fk_user"));
                recensioneModel.setVoto(rs.getInt("star_review"));
                recensioneModel.setTesto(rs.getString("note_review"));
                recensioneModel.setNomeCliente(rs.getString(7));
                recensioneModel.setCreatedAt(rs.getTimestamp("created_at"));
                recensioneModels.add(recensioneModel);
            }
            return recensioneModels;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }


    public void reportRecensione(int idRecensione) throws SystemException {
        String query = "UPDATE review SET report = 1 WHERE id_review = ?";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idRecensione);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public List<RecensioneModel> getReportedRecensioni() throws SystemException {
        String query = "SELECT id_review, id_appuntamento, fk_user, star_review, note_review, created_at, " +
                "user.name AS nome_cliente, barber.name AS nome_barbiere " +
                "FROM review " +
                "JOIN appointments ON review.id_appuntamento = appointments.idAppointments " +
                "JOIN user ON appointments.idUtente = user.id " +
                "JOIN barber ON appointments.idBarber = barber.id " +
                "WHERE review.report = 1";
        List<RecensioneModel> recensioneModels = new ArrayList<>();
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RecensioneModel recensioneModel = new RecensioneModel();
                recensioneModel.setIdRecensione(rs.getInt("id_review"));
                recensioneModel.setIdAppuntamento(rs.getInt("id_appuntamento"));
                recensioneModel.setIdCliente(rs.getInt("fk_user"));
                recensioneModel.setVoto(rs.getInt("star_review"));
                recensioneModel.setTesto(rs.getString("note_review"));
                recensioneModel.setNomeCliente(rs.getString("nome_cliente"));
                recensioneModel.setNomeBarbiere(rs.getString("nome_barbiere"));
                recensioneModel.setCreatedAt(rs.getTimestamp("created_at"));
                recensioneModels.add(recensioneModel);
            }
            return recensioneModels;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public void approveRecensione(int idRecensione) throws SystemException {
        String query = "UPDATE review SET report = 0 WHERE id_review = ?";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idRecensione);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public void deleteRecensione(int idRecensione) throws SystemException {
        String query = "DELETE FROM review WHERE id_review = ?";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idRecensione);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }




}