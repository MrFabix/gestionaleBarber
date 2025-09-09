package com.example.barber.utils.factory;

import com.example.barber.utils.exception.myexception.SystemException;
public class Factory {

        public MyDialogBox createMyDialogBox(Exception e) {
            if (e instanceof SystemException) {
                return (new MyAlert());
            } else {
                return (new MyNotification());
            }
        }
}
