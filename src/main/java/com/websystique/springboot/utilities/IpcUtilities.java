package com.websystique.springboot.utilities;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Log
@Service
public class IpcUtilities {

    public String generatePassword(){
        Integer lower = 11111;
        Integer higher = 99999;
        Integer random =(int) (Math.random() * (higher-lower)) + lower;
        return random.toString();
    }
}
