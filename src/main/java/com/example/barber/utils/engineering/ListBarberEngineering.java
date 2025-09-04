package com.example.barber.utils.engineering;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.dao.sql.BarberDAO;
import com.example.barber.utils.exception.myexception.EmailNotValidException;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.exception.myexception.UsernameAlreadyTakenException;
import com.example.barber.utils.observer.GenericBeanList;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.setterandgetter.SetterClass;

import java.util.ArrayList;
import java.util.List;

public class ListBarberEngineering {

    private SetterClass setterClass = new SetterClass();

    public void listBarber(Observer observer ) throws SystemException, EmptyInputException, UsernameAlreadyTakenException, EmailNotValidException{
        GenericBeanList list = new GenericBeanList(observer);
        list.addBarbersToList(getAllBarber());
    }

    public List<BarberBean> getAllBarber() throws SystemException, EmptyInputException, UsernameAlreadyTakenException, EmailNotValidException{

        List<BarberModel> list = null;
        List<BarberBean> listBean = null;
        BarberDAO barberDAO = new BarberDAO();
        list = barberDAO.getAllBarber();
        listBean = new ArrayList<>();

        for(BarberModel barberModel : list){
            BarberBean barberBean = new BarberBean();
            setterClass.setBarberBeanFromModel(barberBean, barberModel);
            listBean.add(barberBean);
        }
        return listBean;
    }
    public List<BarberBean> getBarberByName(String name) throws EmptyInputException, UsernameAlreadyTakenException, EmailNotValidException, SystemException {
        List<BarberModel> list = null;
        List<BarberBean> listBean = null;
        BarberDAO barberDAO = new BarberDAO();
        list = barberDAO.searchBarber(name);
        listBean = new ArrayList<>();
        BarberBean bean = new BarberBean();
        for(BarberModel barberModel : list){
            setterClass.setBarberBeanFromModel(bean, barberModel);
            listBean.add(bean);
        }
        return listBean;
    }




}
