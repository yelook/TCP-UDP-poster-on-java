package com.yelook.ui;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 这个部分是收信的部分，线程类
 *
 */
public class Receiver implements Runnable {
	//Runnable不能实现传入参数和传出参数，因此，使用 get set 方法塞入参数使用
	//port就是要传入的端口号参数
	private int port;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String receiver(int port) throws Exception {
		ServerSocket ss = new ServerSocket(port);
		//进行TCP握手
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();
		//创建数据缓冲区
		byte[] buf = new byte[1024];
		//从is中读取信息，并且转换为string类型，编码符号是UTF-8
		String res = new String(buf, 0, is.read(buf),"UTF-8");
//		System.out.println("接收到来自：" + port + "的消息，消息内容：" + res);
		ss.close();
		return res;
	}

	public void run() {
		try {
			//使用循环，反复接受数据，否则只能接收一条数据
			while (true) {
				//传入参数。用的get set 方法塞入的
				int port = this.getPort();
				//获取到了消息
				String msg = receiver(port);
				//调用KK中自定义编写的 static 方法来对外打印消息内容
				KK.addmsg(msg, port);
			}
		} catch (Exception e) {
			//如果出现错误，调用KK中自定义编写的 static 方法，打印到屏幕上
			KK.msgerror(e);
			e.printStackTrace();
		}

	}
}
