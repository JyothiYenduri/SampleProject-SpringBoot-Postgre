package com.talentstream.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {                                          //user defined class
	
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj,String email,String username,long id) { //object class accept any type of data. 
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", message);
            map.put("status", status.value());
            map.put("data", responseObj);
            map.put("email", email);
            map.put("username", username);
            map.put("id", id);

            return new ResponseEntity<Object>(map,status);
    }
}