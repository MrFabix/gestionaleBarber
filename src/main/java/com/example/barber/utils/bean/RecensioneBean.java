package com.example.barber.utils.bean;

import com.example.barber.utils.exception.Trigger;

import java.sql.Timestamp;

public class RecensioneBean implements GenericBean{

    private int idCliente;
    private int idAppuntamento;   // o idAppuntamento
    private int voto;
    private String testo;
    private String nomeCliente;
    private String nomeBarbiere;
    private Timestamp createdAt;

    public final Trigger trigger = new Trigger();

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public int getIdAppuntamento() { return idAppuntamento; }
    public void setIdAppuntamento(int idAppuntamento) { this.idAppuntamento = idAppuntamento; }
    public Timestamp getCreatedAt() { return createdAt; }
    public  void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    public int getVoto() { return voto; }
    public void setVoto(int voto) { this.voto = voto; }
    public String getTesto() { return testo; }
    public void setTesto(String testo) { this.testo = testo; }
    public  String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public String getNomeBarbiere() { return nomeBarbiere; }
    public void setNomeBarbiere(String nomeBarbiere) { this.nomeBarbiere = nomeBarbiere; }


    //tostring
    @Override
    public String toString() {
        return "RecensioneBean{" +
                "idCliente=" + idCliente +
                ", idAppuntamento=" + idAppuntamento +
                ", voto=" + voto +
                ", testo='" + testo + '\'' +
                ", createdAt=" + createdAt +
                ", nomeBarbiere='" + nomeBarbiere + '\'' +
                '}';
    }
}
