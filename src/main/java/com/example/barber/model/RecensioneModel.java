package com.example.barber.model;

import java.sql.Timestamp;

public class RecensioneModel {
    protected int idCliente;
    protected int idAppuntamento;      // o idAppuntamento, dipende dal tuo dominio
    protected int idRecensione;
    protected int voto;            // 1..5
    protected String testo;
    protected Timestamp createdAt;
    protected String nomeCliente;
    protected String nomeBarbiere;
    protected int report;

    public RecensioneModel(int idCliente, int idAppuntamento, int voto, String testo, String nomeBarbiere) {
        this.idCliente = idCliente;
        this.idAppuntamento = idAppuntamento;
        this.voto = voto;
        this.testo = testo;
        this.nomeBarbiere = nomeBarbiere;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public RecensioneModel() {}

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public int getIdAppuntamento() { return idAppuntamento; }
    public void setIdAppuntamento(int idAppuntamento) { this.idAppuntamento = idAppuntamento; }
    public int getVoto() { return voto; }
    public void setVoto(int voto) { this.voto = voto; }
    public String getTesto() { return testo; }
    public void setTesto(String testo) { this.testo = testo; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public String getNomeBarbiere() { return nomeBarbiere; }
    public void setNomeBarbiere(String nomeBarbiere) { this.nomeBarbiere = nomeBarbiere; }
    public  int getIdRecensione() { return idRecensione; }
    public void setIdRecensione(int idRecensione) { this.idRecensione = idRecensione; }
    public int getReport() { return report; }
    public void setReport(int report) { this.report = report; }




}
