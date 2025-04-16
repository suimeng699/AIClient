package com.suimeng.client;

import com.google.gson.Gson;
import com.suimeng.domain.ChatRequest;
import com.suimeng.domain.ChatResponse;
import com.suimeng.domain.Choice;
import com.suimeng.domain.Message;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class AIClient {
    /**
     * 发送请求
     *
     * @param content
     * @return
     */
    public static String sendRequest(String content,String name) {
        // 创建HttpClient实例
        HttpClient httpClient = HttpClients.createDefault();
        Gson gson = new Gson();
        List<Message> messages = new ArrayList();
        messages.add(new Message("system", "You are a helpful assistant"));
        messages.add(new Message("user", content));
        try {
            //获取配置文件中的内容,获取请求秘钥key和请求路径url
            Properties p = new Properties();
            p.load(AIClient.class.getClassLoader().getResourceAsStream("config.properties"));
            String key = (String) p.get(name + "_key");
            String url = (String) p.get(name + "_url");
            String model = (String) p.get(name + "_model");
            //构建请求对象
            Map<String, Object> map = new HashMap();
            map.put("Content-Type", "application/json");
            map.put("Authorization", "Bearer " + key);
            //设置请求头
            HttpPost httpPost = new HttpPost(url);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue().toString());
            }
            //设置请求体
            ChatRequest chatRequest = new ChatRequest(model, messages, 1, 2048);
            String json = gson.toJson(chatRequest);
            httpPost.setEntity(EntityBuilder.create().setContentType(ContentType.APPLICATION_JSON).setText(json).build());
            //发送请求
            System.out.println("正在解析问题....");
            HttpResponse response = httpClient.execute(httpPost);
            InputStreamReader isr = new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8);
            ChatResponse chatResponse = gson.fromJson(isr, ChatResponse.class);
            List<Choice> choices = chatResponse.getChoices();
            //返回文本结果
            return choices.get(0).getMessage().getContent();
        } catch (Exception e) {
            return "请求失败！请重试....";
        }
    }
}
