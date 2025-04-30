package com.igorjava.shawarmadelivery.conf;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthUtils {

    private final PasswordEncoder bcryptEncoder;

    public AuthUtils(PasswordEncoder bcryptoEncoder) {
        this.bcryptEncoder = bcryptoEncoder;
    }

    public String encodePassword(String rawPassword){
        return bcryptEncoder.encode(rawPassword);
    }

    public boolean authenticats(String rawPassword, String encodedPassword){
        return bcryptEncoder.matches(rawPassword, encodedPassword);
    }
}
