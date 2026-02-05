package com.example.barber.utils.setterandgetter;

import com.example.barber.model.*;
import com.example.barber.utils.bean.*;
import com.example.barber.utils.exception.myexception.*;

public class SetterClass{

    public void setBarber(BarberBean barberBean, BarberBean barberBean1) throws EmptyInputException, EmailNotValidException{
        barberBean1.setId(barberBean.getId());
        barberBean1.setName(barberBean.getName());
        barberBean1.setEmail(barberBean.getEmail());
        barberBean1.setPhone(barberBean.getPhone());
        barberBean1.setUsernameLog(barberBean.getUsername());
        barberBean1.setAddress(barberBean.getAddress());
        barberBean1.setOrarioInizio(barberBean.getOrarioInizio());
        barberBean1.setOrarioFine(barberBean.getOrarioFine());
        barberBean1.setCity(barberBean.getCity());
        barberBean1.setDescription(barberBean.getDescription());
        barberBean1.setServices(barberBean.getServices());
    }

    public void setBarberBeanFromModel(BarberBean barberBean, BarberModel barberModel) throws EmptyInputException, EmailNotValidException{
        barberBean.setId(barberModel.getId());
        barberBean.setName(barberModel.getName());
        barberBean.setEmail(barberModel.getEmail());
        barberBean.setPhone(barberModel.getPhone());
        barberBean.setUsernameLog(barberModel.getUsername());
        barberBean.setAddress(barberModel.getAddress());
        barberBean.setOrarioInizio(barberModel.getOrarioInizio());
        barberBean.setOrarioFine(barberModel.getOrarioFine());
        barberBean.setCity(barberModel.getCity());
        barberBean.setDescription(barberModel.getDescription());
        barberBean.setServices(barberModel.getServices());
    }

    public void setClientBeanFromModel(ClientBean clientBean, ClientModel clientModel) throws EmptyInputException, EmailNotValidException{
        clientBean.setId(clientModel.getId());
        clientBean.setName(clientModel.getName());
        clientBean.setEmail(clientModel.getEmail());
        clientBean.setPhone(clientModel.getPhone());
        clientBean.setUsernameLog(clientModel.getUsername());
        clientBean.setSurname(clientModel.getSurname());
        clientBean.setGender(clientModel.getGender());

    }

    public void setCredentialsBeanFromCredentialsModel(CredentialsBean credentialsBean, CredentialsModel credentialsModel) throws EmptyInputException {
        credentialsBean.setUsername(credentialsModel.getUsername());
        credentialsBean.setPassword(credentialsModel.getPassword());
        credentialsBean.setType(credentialsModel.getType());
    }

    public void setCredentialsModelFromCredentialsBean(CredentialsModel credentialsModel, CredentialsBean credentialsBean){
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

    public void setClientModelFromClientBean(ClientBean clientBean, ClientModel clientModel){
        clientModel.setId(clientBean.getId());
        clientModel.setName(clientBean.getName());
        clientModel.setEmail(clientBean.getEmail());
        clientModel.setPhone(clientBean.getPhone());
        clientModel.setUsername(clientBean.getUsername());
        clientModel.setSurname(clientBean.getSurname());
        clientModel.setGender(clientBean.getGender());

    }

    public void setRequestApp(RequestAppointmentsBean rBean, RequestAppointmentsBean requestAppointmentsBean1){
        rBean.setIdAppointement(requestAppointmentsBean1.getIdAppointement());
        rBean.setIdBarber(requestAppointmentsBean1.getIdBarber());
        rBean.setIdUser(requestAppointmentsBean1.getIdUser());
        rBean.setDateRaw(requestAppointmentsBean1.getDate());
        rBean.setNameUser(requestAppointmentsBean1.getNameUser());
        rBean.setAddressBarber(requestAppointmentsBean1.getAddressBarber());
        rBean.setDescription(requestAppointmentsBean1.getDescription());
        rBean.setService(requestAppointmentsBean1.getService());
        rBean.setPhoneUser(requestAppointmentsBean1.getPhoneUser());
        rBean.setState(requestAppointmentsBean1.getState());
        rBean.setOrario(requestAppointmentsBean1.getOrario());
        rBean.setNameBarber(requestAppointmentsBean1.getNameBarber());
    }

    public void setRequestAppBeanFromModel(RequestAppointmentsBean requestAppointmentsBean, RequestAppointmentsModel model){
        requestAppointmentsBean.setIdAppointement(model.getAppId());
        requestAppointmentsBean.setIdBarber(model.getIdBarber());
        requestAppointmentsBean.setIdUser(model.getIdUser());
        requestAppointmentsBean.setDateRaw(model.getDate());
        requestAppointmentsBean.setNameUser(model.getNameUser());
        requestAppointmentsBean.setAddressBarber(model.getAddressBarber());
        requestAppointmentsBean.setDescription(model.getDescription());
        requestAppointmentsBean.setService(model.getService());
        requestAppointmentsBean.setPhoneUser(model.getPhone());
        requestAppointmentsBean.setState(model.getState());
        requestAppointmentsBean.setOrario(model.getOrario());
        requestAppointmentsBean.setNameBarber(model.getNameBarber());
    }

    public void setRequestModelFromBean(RequestAppointmentsModel model, RequestAppointmentsBean bean){
        model.setAppId(bean.getIdAppointement());
        model.setIdBarber(bean.getIdBarber());
        model.setIdUser(bean.getIdUser());
        model.setDate(bean.getDate());
        model.setNameUser(bean.getNameUser());
        model.setAddressBarber(bean.getAddressBarber());
        model.setDescription(bean.getDescription());
        model.setService(bean.getService());
        model.setPhone(bean.getPhoneUser());
        model.setState(bean.getState());
        model.setOrario(bean.getOrario());
        model.setNameBarber(bean.getNameBarber());
    }

    public void setServiceBeanFromModel(ServiceBean serviceBean, ServiceModel model){
        serviceBean.setIdBarber(model.getIdBarber());
        serviceBean.setNomeServizio(model.getNomeServizio());
        serviceBean.setPrezzo(model.getPrezzo());
    }


    public void setRecensioneBeanFromModel(RecensioneBean recensioneBean, RecensioneModel model) {
        recensioneBean.setTesto(model.getTesto());
        recensioneBean.setIdCliente(model.getIdCliente());
        recensioneBean.setIdAppuntamento(model.getIdAppuntamento());
        recensioneBean.setCreatedAt(model.getCreatedAt());
        recensioneBean.setNomeBarbiere(model.getNomeBarbiere());
        recensioneBean.setNomeCliente(model.getNomeCliente());
        recensioneBean.setIdRecensione(model.getIdRecensione());
        recensioneBean.setVoto(model.getVoto());

    }


    public void setRecensione(RecensioneBean bean, RecensioneBean recensioneBean) {
        bean.setTesto(recensioneBean.getTesto());
        bean.setIdCliente(recensioneBean.getIdCliente());
        bean.setIdAppuntamento(recensioneBean.getIdAppuntamento());
        bean.setCreatedAt(recensioneBean.getCreatedAt());
        bean.setVoto(recensioneBean.getVoto());
        bean.setNomeCliente(recensioneBean.getNomeCliente());
        bean.setIdRecensione(recensioneBean.getIdRecensione());
        bean.setNomeBarbiere(recensioneBean.getNomeBarbiere());
    }
}
