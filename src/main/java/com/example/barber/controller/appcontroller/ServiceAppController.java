package com.example.barber.controller.appcontroller;

import com.example.barber.model.ServiceModel;
import com.example.barber.utils.bean.ServiceBean;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.dao.ServiceDao;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.factory.daofactory.DaoFactory;
import com.example.barber.utils.managermode.ModeManager;
import com.example.barber.utils.setterandgetter.SetterClass;

import java.util.ArrayList;
import java.util.List;

public class ServiceAppController {

    private SetterClass setter = new SetterClass();

    public ServiceAppController() {
        //Costruttore
    }

    public List<ServiceBean> getServiceBarber(IdBean id){

        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        ServiceDao serviceDao = daoFactory.serviceDao();

        List<ServiceBean> serviceBean = new ArrayList<>();
        List<ServiceModel> serviceModels = new ArrayList<>();

       try {
           serviceModels = serviceDao.getServiceById(id.getId());

           for(ServiceModel serviceModel : serviceModels){
               ServiceBean serviceBean1 = new ServiceBean();
               setter.setServiceBeanFromModel(serviceBean1, serviceModel);
               serviceBean.add(serviceBean1);
            }
       } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
       return serviceBean;
    }


    public void insertService(ServiceBean serviceBean) throws SystemException {
        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setPrezzo(serviceBean.getPrezzo());
        serviceModel.setIdBarber(serviceBean.getIdBarber());
        serviceModel.setNomeServizio(serviceBean.getNomeServizio());
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        ServiceDao serviceDao = daoFactory.serviceDao();
        serviceDao.insertService(serviceModel);
    }

    public void deleteService(ServiceBean serviceBean) throws SystemException {
        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setPrezzo(serviceBean.getPrezzo());
        serviceModel.setIdBarber(serviceBean.getIdBarber());
        serviceModel.setNomeServizio(serviceBean.getNomeServizio());
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        ServiceDao serviceDao = daoFactory.serviceDao();
        serviceDao.deleteService(serviceModel);
    }
}
