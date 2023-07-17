package com.example.saessak.payload;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiResponse {
    private String status;
    private String message;
    private Object data;
    private String jsonString;


//    public ApiResponse(String status, String message, String data) {
//        System.out.println("string");
//        this.status = status;
//        this.message = message;
//        System.out.println(data);
////        JSONParser jsonParser = new JSONParser();
////        (JSONObject) jsonParser.parse(data);
//        this.jsonString = data;
//    }

    public ApiResponse(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        System.out.println(data);
        ObjectMapper mapper = new ObjectMapper();

//        JSONParser jsonParser = new JSONParser();
//        (JSONObject) jsonParser.parse(data);
        try {
            this.data = mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}