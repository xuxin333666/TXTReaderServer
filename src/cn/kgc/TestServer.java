package cn.kgc;


import cn.kgc.service.impl.BIOserviceImpl;
import cn.kgc.service.intf.IOservice;

public class TestServer {
	public static void main(String[] args) {
		IOservice service = new BIOserviceImpl();
		service.open();
	}
	
}
