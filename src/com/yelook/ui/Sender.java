package com.yelook.ui;

import java.io.OutputStream;
import java.net.Socket;

/**
 * 这个部分是送信用的，线程类
 * @author tangye16814
 *
 */
public class Sender implements Runnable{
	//使用get set 方法传入三个参数，发送的信息，ip地址和端口
	private String msg;
	private String host;
	private int port;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String sender(String msg,String host,int port) throws Exception{
		//首先获取IP地址和定义端口
//		String host = "localhost";
//		int port = 2222;
		//创建socket
		Socket socket = new Socket(host, port);
		OutputStream os = socket.getOutputStream();
//		System.out.println("向"+host+":"+port+" 发送信息："+msg);
		//发信
		os.write(msg.getBytes("UTF-8"));
		//发送完毕，关闭socket
		socket.close();
		return "send ok!";
	}

	@Override
	public void run() {
		try {
			sender(this.getMsg(),this.getHost(),this.getPort());
		} catch (Exception e) {
			//打印错误
			KK.msgerror(e);
			e.printStackTrace();
		}
		
	}
}
