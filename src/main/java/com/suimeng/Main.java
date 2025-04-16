package com.suimeng;

import com.suimeng.client.AIClient;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print("请输入您的问题：");
        String content = scanner.nextLine();
        String s = AIClient.sendRequest(content,"kimi");
        System.out.println(s);
    }
}
