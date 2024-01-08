package com.example.barber.utlis.factory;

public class Factory {

        public MyDialogBox createMyDialogBox(Exception e) {
            if (e instanceof SystemException) {
                return (new MyAlert());
            } else {
                return (new MyNotification());
            }
        }
}
