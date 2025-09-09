package com.example.barber.utils.dao.demo;


import com.example.barber.model.*;
import com.example.barber.utils.enumeration.ruoli.Role;
import com.example.barber.utils.enumeration.statorichieste.StatoRichieste;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public final class MemoryDemo {
    protected static final List<CredentialsModel> CredentialsModelList = new ArrayList<>();
    protected static final List<ClientModel> ClientModelList = new ArrayList<>();
    protected static final List<BarberModel> BarberModelList = new ArrayList<>();
    protected static final List<ServiceModel> ServiceModelList = new ArrayList<>();
    protected static final List<RequestAppointmentsModel> RequestAppointmentsModelList = new ArrayList<>();
    private static final String ERRORE_ID_NON_VALIDO = "Errore id non valido";

    private MemoryDemo() {
        //Costruttore
    }

    public static void addClient(ClientModel model) {
        ClientModelList.add(model);
    }

    public static void addCredentials(CredentialsModel model) {
        CredentialsModelList.add(model);
    }

    public static void addBarber(BarberModel model) {
        BarberModelList.add(model);
    }

    public static ClientModel getClient(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username mancante");
        }
        String u = username.trim();

        for (ClientModel c : ClientModelList) {
            if (u.equalsIgnoreCase(c.getUsername())) {
                return c;
            }
        }
        throw new IllegalArgumentException("Utente non trovato: " + username);
    }


    public static List<BarberModel> searchBarber(String name) {
        if (name == null || name.isBlank()) {
            return new ArrayList<>();
        }

        String query = name.trim().toLowerCase(java.util.Locale.ITALIAN);
        List<BarberModel> result = new ArrayList<>();

        for (BarberModel b : BarberModelList) {
            String n = b.getName();
            if (n != null && n.toLowerCase(java.util.Locale.ITALIAN).contains(query)) {
                result.add(b);
            }
        }
        return result;
    }

    public static BarberModel getBarber(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username mancante");
        }
        String u = username.trim();

        for (BarberModel b : BarberModelList) {
            if (u.equalsIgnoreCase(b.getUsername())) {
                return b;
            }
        }
        throw new IllegalArgumentException("Barbiere non trovato: " + username);
    }

    public static Role getRole(CredentialsModel input) throws SystemException {

        if (input == null
                || input.getUsername() == null || input.getUsername().isBlank()
                || input.getPassword() == null || input.getPassword().isBlank()) {
            throw new SystemException("Credenziali mancanti");
        }

        String u = input.getUsername().trim();
        String p = input.getPassword();


        for (CredentialsModel c : CredentialsModelList) {
            if (u.equalsIgnoreCase(c.getUsername()) && p.equals(c.getPassword())) {
                return c.getType();
            }
        }
        throw new IllegalArgumentException("Credenziali non valide");
    }

    public static List<BarberModel> getAllBarber() {
        return BarberModelList;
    }

    public static List<ServiceModel> serviceByIdBarber(int id) throws SystemException {
        if(id <= 0){
            throw new SystemException(ERRORE_ID_NON_VALIDO);
        }
        List<ServiceModel> list = new ArrayList<>();
        for (ServiceModel s : ServiceModelList) {
            if (s.getIdBarber() == id) {
                list.add(s);
            }
        }
        return list;
    }

    public static void insertService(ServiceModel serviceModel) throws SystemException {
        if(serviceModel == null){
            throw new SystemException("Model è null");
        }
        ServiceModelList.add(serviceModel);
    }

    public static void deleteService(ServiceModel serviceModel) throws SystemException {
        if(serviceModel == null){
            throw new SystemException("Model è null");
        }
        for (ServiceModel s : ServiceModelList) {
            if (s.getIdBarber() == serviceModel.getIdBarber() && s.getNomeServizio().equals(serviceModel.getNomeServizio())) {
                ServiceModelList.remove(s);
            }
        }
    }

    public static List<RequestAppointmentsModel> searchAllAppointmentsById(int id, String role) throws SystemException {
        if( id <= 0 || role ==  null){
            throw new SystemException("Id non valido");
        }

        List<RequestAppointmentsModel> list = new ArrayList<>();
        if (role.equals("BARBIERE")) {

            for (RequestAppointmentsModel r : RequestAppointmentsModelList) {
                if (r.getIdBarber() == id) {
                    list.add(r);
                }
            }
        } else if (role.equals("CLIENTE")) {
            for (RequestAppointmentsModel r : RequestAppointmentsModelList) {
                if (r.getIdUser() == id) {
                    list.add(r);
                }
            }
        }
        return list;
    }

    public static void insertAppointments(RequestAppointmentsModel model) throws SystemException {
        if(model == null){
            throw new SystemException("Model non trovato");
        }
        RequestAppointmentsModelList.add(model);
    }

    public static void updateAppointmentById(int id, String newState) throws SystemException {
        if(id <= 0 || newState == null){
            throw new SystemException(ERRORE_ID_NON_VALIDO);
        }
        for (RequestAppointmentsModel r : RequestAppointmentsModelList) {
            if(r.getAppId() == id){
                r.setState(StatoRichieste.fromString(newState));
            }
        }

    }

    public static BarberModel searchBarberById(int id) throws SystemException {
        if(id <= 0){
            throw new SystemException(ERRORE_ID_NON_VALIDO);
        }

        BarberModel barberModel = null;

        for(BarberModel b : BarberModelList){
            if(b.getId() == id){
                barberModel = b;
            }
        }
        return barberModel;
    }

    public static void updateOrario(BarberModel barberModel) throws SystemException {
        if(barberModel == null){
            throw new SystemException("Model non trovato");
        }

        for(BarberModel b : BarberModelList){
            if(barberModel.getId() == b.getId()){
                b.setOrarioFine(barberModel.getOrarioFine());
                b.setOrarioInizio(barberModel.getOrarioInizio());
            }
        }
    }

}

