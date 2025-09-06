package com.example.barber.utils.switchpage.initpage;

import com.example.barber.controller.guicontroller.interface1.PageManageUserAppointmentsGuiController1;
import com.example.barber.controller.guicontroller.interface2.PageManageUserAppointmentsGuiController2;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.exception.myexception.EmptyInputException;

public class HomePageClientSetter {
    public void setter1(RequestAppointmentsBean requestAppointmentsBean, PageManageUserAppointmentsGuiController1 pageManageUserAppointmentsGuiController1) throws EmptyInputException {
        pageManageUserAppointmentsGuiController1.setAll(requestAppointmentsBean);
    }

    public void setter2(RequestAppointmentsBean requestAppointmentsBean, PageManageUserAppointmentsGuiController2 pageManageUserAppointmentsGuiController2) throws EmptyInputException {
        pageManageUserAppointmentsGuiController2.setAll(requestAppointmentsBean);
    }
}
