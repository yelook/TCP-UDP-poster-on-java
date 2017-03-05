package com.yelook.socket.TCP;

public class Server {
	public static void main(String[] args) {
		System.out.println("我是服务端，我接收数据，正在监听");
		while (true) {
			String res = null;
			try {
				res = TCPReceiver.receiver();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("接收到信息：" + res);
		}
	}
}
