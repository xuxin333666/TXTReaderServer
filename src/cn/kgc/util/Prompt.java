package cn.kgc.util;

public interface Prompt {
	String USER_NOT_EXIST = "���û��������ڻ��������";		//�û�������
	String USER_EXIST = "���û����Ѿ�ע���ˣ�";	//�û�����
	String CONNECTION = "  �������ӣ�ָ�";	//�����������������
	int USERNAME_INDEX = 0;	//�û������ڵ�С��
	int PASSWORD_INDEX = 1;	//�������ڵ��±�
	int COMMAND_INDEX = 2;	//�������ڵ��±�
	int ERORR = -1;		//��½����
	int SUCCUSS = 0;	//��½�ɹ�
	int SECONDARY_MENU = 1230;	//�ͻ��˶����˵���������
	int THIRD_RUN_MENU = 1231;	//�ͻ��������˵���������
	
	String TITLE = "��ӭʹ����������TXTС˵������";		//������
	String DIVIDER = "����������������������������������������������������������������";	//�ָ���
	String USER_CHOOSE = "��ѡ��"; 	//�û�ѡ����ʾ
	String SYSTEM_QUIT = "ллʹ��";		//�˳���ʾ
	String CHOOSE_ERORR = "�Ҳ����Ĺ��ܣ�����������ѡ��\n";	//�û��������ѡ����ʾ
	String REGISTER_USERNAME_PROMPT = "������ע���˺ţ�";		//�û�ע���˻���ʾ
	String REGISTER_PASSWORD_PROMPT = "������ע�����룺";		//�û�ע��������ʾ
	String REGISTER_PASSWORD2_PROMPT = "���ٴ��������룺";		//�û�ע���ٴ�����������ʾ
	String REGISTER_PASSWORD2_ERORR = "������������벻һ�£�����������";	//�û�ע���ٴ��������������ʾ
	String REGISTER_SUCCUSS = "ע��ɹ�����";	//�û�ע��ɹ������ʾ
	String LOGIN_USERNAME_PROMPT = "�������˺ţ�";		//�û���½�˻���ʾ
	String LOGIN_PASSWORD_PROMPT = "���������룺";		//�û���½������ʾ
	String LOGIN_SUCCUSS = "��½�ɹ�����";	//�û���½�ɹ������ʾ
	String RETURN_MAIN_MENU = "������һ���˵�";	//������һ���˵�����ʾ
	String GET_NOVE_ERORR = "������û����Ӧ���ݣ�����ϵ����Ա";	//�Ҳ���С˵ʱ����ʾ
	String NOVE_LIST_PRINT = "���\tС˵��\t����\t���";	//С˵�б����
	String NOVEL_NAME = "name";	//С˵���Ƶ�XML��ǩ��
	String NOVEL_AUTHOR = "author";	//С˵���ߵ�XML��ǩ��
	String NOVEL_DESCRIPTION = "description";	//С˵����XML��ǩ��
	String NOVEL_FILENAME = "filename";	//С˵�ļ����Ƶ�XML��ǩ��
	int MAIN_MENU = 1;	//���˵�
	int SECOND_MENU = 2;	//�����˵�
	int THIRD_MENU = 3;	//�����˵�
}
