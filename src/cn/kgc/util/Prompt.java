package cn.kgc.util;

public interface Prompt {
	String USER_NOT_EXIST = "���û��������ڻ��������";		//�û�������
	String USER_EXIST = "���û����Ѿ�ע���ˣ�";	//�û�����
	String CONNECTION = "  �������ӣ�ָ�";	//�����������������
	String NOVEL_NAME = "name";	//С˵����xml��ǩ����
	String NOVEL_AUTHOR = "author";	//С˵����xml��ǩ����
	String NOVEL_DESCRIPTION = "description";	//С˵���xml��ǩ����
	String NOVEL_FILENAME = "filename";	//С˵�ļ�����xml��ǩ����
	int USERNAME_INDEX = 0;	//�û������ڵ�С��
	int PASSWORD_INDEX = 1;	//�������ڵ��±�
	int ERORR = -1;		//��½����
	int SUCCUSS = 0;	//��½�ɹ�
	int SECONDARY_MENU = 1230;	//�ͻ��˶����˵���������
}
