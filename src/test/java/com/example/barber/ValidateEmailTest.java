package com.example.barber;

import com.example.barber.utils.bean.EmailBean;
import com.example.barber.utils.engineering.CheckEmailEngineering;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateEmailTest {
    /*
    Test che permette di verificare se una email fornita rispetta il formato corretto.

    @Alessandro Gentili
 */

    @Test
    void testValidatorEmail(){

        String email2 = "prova@gmail.com";
        int case2 = 0;
        EmailBean emailBean = new EmailBean();
        CheckEmailEngineering checkEmailEngineering = new CheckEmailEngineering();

        emailBean.setEmail(email2);
        if(checkEmailEngineering.validate(emailBean)){
            case2 = 1;
        }

        assertEquals(1, case2, 0); //Success
    }

    @Test
    void testValidatoEmailFail(){

        String email1 = "provamail";
        int case1 = 0;
        EmailBean emailBean = new EmailBean();
        CheckEmailEngineering checkEmailEngineering = new CheckEmailEngineering();

        emailBean.setEmail(email1);
        if(checkEmailEngineering.validate(emailBean)){
            case1 = 1;
        }

        assertEquals(0, case1, 0); //Fail
    }
}

