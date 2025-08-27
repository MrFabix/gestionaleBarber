package com.example.barber.utils.switchpage.initpage;

import com.example.barber.controller.guicontroller.interface1.PageManageUserAppointmentsGuiController;
import com.example.barber.utils.bean.RequestAppointmentsBean;

public class HomePageClientSetter {
    public void setter(RequestAppointmentsBean requestAppointmentsBean, PageManageUserAppointmentsGuiController pageManageUserAppointmentsGuiController) {
        System.out.println("Sei nel setter home page client setter");
        pageManageUserAppointmentsGuiController.setAll(requestAppointmentsBean);
    }
}
