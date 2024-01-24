package com.example.barber.utlis.engineering;
import com.example.barber.utlis.bean.EmailBean;
public class CheckEmailEngineering {

    public boolean validate(EmailBean emailBean) {
        String email = emailBean.getEmail();
        return email != null && !email.isEmpty() && email.replaceAll("[^@]", "").length() == 1 && !email.contains(".@");
    }
}
