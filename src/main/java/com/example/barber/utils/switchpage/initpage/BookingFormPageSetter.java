package com.example.barber.utils.switchPage.initpage;

import com.example.barber.controller.guicontroller.interface1.BookingFormGuiController1;
import com.example.barber.controller.guicontroller.interface2.BookingFormGuiController2;
import com.example.barber.utils.bean.PreFormBarberBean;

public class BookingFormPageSetter {
    public void setter1(PreFormBarberBean bean, BookingFormGuiController1 controller) {
        controller.setAll(bean);
    }
    public void setter2(PreFormBarberBean bean, BookingFormGuiController2 controller) {
        controller.setAll(bean);
    }
}
