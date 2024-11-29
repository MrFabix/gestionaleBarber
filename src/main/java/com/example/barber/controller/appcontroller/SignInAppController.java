package com.example.barber.controller.appcontroller;

import com.example.barber.model.CredentialsModel;
import com.example.barber.model.UserModel;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.bean.UserBean;
import com.example.barber.utils.dao.UserDAO;
import com.example.barber.utils.exception.myexception.SystemException;

public class SignInAppController {

    public void registerUser(UserBean userBean, CredentialsBean credentialsBean) throws SystemException {

        //Ora ho capito, utilizziamo il credential bean per settare i campi di un model, nel nostro caso il
        //credential model, in questa maniera, il model è "oscurato", perchè perche noi usiamo il credentialModel costructor
        //Attraverso il credential model costructor, creiamo l'entità che poi andrà ad essere salvata su database attraverso il DAO

        CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);

        //Stessa cosa per lo userModel
        UserModel userModel = new UserModel(userBean);


        UserDAO userDAO = new UserDAO();
        userDAO.addUser(credentialsModel, userModel);

    }

}
