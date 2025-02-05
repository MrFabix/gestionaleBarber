package com.example.barber.model;

import com.example.barber.utils.bean.AdminBean;

public class AdminModel extends ProfileModel {

    public AdminModel() {
        super();
    }

    public AdminModel(AdminBean adminBean) {
        super(adminBean.getId(), adminBean.getUsername(), adminBean.getEmail(), adminBean.getImg(), adminBean.getName(), adminBean.getPhone());
    }



}
