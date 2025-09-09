package com.example.barber.utils.engineering;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.dao.BarberDao;
import com.example.barber.utils.exception.myexception.EmailNotValidException;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.exception.myexception.UsernameAlreadyTakenException;
import com.example.barber.utils.factory.daofactory.DaoFactory;
import com.example.barber.utils.managermode.ModeManager;
import com.example.barber.utils.observer.GenericBeanList;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.setterandgetter.SetterClass;

import java.util.ArrayList;
import java.util.List;

public class ListBarberEngineering {

    private SetterClass setterClass = new SetterClass();

    public void listBarber(Observer observer ) throws SystemException, EmptyInputException, EmailNotValidException{
        GenericBeanList list = new GenericBeanList(observer);
        list.addBarbersToList(getAllBarber());
    }

    public List<BarberBean> getAllBarber() throws SystemException, EmptyInputException, EmailNotValidException{

        List<BarberModel> list = null;
        List<BarberBean> listBean = null;


        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        BarberDao barberDao = daoFactory.barberDao();

        list = barberDao.getAllBarber();
        listBean = new ArrayList<>();
        for(BarberModel barberModel : list){
            BarberBean barberBean = new BarberBean();
            setterClass.setBarberBeanFromModel(barberBean, barberModel);
            listBean.add(barberBean);
        }
        return listBean;
    }
    public List<BarberBean> getBarberByName(String name) throws EmptyInputException, EmailNotValidException, SystemException {
        List<BarberModel> list = null;
        List<BarberBean> listBean = new ArrayList<>();

        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        BarberDao barberDao = daoFactory.barberDao();
        list = barberDao.searchBarber(name);
        for(BarberModel barberModel : list){
            BarberBean bean = new BarberBean();
            setterClass.setBarberBeanFromModel(bean, barberModel);
            listBean.add(bean);
        }
        return listBean;
    }




}
