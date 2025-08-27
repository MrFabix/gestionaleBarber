package com.example.barber.utils.dao.sql;

import com.example.barber.model.ModeratorModel;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;

public class ModeratorDAO   {

    Query query = new Query();

    public ModeratorModel searchModeratorByUsername(String username) throws SystemException {
        return query.searchModeratorByUsername(username);
    }

}
