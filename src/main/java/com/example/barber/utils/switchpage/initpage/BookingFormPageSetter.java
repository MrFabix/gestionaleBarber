package com.example.barber.utils.switchpage.initpage;

import com.example.barber.controller.guicontroller.interface1.BookingFormGuiController;
import com.example.barber.utils.bean.PreFormBarberBean;

public class BookingFormPageSetter {
    public void setter(PreFormBarberBean bean, BookingFormGuiController controller) {
        controller.setAll(bean);
    }
}
