package com.example.barber.utils.dao.demo;

import com.example.barber.model.ModeratorModel;
import com.example.barber.utils.exception.myexception.SystemException;

public class ModeratorDaoDemo {

    public ModeratorModel searchModeratorByUsername(String username) throws SystemException {
        return MemoryDemo.getModeratorByUsername(username);
    }
}
