package org.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmsApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SmsApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
