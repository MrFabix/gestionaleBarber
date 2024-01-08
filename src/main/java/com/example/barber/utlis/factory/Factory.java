package com.example.barber.utlis.factory;

import com.example.barber.utlis.exception.myecxeption.SystemException;
public class Factory {

        public MyDialogBox createMyDialogBox(Exception e) {
            if (e instanceof SystemException) {
                return (new MyAlert());
            } else {
                return (new MyNotification());
            }
        }
}
