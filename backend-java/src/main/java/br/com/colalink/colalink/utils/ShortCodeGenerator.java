package br.com.colalink.colalink.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class ShortCodeGenerator {
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public String execute(int size){
        StringBuilder stringBuilder = new StringBuilder(size);

        for(int i = 0; i < size; i++){
            int randomIndex = SECURE_RANDOM.nextInt(ALPHANUMERIC.length());

            stringBuilder.append(ALPHANUMERIC.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }

}
