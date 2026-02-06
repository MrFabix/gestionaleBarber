package com.example.barber.utils.dao.demo;

import com.example.barber.model.RecensioneModel;
import com.example.barber.utils.dao.RecensioneDao;

import java.util.List;

public class RecensioneDaoDemo implements RecensioneDao {
    @Override
    public void insertRecensione(RecensioneModel recensioneModel) {
        return ;
    }
    @Override
    public List<RecensioneModel> getMyRecensioni(int id) {
        return null;
    }
    @Override
    public List<RecensioneModel> getMyRecensioniBarbiere(int id) {
        return null;
    }

    @Override
    public void reportRecensione(int idRecensione) {
            return ;
    }

    @Override
    public List<RecensioneModel> getReportedRecensioni() {
        return null;
    }

    @Override
    public void approveRecensione(int idRecensione) {
        return;
    }

    @Override
    public void deleteRecensione(int idRecensione) {
        return;
    }




}
