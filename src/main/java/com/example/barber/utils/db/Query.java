package com.example.barber.utils.db;

import com.example.barber.model.BarberModel;
import com.example.barber.model.UserModel;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.model.CredentialsModel;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query {
    //TODO metodo per l'inserimento di un utente
    /*public void insertUser(UserModel userModel) throws SystemException{
        String query = "INSERT INTO `user`(`username`,`password`,`email`,`ruolo`) VALUES(?,?,?,?);";
        try(PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)){
            preparedStatement.setString(1, UserModel.);
        }
    }*/
    public boolean searchUserInLogged(CredentialsModel credentialsModel) throws SystemException {

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







    public void insertCredentials(){
        //TODO IMPLEMENTARE IL PORCO DUE DI INSERIMENTO (ALE)
    }
}