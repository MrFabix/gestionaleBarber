package com.example.barber.utils.bean;

import com.example.barber.utils.exception.Trigger;

public class RecensioneBean {

    private int idCliente;
    private int idAppuntamento;   // o idAppuntamento
    private int voto;
    private String testo;
    public final Trigger trigger = new Trigger();

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public int getIdAppuntamento() { return idAppuntamento; }
    public void setIdAppuntamento(int idAppuntamento) { this.idAppuntamento = idAppuntamento; }

    public int getVoto() { return voto; }
    public void setVoto(int voto) { this.voto = voto; }

    public String getTesto() { return testo; }
    public void setTesto(String testo) { this.testo = testo; }
}
