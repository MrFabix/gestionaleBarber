package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.dao.BarberDao;
import com.example.barber.utils.engineering.ListBarberEngineering;
import com.example.barber.utils.exception.myexception.EmailNotValidException;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.factory.daofactory.DaoFactory;
import com.example.barber.utils.managermode.ModeManager;
import com.example.barber.utils.observer.GenericBeanList;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.setterandgetter.SetterClass;
import java.util.List;

public class BarberAppController {

    private SetterClass setterClass = new SetterClass();
    public BarberAppController() {
        // Costruttore
    }


    public BarberBean getBarberDetails(IdBean id) throws SystemException, EmptyInputException, EmailNotValidException {
        BarberModel barberModel = null;

        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        BarberDao barberDao = daoFactory.barberDao();
        barberModel = barberDao.getBarberById(id.getId());

        BarberBean barberBean = new BarberBean();
        setterClass.setBarberBeanFromModel(barberBean,barberModel);
        return barberBean;
    }

    public void insertOrarioBarber(BarberBean barber) throws SystemException{
        BarberModel barberModel = new BarberModel();
        setterClass.setBarberModelFromBarberBean(barberModel,barber);


        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        BarberDao barberDao = daoFactory.barberDao();
        barberDao.updateOrarioDB(barberModel);
    }

    public void addToList(Observer ob) throws SystemException, EmptyInputException, EmailNotValidException {
        ListBarberEngineering listBarber = new ListBarberEngineering();
        List<BarberBean> listBean = listBarber.getAllBarber();
        GenericBeanList list1 = new GenericBeanList(ob);
        list1.addBarbersToList(listBean);
    }

    public void search(Observer ob, String search) throws SystemException, EmptyInputException, EmailNotValidException {
        ListBarberEngineering listBarber = new ListBarberEngineering();
        GenericBeanList list = new GenericBeanList(ob);
        list.addBarbersToList(listBarber.getBarberByName(search));
    }



}
