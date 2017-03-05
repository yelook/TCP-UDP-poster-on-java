package com.yelook.socket.UDP;

import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		System.out.println("我是客户端，请输入要发送的信息");
		while (true) {
			Scanner sc = new Scanner(System.in);
			String msg = sc.next();
			String res = null;
			try {
				res = SocketSender.sender(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(res);
		}
	}
}
