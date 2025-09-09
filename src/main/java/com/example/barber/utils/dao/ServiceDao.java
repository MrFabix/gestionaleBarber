package com.example.barber.utils.dao;

import com.example.barber.model.ServiceModel;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public interface ServiceDao {
     List<ServiceModel> getServiceById(int id) throws SystemException;
     void insertService(ServiceModel serviceModel) throws SystemException;
     void deleteService(ServiceModel serviceModel) throws SystemException;
}
