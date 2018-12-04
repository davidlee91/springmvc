package com.yancy.service;

import com.yancy.model.User;

/**
 * service�ӿ�
 * @author Yancy
 *
 */
public interface UserService {

	/**
	 * �����û�����ȡ�û���Ϣ
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);
	
	/**
	 * ��¼��֤
	 * @param username
	 * @param password
	 * @return 
	 */
	public boolean login(String username, String password);
	
	/**
	 * ע���û�
	 * @param username
	 * @param password
	 */
	public boolean register(String username, String password);
}
