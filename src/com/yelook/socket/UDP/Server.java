package com.yelook.socket.UDP;

public class Server {
	public static void main(String[] args) {
		System.out.println("我是接收端，正在监听消息");
		while (true) {
			String res = null;
			try {
				res = SocketReceiver.receiver(1111);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("接收到消息，消息内容：" + res);
		}
	}
}
