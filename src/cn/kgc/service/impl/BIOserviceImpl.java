package cn.kgc.service.impl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import cn.kgc.service.intf.IOservice;
import cn.kgc.util.NetConfigUtils;

public class BIOserviceImpl implements IOservice{
	/**
	 * BIOÆô¶¯
	 */
	@Override
	public void open() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(NetConfigUtils.port);
			while(true) {
				Socket socket = serverSocket.accept();
				Runnable threadService = new BIOThreadServiceImpl(socket);
				Thread BIOThread = new Thread(threadService);
				BIOThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
}
