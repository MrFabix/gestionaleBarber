package com.example.barber.utils.dao.demo;


import com.example.barber.model.BarberModel;
import com.example.barber.model.ClientModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.utils.enumeration.ruoli.Role;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public final class MemoryDemo {
    protected static final List<CredentialsModel> CredentialsModelList = new ArrayList<>();
    protected static final List<ClientModel> ClientModelList = new ArrayList<>();
    protected static final List<BarberModel> BarberModelList = new ArrayList<>();

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

    public static List<BarberModel> getAllBarber(){
        return BarberModelList;
    }

}
