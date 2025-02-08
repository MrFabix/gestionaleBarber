package com.example.barber.model;

import com.example.barber.utils.bean.BarberBean;

public class ModeratorModel extends ProfileModel {

    public ModeratorModel() {
        super();
    }

    public ModeratorModel(BarberBean adminBean) {
        super(adminBean.getId(), adminBean.getUsername(), adminBean.getEmail(), adminBean.getImg(), adminBean.getName(), adminBean.getPhone());
    }



}
