package com.example.barber.utils.dao.demo;


import com.example.barber.model.*;
import com.example.barber.utils.enumeration.ruoli.Role;
import com.example.barber.utils.enumeration.statorichieste.StatoRichieste;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.exception.myexception.WrongCredentialsException;

import java.util.ArrayList;
import java.util.List;

public final class MemoryDemo {



    protected static final List<CredentialsModel> CredentialsModelList = new ArrayList<>();
    protected static final List<ClientModel> ClientModelList = new ArrayList<>();
    protected static final List<BarberModel> BarberModelList = new ArrayList<>();
    protected static final List<ModeratorModel> ModeratorModelList = new ArrayList<>();
    protected static final List<ServiceModel> ServiceModelList = List.of(new ServiceModel(15.0, "Barba", 0));
    protected static final List<RequestAppointmentsModel> RequestAppointmentsModelList = new ArrayList<>();
    protected static final List<RecensioneModel> RecensioneModelList = new ArrayList<>();
    private static final String ERRORE_ID_NON_VALIDO = "Errore id non valido";
    private static final String ADMIN = "admin";
    private static final String BARBIERE = "barbiere";
    private static final String CLIENTE = "cliente";

    static {
        // ===== MODERATORE DEMO =====
        ModeratorModel moderator = new ModeratorModel();
        moderator.setId(999);
        moderator.setUsername(ADMIN);
        moderator.setName("Moderatore Demo");
        moderator.setEmail("admin@barber.com");
        moderator.setPhone("1234567890");
        ModeratorModelList.add(moderator);

        CredentialsModel modCredentials = new CredentialsModel();
        modCredentials.setUsername(ADMIN);
        modCredentials.setPassword(ADMIN);
        modCredentials.setType(Role.MODERATORE);
        CredentialsModelList.add(modCredentials);

        // ===== BARBIERE DEMO =====
        BarberModel barber = new BarberModel();
        barber.setId(1);
        barber.setUsername(BARBIERE);
        barber.setName("Mario Rossi");
        barber.setEmail("mario@barber.com");
        barber.setPhone("3331234567");
        barber.setCity("Roma");
        barber.setAddress("Via Roma 123");
        barber.setDescription("Barbiere esperto con 10 anni di esperienza");
        barber.setOrarioInizio("09:00");
        barber.setOrarioFine("19:00");
        BarberModelList.add(barber);

        CredentialsModel barberCredentials = new CredentialsModel();
        barberCredentials.setUsername(BARBIERE);
        barberCredentials.setPassword(BARBIERE);
        barberCredentials.setType(Role.BARBER);
        CredentialsModelList.add(barberCredentials);

        // ===== CLIENTE DEMO =====
        ClientModel client = new ClientModel();
        client.setId(100);
        client.setUsername(CLIENTE);
        client.setName("Luca");
        client.setSurname("Bianchi");
        client.setEmail("luca@example.com");
        client.setPhone("3339876543");
        client.setGender("M");
        ClientModelList.add(client);

        CredentialsModel clientCredentials = new CredentialsModel();
        clientCredentials.setUsername(CLIENTE);
        clientCredentials.setPassword(CLIENTE);
        clientCredentials.setType(Role.CLIENTE);
        CredentialsModelList.add(clientCredentials);
    }

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

    public static ClientModel getClient(String username) throws SystemException{
        if (username == null || username.isBlank()) {
            throw new SystemException("Username mancante");
        }
        String u = username.trim();

        for (ClientModel c : ClientModelList) {
            if (u.equalsIgnoreCase(c.getUsername())) {
                return c;
            }
        }
        throw new SystemException("Utente non trovato: " + username);
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

    public static Role getRole(CredentialsModel input) throws WrongCredentialsException {

        if (input == null
                || input.getUsername() == null || input.getUsername().isBlank()
                || input.getPassword() == null || input.getPassword().isBlank()) {
            throw new WrongCredentialsException();
        }

        String u = input.getUsername().trim();
        String p = input.getPassword().trim();


        for (CredentialsModel c : CredentialsModelList) {
            if (c.getUsername() != null && c.getPassword() != null
                    && u.equalsIgnoreCase(c.getUsername().trim())
                    && p.equals(c.getPassword().trim())) {
                return c.getType();
            }
        }
        throw new WrongCredentialsException();
    }

    public static List<BarberModel> getAllBarber() {
        return BarberModelList;
    }

    public static List<ServiceModel> serviceByIdBarber(int id) throws SystemException {
        if(id < 0){
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
        if( id < 0 || role ==  null){
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
        if(id < 0 || newState == null){
            throw new SystemException(ERRORE_ID_NON_VALIDO);
        }
        for (RequestAppointmentsModel r : RequestAppointmentsModelList) {
            if(r.getAppId() == id){
                r.setState(StatoRichieste.fromString(newState));
            }
        }

    }

    public static BarberModel searchBarberById(int id) throws SystemException {
        if(id < 0){
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

    public static boolean checkUsername(String username) throws SystemException{
        if (username == null || username.isBlank()) {
            throw new SystemException("Username non valido (vuoto)");
        }

        for(ClientModel c : ClientModelList){
            if(c.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public static void insertRecensione(RecensioneModel recensioneModel) {
        if(recensioneModel == null){
            return;
        }
        recensioneModel.setIdRecensione(RecensioneModelList.size() + 1);
        RecensioneModelList.add(recensioneModel);
    }

    public static List<RecensioneModel> getMyRecensioni(int id) {
        List<RecensioneModel> result = new ArrayList<>();
        for (RecensioneModel r : RecensioneModelList) {
            if (r.getIdCliente() == id) {
                result.add(r);
            }
        }
        return result;
    }

    public static List<RecensioneModel> getMyRecensioniBarbiere(int idBarber) {
        List<RecensioneModel> result = new ArrayList<>();
        for (RecensioneModel r : RecensioneModelList) {
            for (RequestAppointmentsModel app : RequestAppointmentsModelList) {
                if (app.getAppId() == r.getIdAppuntamento() && app.getIdBarber() == idBarber) {
                    result.add(r);
                    break;
                }
            }
        }
        return result;
    }

    public static void reportRecensione(int idRecensione) {
        for (RecensioneModel r : RecensioneModelList) {
            if (r.getIdRecensione() == idRecensione) {
                r.setReport(1);
                break;
            }
        }
    }

    public static List<RecensioneModel> getReportedRecensioni() {
        List<RecensioneModel> result = new ArrayList<>();
        for (RecensioneModel r : RecensioneModelList) {
            if (r.getReport() == 1) {
                result.add(r);
            }
        }
        return result;
    }

    public static void approveRecensione(int idRecensione) {
        for (RecensioneModel r : RecensioneModelList) {
            if (r.getIdRecensione() == idRecensione) {
                r.setReport(0);
                break;
            }
        }
    }

    public static void deleteRecensione(int idRecensione) {
        RecensioneModelList.removeIf(r -> r.getIdRecensione() == idRecensione);
    }

    public static ModeratorModel getModeratorByUsername(String username) throws SystemException {
        if (username == null || username.isBlank()) {
            throw new SystemException("Username mancante");
        }
        String u = username.trim();

        for (ModeratorModel m : ModeratorModelList) {
            if (u.equalsIgnoreCase(m.getUsername())) {
                return m;
            }
        }
        throw new SystemException("Moderatore non trovato: " + username);
    }

}

