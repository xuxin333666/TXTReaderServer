package cn.kgc.util;

public interface Prompt {
	String USER_NOT_EXIST = "该用户名不存在或密码错误！";		//用户不存在
	String USER_EXIST = "该用户名已经注册了！";	//用户存在
	String CONNECTION = "  正在连接，指令：";	//服务器输出链接内容
	String NOVEL_NAME = "name";	//小说名称xml标签名称
	String NOVEL_AUTHOR = "author";	//小说作者xml标签名称
	String NOVEL_DESCRIPTION = "description";	//小说简介xml标签名称
	String NOVEL_FILENAME = "filename";	//小说文件名称xml标签名称
	int USERNAME_INDEX = 0;	//用户名所在的小标
	int PASSWORD_INDEX = 1;	//密码所在的下标
	int ERORR = -1;		//登陆错误
	int SUCCUSS = 0;	//登陆成功
	int SECONDARY_MENU = 1230;	//客户端二级菜单启动命令
}
