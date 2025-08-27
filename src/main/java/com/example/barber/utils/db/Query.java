package com.example.barber.utils.db;


import com.example.barber.model.*;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.ruoli.Role;
import com.example.barber.utils.statorichiesta.StatoRichieste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query {

    private static final String USERNAME = "username";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";



    public void insertOrarioDB(BarberModel barberModel) throws SystemException {
        String query = "INSERT INTO working_hours (id_barber, orarioInizio, orarioFine) VALUES (?,?,?)";
        try (PreparedStatement preparedStatement =
                     MySqlConnection.getInstance().connect().prepareStatement(query)) {

            preparedStatement.setInt(1, barberModel.getId());
            preparedStatement.setString(2, barberModel.getOrarioInizio());
            preparedStatement.setString(3, barberModel.getOrarioFine());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        } catch (SystemException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public RequestAppointmentsModel searchAppointmentsById(int id)throws SystemException{
        String query = "SELECT * FROM appointments WHERE idBarber = ?";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
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


    //Restituzione Lista appuntamenti pendenti
    public List<RequestAppointmentsModel> searchAllAppointmentsById(int id, String role) throws SystemException {
        String query = switch (role) {
            case "BARBIERE" -> query = "SELECT appointments.idAppointments ,appointments.idbarber, appointments.idutente, appointments.data, " +
                    "appointments.name_user, appointments.name_barber, appointments.description, " +
                    "appointments.address_barber, appointments.service, appointments.state, " +
                    "appointments.orario, appointments.phone " +
                    "FROM appointments WHERE idBarber = ?";

            case "CLIENTE" -> query = "SELECT appointments.idAppointments ,appointments.idbarber, appointments.idutente, appointments.data, " +
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
                listRequestAppModel.add(ram);

            }
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            ErrorDialog.getInstance().handleException(e);
            throw exception;
        }
        return listRequestAppModel;
    }

    public void updateAppointmentById(int appointmentId, String newState) throws SystemException {
        final String sql = "UPDATE appointments SET state = ? WHERE idAppointments = ?"; // o appoitments

        try (PreparedStatement ps = MySqlConnection.getInstance().connect().prepareStatement(sql)) {
            ps.setString(1, newState);   // "ACCETTATA" | "RIFIUTATA" | "PENDENTE"
            ps.setInt(2, appointmentId);

            int rows = ps.executeUpdate();
            if (rows != 1) {
                throw new SQLException("Nessuna riga aggiornata (id=" + appointmentId + ")");
            }
        } catch (SQLException e) {
            SystemException ex = new SystemException();
            ex.initCause(e);
            throw ex;
        }
    }


    public void deleteService(ServiceModel serviceModel) throws SystemException {
            String query = "DELETE FROM service WHERE id_barber = ? AND servizi = ? AND prezzo = ?";
            try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {

                preparedStatement.setInt(1, serviceModel.getId_barber());
                preparedStatement.setString(2, serviceModel.getNome_servizio());
                preparedStatement.setDouble(3, serviceModel.getPrezzo());

                preparedStatement.executeUpdate();

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
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, serviceModel.getId_barber());
            preparedStatement.setString(2, serviceModel.getNome_servizio());
            preparedStatement.setDouble(3, serviceModel.getPrezzo());

            preparedStatement.executeUpdate();

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


    public boolean searchUserInLogged(CredentialsModel credentialsModel) throws SystemException {
        String query = "SELECT * FROM credentials WHERE username = ? AND password = ? AND type = ?";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            // Imposta i parametri della query
            preparedStatement.setString(1, credentialsModel.getUsername());
            preparedStatement.setString(2, credentialsModel.getPassword());
            preparedStatement.setString(3, credentialsModel.getType().getRoleId());
            //stampo il risultato della query
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public Role getRoleByUsername(String username, String password) throws SystemException {
        Role ruolo = null;
        String query = "SELECT * FROM credentials WHERE username = ? AND password = ?";
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
        String query = "SELECT * FROM user WHERE username = ?";
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

    public boolean checkUsernameAlreadyTaken(){
        return false;
    }

    public BarberModel searchBarberByUsername(String username) throws SystemException {
        String query = "SELECT * FROM barber WHERE username = ?";
        BarberModel barberModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                barberModel = new BarberModel();
                barberModel.setUsername(rs.getString(USERNAME));
                barberModel.setName(rs.getString("name"));
                barberModel.setAddress(rs.getString(ADDRESS));
                barberModel.setCity(rs.getString("city"));
                barberModel.setPhone(rs.getString(PHONE));
                barberModel.setEmail(rs.getString(EMAIL));
                barberModel.setId(rs.getInt("id"));
            }
            return barberModel;


        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }


    }

    public List<BarberModel> searchAllBarber() throws SystemException {
        List<BarberModel> list = null;
        String query = "SELECT * FROM barber";
        list = new ArrayList<>();
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                BarberModel barberModel = new BarberModel();
                barberModel.setUsername(rs.getString(USERNAME));
                barberModel.setName(rs.getString("name"));
                barberModel.setAddress(rs.getString(ADDRESS));
                barberModel.setCity(rs.getString("city"));
                barberModel.setPhone(rs.getString(PHONE));
                barberModel.setEmail(rs.getString(EMAIL));
                barberModel.setId(rs.getInt("id"));
                list.add(barberModel);
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
        String query = "SELECT * FROM barber WHERE name LIKE ?";
        list = new ArrayList<>();
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1, name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                BarberModel barberModel = new BarberModel();
                barberModel.setUsername(rs.getString(USERNAME));
                barberModel.setName(rs.getString("name"));
                barberModel.setAddress(rs.getString(ADDRESS));
                barberModel.setCity(rs.getString("city"));
                barberModel.setPhone(rs.getString(PHONE));
                barberModel.setEmail(rs.getString(EMAIL));
                barberModel.setId(rs.getInt("id"));
                list.add(barberModel);
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
        String query = "SELECT * FROM barber WHERE id = ?";
        BarberModel barberModel = new BarberModel();
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                barberModel.setUsername(rs.getString(USERNAME));
                barberModel.setName(rs.getString("name"));
                barberModel.setAddress(rs.getString(ADDRESS));
                barberModel.setCity(rs.getString("city"));
                barberModel.setPhone(rs.getString(PHONE));
                barberModel.setEmail(rs.getString(EMAIL));
                barberModel.setId(rs.getInt("id"));

            }
            return barberModel;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }

    }

    public List<ServiceModel> serviceByIdBarber(int id) throws SystemException {
        String query = "SELECT * FROM service WHERE id_barber = ?";
        List<ServiceModel> serviceModels = new ArrayList<>();
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ServiceModel serviceModel = new ServiceModel();
                serviceModel.setId_barber(rs.getInt("id_barber"));
                serviceModel.setNome_servizio(rs.getString("servizi"));
                serviceModel.setPrezzo(rs.getInt("prezzo"));
                serviceModels.add(serviceModel);
            }
            return serviceModels;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    //query per prendere i dettagli di un Moderator tramite Username
    public ModeratorModel searchModeratorByUsername(String username) throws SystemException {

        String query = "SELECT * FROM moderator WHERE username = ?";
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
        String query = "INSERT INTO appointments (" +
                "idbarber, idutente, data, name_user, name_barber, description, address_barber, " +
                "service, state, orario, phone) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            ps.setInt(1, requestAppointmentsModel.getIdBarber());
            ps.setInt(2, requestAppointmentsModel.getIdUser());
            ps.setDate(3, java.sql.Date.valueOf(requestAppointmentsModel.getDate())); // LocalDate → java.sql.Date
            ps.setString(4, requestAppointmentsModel.getNameUser());
            ps.setString(5, requestAppointmentsModel.getNameBarber());
            ps.setString(6, requestAppointmentsModel.getDescription());
            ps.setString(7, requestAppointmentsModel.getAddressBarber());
            ps.setString(8, requestAppointmentsModel.getService());
            ps.setString(9, requestAppointmentsModel.getState().name()); // enum → stringa
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
}