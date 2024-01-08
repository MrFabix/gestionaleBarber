package com.example.barber.utlis.exception;

import com.example.barber.utlis.factory.Factory;
import com.example.barber.utlis.factory.MyDialogBox;
public class ErrorDialog {

    private ErrorDialog() {
        // ignored
    }

    private static ErrorDialog instance = null;
    private Factory factory = new Factory();

    public static ErrorDialog getInstance() {
        if (instance == null) {
            instance = new ErrorDialog();
        }
        return instance;
    }

    public void handleExceptiSystemExceptionon(Exception e) {
        // ErrorDialog Pattern + Factory Pattern
        MyDialogBox myDialogBox = factory.createMyDialogBox(e);
        myDialogBox.useMyDialogBox(e.getMessage());
    }
}

