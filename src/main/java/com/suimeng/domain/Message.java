package com.suimeng.domain;

public class Message {
    String role;// 角色
    String content; // 内容
    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }
    public String getContent() {
        return content;
    }
}
