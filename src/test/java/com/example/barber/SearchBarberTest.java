package com.example.barber;

/*
    Vogliamo testare se quel barbiere con quel username ha quello specifico id, quindi se il barbiere con id 1 ha come username FadeBarber.
    Necessario utilizzare il db fornito con tutta l'applicazione

    @Alessandro Gentili
 */

import com.example.barber.model.BarberModel;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchBarberTest {

    @Test
    public void testSerachBarber() throws SystemException {


        Query query = new Query();
        BarberModel model = query.searchBarberById(1);
        assertEquals("FadeBarber", model.getUsername());



    }

    @Test
    public void testSearchBarberFail() throws SystemException {

        Query query = new Query();
        BarberModel model = query.searchBarberById(2);
        assertEquals("FadeBarber", model.getUsername());
    }

}