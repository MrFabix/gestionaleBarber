package com.example.barber.utils.dao.sql;

import com.example.barber.model.ServiceModel;
import com.example.barber.utils.dao.Service;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class ServiceDaoSql implements Service {
    Query query = new Query();

    @Override
    public List<ServiceModel> getServiceById(int id) throws SystemException {
        return query.serviceByIdBarber(id);
    }

    @Override
    public void insertService(ServiceModel serviceModel) throws SystemException {
        query.insertService(serviceModel);
    }

    @Override
    public void deleteService(ServiceModel serviceModel) throws SystemException {
        query.deleteService(serviceModel);
    }
}
