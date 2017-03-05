package com.yelook.socket.TCP;

import java.io.OutputStream;
import java.net.Socket;

public class TCPSender {
	public static String sender(String msg) throws Exception{
		//首先获取IP地址和定义端口
		String host = "localhost";
		int port = 2222;
		Socket socket = new Socket(host, port);
		OutputStream os = socket.getOutputStream();
		os.write(msg.getBytes());
		socket.close();
		return "send ok!";
	}
}
