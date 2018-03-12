package com.flariz.sales.Service;

import org.springframework.stereotype.Service;

@Service
public class Asserts {

    public void isNotNull(Object obj, String message) throws Exception {
        if(obj == null) {
            throw new Exception(message);
        }
    }
}
