package com.yelook.socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SocketReceiver {
	public static String receiver(int port) throws Exception{
		//获取本机IP地址
		InetAddress ip = InetAddress.getLocalHost();
//		int port = 1111;
		DatagramSocket receiver = new DatagramSocket(port,ip);
		
//		准备接收
		byte[] recMsg = new byte[1024];
		DatagramPacket getPacket = new DatagramPacket(recMsg, recMsg.length);
		receiver.receive(getPacket);
		//对接收到了 byte数组进行转换
		String res = new String(recMsg,0,getPacket.getLength());
		receiver.close();
		return res;
	}
}
