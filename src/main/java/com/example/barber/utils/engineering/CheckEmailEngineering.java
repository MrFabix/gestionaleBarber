package com.example.barber.utils.engineering;
import com.example.barber.utils.bean.EmailBean;
public class CheckEmailEngineering {

    public boolean validate(EmailBean emailBean) {
        String email = emailBean.getEmail();
        return email != null && !email.isEmpty() && email.replaceAll("[^@]", "").length() == 1 && !email.contains(".@");
    }
}
