package com.example.demo.b0000;

import org.springframework.beans.factory.annotation.Autowired;

public class B0000Controller {

    @Autowired
    private B0000Service b0000Service;

    public String time() {
        b0000Service.select();
        return String.format("{%s}", json("time", System.currentTimeMillis()));
    }

    private String json(String key, String value) {
        return String.format("\"%s\":\"%s\"", key, value);
    }

    private String json(String key, Number value) {
        return String.format("\"%s\":%d", key, value);
    }
}
