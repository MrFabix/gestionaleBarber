package com.example.barber.utils.db;

import com.example.barber.model.BarberModel;
import com.example.barber.model.UserModel;
import com.example.barber.utils.exception.myecxeption.SystemException;
import com.example.barber.model.CredentialsModel;

import java.sql.*;
public class Query {

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
               try(PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
                     preparedStatement.setString(1, username);
                     ResultSet rs = preparedStatement.executeQuery();
                     if (rs.next()) {
                          userModel = new UserModel();
                          userModel.setUsername(rs.getString("username"));
                          userModel.setSurname(rs.getString("surname"));
                          userModel.setName(rs.getString("name"));
                          userModel.setGender(rs.getString("gender"));
                          userModel.setEmail(rs.getString("email"));
                     }
                     return userModel;

               }catch (SQLException e) {
                   SystemException exception = new SystemException();
                   exception.initCause(e);
                   throw exception;
               }
        }
    public boolean checkUsernameAlreadyTaken(String username) throws SystemException {
        return false;
    }

    public BarberModel searchBarberByUsername(String username) throws SystemException {
        return null;

    }


    }
