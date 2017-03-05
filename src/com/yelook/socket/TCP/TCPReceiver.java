package com.yelook.socket.TCP;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPReceiver {
	public static String receiver() throws Exception{
		ServerSocket ss = new ServerSocket(2222);
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();
		byte[] buf = new byte[1024];
		String res = new String(buf,0,is.read(buf));
		ss.close();
		return res;
	}
}
