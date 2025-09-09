package com.example.barber.utils.dao.demo;

import com.example.barber.model.ServiceModel;
import com.example.barber.utils.dao.ServiceDao;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class ServiceDaoDemo implements ServiceDao {

    @Override
    public List<ServiceModel> getServiceById(int id) throws SystemException {
        if(MemoryDemo.serviceByIdBarber(id) == null){
            throw new SystemException("Lista servizi vuota");
        }
        return MemoryDemo.serviceByIdBarber(id);
    }

    @Override
    public void insertService(ServiceModel serviceModel) throws SystemException {
        MemoryDemo.insertService(serviceModel);
    }

    @Override
    public void deleteService(ServiceModel serviceModel) throws SystemException {
        MemoryDemo.deleteService(serviceModel);
    }
}
