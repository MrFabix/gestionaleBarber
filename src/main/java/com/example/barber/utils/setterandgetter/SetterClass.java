package com.example.barber.utils.setterandgetter;

import com.example.barber.model.BarberModel;
import com.example.barber.model.ClientModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.ClientBean;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.bean.interfaccia1.BarberBean1;
import com.example.barber.utils.exception.myexception.*;

public class SetterClass{
    public void setBarber(BarberBean barberBean, BarberBean1 barberBean1) throws EmptyInputException, UsernameAlreadyTakenException, EmailNotValidException, SystemException {
        barberBean1.setId(barberBean.getId());
        barberBean1.setName(barberBean.getName());
        barberBean1.setEmail(barberBean.getEmail());
        barberBean1.setPhone(barberBean.getPhone());
        barberBean1.setUsername(barberBean.getUsername());
        barberBean1.setAddress(barberBean.getAddress());
        barberBean1.setOrarioInizio(barberBean.getOrarioInizio());
        barberBean1.setOrarioFine(barberBean.getOrarioFine());
        barberBean1.setCity(barberBean.getCity());
        barberBean1.setDescription(barberBean.getDescription());
        barberBean1.setServices(barberBean.getServices());
    }

    public void setBarberBeanFromModel(BarberBean barberBean, BarberModel barberModel) throws EmptyInputException, UsernameAlreadyTakenException, EmailNotValidException, SystemException {
        barberBean.setId(barberModel.getId());
        barberBean.setName(barberModel.getName());
        barberBean.setEmail(barberModel.getEmail());
        barberBean.setPhone(barberModel.getPhone());
        barberBean.setUsername(barberModel.getUsername());
        barberBean.setAddress(barberModel.getAddress());
        barberBean.setOrarioInizio(barberModel.getOrarioInizio());
        barberBean.setOrarioFine(barberModel.getOrarioFine());
        barberBean.setCity(barberModel.getCity());
        barberBean.setDescription(barberModel.getDescription());
        barberBean.setServices(barberModel.getServices());
    }

    public void setClientBeanFromModel(ClientBean clientBean, ClientModel clientModel) throws EmptyInputException, UsernameAlreadyTakenException, EmailNotValidException, SystemException {
        clientBean.setId(clientModel.getId());
        clientBean.setName(clientModel.getName());
        clientBean.setEmail(clientModel.getEmail());
        clientBean.setPhone(clientModel.getPhone());
        clientBean.setUsername(clientModel.getUsername());
        clientBean.setSurname(clientModel.getSurname());
        clientBean.setGender(clientModel.getGender());

    }

    public void setCredentialsBeanFromCredentialsModel(CredentialsBean credentialsBean, CredentialsModel credentialsModel) throws EmptyInputException, PasswordNotCompliantException {
        System.out.println("Dentro setterClass "+ credentialsModel.getUsername());
        credentialsBean.setUsername(credentialsModel.getUsername());
        credentialsBean.setPassword(credentialsModel.getPassword());
        credentialsBean.setType(credentialsModel.getType());
        System.out.println("Dentro setterClass "+ credentialsBean.getUsername());
    }

    public void setCredentialsModelFromCredentialsBean(CredentialsModel credentialsModel, CredentialsBean credentialsBean) throws EmptyInputException, PasswordNotCompliantException {
        credentialsModel.setUsername(credentialsBean.getUsername());
        credentialsModel.setPassword(credentialsBean.getPassword());
        credentialsModel.setType(credentialsBean.getType());
    }

    public void setBarberModelFromBarberBean(BarberModel barberModel, BarberBean barberBean){
        barberModel.setId(barberBean.getId());
        barberModel.setName(barberBean.getName());
        barberModel.setEmail(barberBean.getEmail());
        barberModel.setPhone(barberBean.getPhone());
        barberModel.setUsername(barberBean.getUsername());
        barberModel.setAddress(barberBean.getAddress());
        barberModel.setOrarioInizio(barberBean.getOrarioInizio());
        barberModel.setOrarioFine(barberBean.getOrarioFine());
        barberModel.setCity(barberBean.getCity());
        barberModel.setDescription(barberBean.getDescription());
        barberModel.setServices(barberBean.getServices());
    }

    public void setClientModelFromClientBean(ClientBean clientBean, ClientModel clientModel) throws EmptyInputException, UsernameAlreadyTakenException, EmailNotValidException, SystemException {
        clientModel.setId(clientBean.getId());
        clientModel.setName(clientBean.getName());
        clientModel.setEmail(clientBean.getEmail());
        clientModel.setPhone(clientBean.getPhone());
        clientModel.setUsername(clientBean.getUsername());
        clientModel.setSurname(clientBean.getSurname());
        clientModel.setGender(clientBean.getGender());

    }
}
