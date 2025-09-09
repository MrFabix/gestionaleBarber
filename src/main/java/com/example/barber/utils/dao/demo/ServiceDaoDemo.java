package com.example.barber.utils.dao.demo;

import com.example.barber.model.ServiceModel;
import com.example.barber.utils.dao.Service;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class ServiceDaoDemo implements Service {

    @Override
    public List<ServiceModel> getServiceById(int id) throws SystemException {
        return  null;
    }

    @Override
    public void insertService(ServiceModel serviceModel) throws SystemException {
        System.out.println("InsertServiceDaoDemo");
    }

    @Override
    public void deleteService(ServiceModel serviceModel) throws SystemException {
        System.out.println("DeleteServiceDaoDemo");
    }
}
