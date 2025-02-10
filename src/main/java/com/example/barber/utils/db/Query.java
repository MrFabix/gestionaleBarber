package com.example.barber.utils.db;

import com.example.barber.model.BarberModel;
import com.example.barber.model.ModeratorModel;
import com.example.barber.model.UserModel;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.model.CredentialsModel;

import javax.swing.text.Style;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query {
    public void insertBarber(BarberModel barberModel) throws SystemException{
        System.out.print("Stai inserendo il barbieree");
        String query = "INSERT INTO barber (username, name, address, city, phone, email) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)){
            //Impostiamo i parametri della query
            System.out.println("Username del barbiere"+ barberModel.getUsername());
            preparedStatement.setString(1, barberModel.getUsername());
            System.out.println("Name del barbiere"+ barberModel.getName());
            preparedStatement.setString(2, barberModel.getName());
            System.out.println("address del barbiere"+ barberModel.getAddress());
            preparedStatement.setString(3, barberModel.getAddress());
            System.out.println("city del barbiere"+ barberModel.getCity());
            preparedStatement.setString(4, barberModel.getCity());
            System.out.println("phone del barbiere"+ barberModel.getPhone());
            preparedStatement.setString(5, barberModel.getPhone());
            System.out.println("email del barbiere"+ barberModel.getEmail());
            preparedStatement.setString(6, barberModel.getEmail());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 0){
                System.out.print("Il numero di riche inserite è 0");

            }

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        } catch (SystemException e ){
            throw new RuntimeException(e);
        }


    }


    public void insertUser(UserModel userModel) throws SystemException {
        System.out.print("stai inserendo lo user sei dentro il metodo");
        String query = "INSERT INTO user (name, surname, gender, email, username, phone) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)){

            //Imposta i parametri della query
            preparedStatement.setString(1, userModel.getName());
            preparedStatement.setString(2, userModel.getSurname());

            preparedStatement.setString(3, userModel.getGender());
            preparedStatement.setString(4, userModel.getEmail());
            preparedStatement.setString(5, userModel.getUsername());
            preparedStatement.setString(6, userModel.getPhone());
            int rowsAffected = preparedStatement.executeUpdate();
            //TODO domanda da fare al pellegrini???
            if (rowsAffected == 0) {
                System.out.println("Il numero di righe inserite è 0 c'è un errore");
            }else{

                System.out.println("i dati sono inseriti ");
            }
        }catch(SQLException e){

            System.out.println("Errore nella ricerca dell'utente nel database");
            // Stampa un messaggio di errore e lancia una SystemException

            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;

        } catch (SystemException e) {
            throw new RuntimeException(e);
        }


        //TODO manca da implementare l'inserimento di un immagine del profilo
    }

    public void insertCredential(CredentialsModel credentialsModel) throws SystemException {
        String query = "INSERT INTO credentials (username, password, type) VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)){

            //Imposta i parametri della query
            System.out.println("Sei nell'insert credential "+ credentialsModel.getUsername());
            preparedStatement.setString(1, credentialsModel.getUsername());
            preparedStatement.setString(2, credentialsModel.getPassword());
            preparedStatement.setString(3, credentialsModel.getType());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("Il numero di righe inserite è 0 c'è un errore");
            }else{

                System.out.println("i dati sono inseriti ");
            }

        }catch(SQLException e){

            System.out.println("Errore nell'inserimento dell'utente nel database");
            // Stampa un messaggio di errore e lancia una SystemException
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;

        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }



    public boolean searchUserInLogged(CredentialsModel credentialsModel) throws SystemException {

        System.out.println("Stai cercando l'utente nel database");

        // Correggi la query SQL con il segno di uguaglianza per la password
        String query = "SELECT * FROM credentials WHERE username = ? AND password = ? AND type = ?";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            // Imposta i parametri della query
            preparedStatement.setString(1, credentialsModel.getUsername());
            preparedStatement.setString(2, credentialsModel.getPassword());
            preparedStatement.setString(3, credentialsModel.getType());
            //stampo il risultato della query
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Errore nella ricerca dell'utente nel database");
            // Stampa un messaggio di errore e lancia una SystemException
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public UserModel searchUserByUsername(String username) throws SystemException {
        System.out.println("Stai cercando l'utente nel database");
        String query = "SELECT * FROM user WHERE username = ?";
        UserModel userModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                userModel = new UserModel();
                userModel.setUsername(rs.getString("username"));
                userModel.setSurname(rs.getString("surname"));
                userModel.setName(rs.getString("name"));
                userModel.setGender(rs.getString("gender"));
                userModel.setEmail(rs.getString("email"));
                userModel.setId(rs.getInt("id"));

            }
            return userModel;

        } catch (SQLException e) {

            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public boolean checkUsernameAlreadyTaken(String username) throws SystemException {
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
                barberModel.setUsername(rs.getString("username"));
                barberModel.setName(rs.getString("name"));
                barberModel.setAddress(rs.getString("address"));
                barberModel.setCity(rs.getString("city"));
                barberModel.setPhone(rs.getString("phone"));
                barberModel.setEmail(rs.getString("email"));
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
        List<BarberModel>   list = null;
        String query = "SELECT * FROM barber";
        list = new ArrayList<>();
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                BarberModel barberModel = new BarberModel();
                barberModel.setUsername(rs.getString("username"));
                barberModel.setName(rs.getString("name"));
                barberModel.setAddress(rs.getString("address"));
                barberModel.setCity(rs.getString("city"));
                barberModel.setPhone(rs.getString("phone"));
                barberModel.setEmail(rs.getString("email"));
                barberModel.setId(rs.getInt("id"));
                list.add(barberModel);
            }
        }
        catch (SQLException e) {
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
                barberModel.setUsername(rs.getString("username"));
                barberModel.setName(rs.getString("name"));
                barberModel.setAddress(rs.getString("address"));
                barberModel.setCity(rs.getString("city"));
                barberModel.setPhone(rs.getString("phone"));
                barberModel.setEmail(rs.getString("email"));
                barberModel.setId(rs.getInt("id"));
                list.add(barberModel);
            }
        }
        catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
        return list;
    }

    //query per prendere i dettagli di un barbiere tramite l'id

    public BarberModel searchBarberById(int id) throws SystemException {
        String query = "SELECT * FROM barber WHERE id = ?";
        BarberModel barberModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                barberModel = new BarberModel();
                barberModel.setUsername(rs.getString("username"));
                barberModel.setName(rs.getString("name"));
                barberModel.setAddress(rs.getString("address"));
                barberModel.setCity(rs.getString("city"));
                barberModel.setPhone(rs.getString("phone"));
                barberModel.setEmail(rs.getString("email"));
                barberModel.setId(rs.getInt("id"));
            }
            return barberModel;
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
                moderatorModel.setUsername(rs.getString("username"));
                moderatorModel.setName(rs.getString("name"));
                moderatorModel.setEmail(rs.getString("email"));
                moderatorModel.setPhone(rs.getString("phone"));
                moderatorModel.setId(rs.getInt("id"));
            }
            return moderatorModel;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }







    public void insertCredentials(){
        //TODO IMPLEMENTARE IL PORCO DUE DI INSERIMENTO (ALE)
    }
}