package com.suimeng.domain;

import java.util.List;

/**
 * 请求实体
 */
public class ChatRequest {
    //model
    private String model;
    //消息数组
    private List<Message> messages;
    //temperature
    private double temperature;
    // max_token
    private int max_tokens;
    public ChatRequest(String model, List<Message> messages, double temperature, int max_tokens)
    {
        this.model = model;
        this.messages = messages;
        this.temperature = temperature;
        this.max_tokens = max_tokens;
    }
}
