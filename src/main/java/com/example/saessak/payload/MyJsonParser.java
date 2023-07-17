package com.example.saessak.payload;

import org.json.simple.JSONObject;

public class MyJsonParser {

    String jsonString;
    JSONObject jsonObject;

    public MyJsonParser(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        jsonString = jsonObject.toJSONString();
    }


    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }
}
