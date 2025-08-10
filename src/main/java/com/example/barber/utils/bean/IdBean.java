package com.example.barber.utils.bean;

public class IdBean {
    private int id;

    public IdBean() {

    }

    // Costruttore corretto
    public IdBean(int id) {
        this.id = id;
    }

    // Getter per l'id
    public int getId() {
        return id;
    }

    // Setter per l'id
    public void setId(int id) {
        this.id = id;
    }
}
