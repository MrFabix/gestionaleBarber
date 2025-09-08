package com.example.barber.controller.appcontroller;

import com.example.barber.model.ServiceModel;
import com.example.barber.utils.bean.ServiceBean;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.dao.sql.ServiceDAO;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ServiceAppController {
    public ServiceAppController() {
        //Costruttore
    }

    public List<ServiceBean> getServiceBarber(IdBean id){
        ServiceDAO serviceDao = new ServiceDAO();
        List<ServiceBean> serviceBean = new ArrayList<>();
        List<ServiceModel> serviceModels = new ArrayList<>();

       try {
           serviceModels = serviceDao.getServiceById(id.getId()); //devo passare l'id del barbiere con un Bean

           for(ServiceModel serviceModel : serviceModels){
                serviceBean.add(new ServiceBean(serviceModel));
            }
       } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
       return serviceBean;
    }


    public void insertService(ServiceBean serviceBean) throws SystemException {
        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setPrezzo(serviceBean.getPrezzo());
        serviceModel.setId_barber(serviceBean.getId_barber());
        serviceModel.setNome_servizio(serviceBean.getNome_servizio());
        ServiceDAO serviceDAO = new ServiceDAO();
        serviceDAO.insertService(serviceModel);
    }

    public void deleteService(ServiceBean serviceBean) throws SystemException {
        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setPrezzo(serviceBean.getPrezzo());
        serviceModel.setId_barber(serviceBean.getId_barber());
        serviceModel.setNome_servizio(serviceBean.getNome_servizio());
        ServiceDAO serviceDAO = new ServiceDAO();
        serviceDAO.deleteService(serviceModel);
    }
}
