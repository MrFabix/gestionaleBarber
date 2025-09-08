package com.example.barber;

import com.example.barber.utils.db.MySqlConnection;
import com.example.barber.utils.exception.myexception.SystemException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DBConnectionTest {
    /*
    Testiamo l'avvenuta connessione, se il test ha successo la connessione è stabilita, altimenti è fallita

    @Alessandro Gentili
 */


        @Test
        void testSearchEvent() throws SystemException {

            int value = 0;

            if (MySqlConnection.getInstance().connect() != null) {
                value = 1;
            }

            assertEquals(1, value);

        }
}
