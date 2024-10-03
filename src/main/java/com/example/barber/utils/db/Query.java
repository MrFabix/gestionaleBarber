package com.example.barber.utils.db;

import com.example.barber.model.BarberModel;
import com.example.barber.model.UserModel;
import com.example.barber.utils.exception.myecxeption.SystemException;
import com.example.barber.model.CredentialsModel;

public class Query {

        public boolean searchUserInLogged(CredentialsModel credentialsModel) throws SystemException {

            return false;
        }

       public UserModel searchUserByUsername(String username) throws SystemException {
            System.out.println("Query.searchUserByUsername");
            return null;
        }
    public boolean checkUsernameAlreadyTaken(String username) throws SystemException {
        return false;
        //implentare query
    }

    public BarberModel searchBarberByUsername(String username) throws SystemException {
        return null;
        //implentare query
    }


    }
