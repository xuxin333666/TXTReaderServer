package cn.kgc.service.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;
import cn.kgc.util.ServiceFactory;

public class BIOThreadServiceImpl implements Runnable,Prompt {
	private Socket socket;	//该子线程运行的socket
	private ObjectInputStream ois;	//建立输入流
	private ObjectOutputStream oos;	//建立输出流
	/**
	 * 有参构造方法
	 * @param socket
	 */
	public BIOThreadServiceImpl(Socket socket) {
		this.socket = socket;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 重写run方法
	 */
	@Override
	public void run() {
		try {
			DataTransmission data = (DataTransmission)ois.readObject();
			showInfo(data);			
			Service service = ServiceFactory.Parse(data);
			oos.writeObject(service.start(data));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 服务器连接提示信息
	 * @param data
	 */
	private void showInfo(DataTransmission data) {
		System.out.println(socket.getInetAddress().getHostAddress() 
				+ CONNECTION + data.getCommand());
	}

}
