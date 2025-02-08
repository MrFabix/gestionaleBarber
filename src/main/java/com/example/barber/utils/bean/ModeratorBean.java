package com.example.barber.utils.bean;

import com.example.barber.model.ModeratorModel;

public class ModeratorBean extends ProfileBean{


    public ModeratorBean() {}

    public ModeratorBean(ModeratorBean adminBean) {
        this.name = adminBean.getName();
        this.id = adminBean.getId();
        this.email = adminBean.getEmail();
        this.username = adminBean.getUsername();
    }


    public ModeratorBean(ModeratorModel moderatorModel) {
        this.name = moderatorModel.getName();
        this.id = moderatorModel.getId();
        this.email = moderatorModel.getEmail();
        this.username = moderatorModel.getUsername();
    }




}
