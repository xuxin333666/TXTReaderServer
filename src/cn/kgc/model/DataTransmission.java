package cn.kgc.model;

import java.io.Serializable;


/**
 * ͨѶ����Ķ���
 * @author Administrator
 *
 */
public class DataTransmission implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7919290412524754237L;	
	private String command;	//Э������
	private Object object;	//����������
	private int status;	//�ظ�״̬
	private Object result;	//�ظ���������
	
	/**
	 * �вι��췽��
	 * @param command
	 * @param object
	 * @param status
	 * @param result
	 */
	
	public DataTransmission(String command, Object object, int status, Object result) {
		this(command,object);
		this.status = status;
		this.result = result;
	}
	public DataTransmission(String command) {
		this.command = command;
	}
	public DataTransmission(String command, Object object) {
		this(command);
		this.object = object;
	}
	/**
	 * �޲ι��췽��
	 */
	public DataTransmission() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * get��set����
	 * @return
	 */
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	
	
}
