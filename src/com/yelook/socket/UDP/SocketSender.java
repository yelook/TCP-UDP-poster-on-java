package com.yelook.socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * socket发送者
 * UDP
 */
public class SocketSender {
	public static String sender(String msg) throws Exception{
		
		//创建 datagramSocket对象，可以指定端口号和IP地址
		DatagramSocket sendSocket = new DatagramSocket();
		
		//转换报文为byte类型
		byte[] buf = msg.getBytes();
		//获取本机IP地址
		InetAddress ip = InetAddress.getLocalHost();
		int port = 1111;
		DatagramPacket sendPacket = new DatagramPacket(buf, buf.length,ip,port);
		
		sendSocket.send(sendPacket);
		
		sendSocket.close();
		
		return "ok";
		
	}

}
