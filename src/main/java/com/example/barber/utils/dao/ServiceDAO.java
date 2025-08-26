package com.example.barber.utils.dao;

import com.example.barber.model.ServiceModel;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class ServiceDAO {
    Query query = new Query();
    public List<ServiceModel> getServiceById(int id) throws SystemException {
        System.out.println("Sei nel getServiceById");
        return query.serviceByIdBarber(id);
    }

    public void insertService(ServiceModel serviceModel) throws SystemException {
        query.insertService(serviceModel);
    }

    public void deleteService(ServiceModel serviceModel) throws SystemException {
        query.deleteService(serviceModel);
    }
}
