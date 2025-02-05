package com.example.barber.utils.bean;

import com.example.barber.model.AdminModel;

public class AdminBean extends ProfileBean{


    public AdminBean() {}

    public AdminBean(AdminBean adminBean) {
        this.name = adminBean.getName();
        this.id = adminBean.getId();
        this.email = adminBean.getEmail();
        this.username = adminBean.getUsername();
    }


    public AdminBean(AdminModel adminModel) {
        this.name = adminModel.getName();
        this.id = adminModel.getId();
        this.email = adminModel.getEmail();
        this.username = adminModel.getUsername();
    }




}
