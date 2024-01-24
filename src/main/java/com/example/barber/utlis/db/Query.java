package com.example.barber.utlis.db;

import com.example.barber.model.UserModel;
import com.example.barber.utlis.exception.myecxeption.SystemException;
import com.example.barber.model.CredentialsModel;

public class Query {

        public boolean searchUserInLogged(CredentialsModel credentialsModel) throws SystemException {
            return false;
        }

       public UserModel searchUserByUsername(String username) throws SystemException {
            return null;
            //implentare query
        }
    public boolean checkUsernameAlreadyTaken(String username) throws SystemException {
        return false;
        //implentare query
    }



    }
