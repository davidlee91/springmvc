package com.yancy.service;

import com.yancy.model.User;

/**
 * service��ӿ�
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
	 * �û���¼��֤
	 * @param username
	 * @param password
	 * @return �ɹ�����true ʧ�ܷ���false
	 */
	public boolean login(String username, String password);
}
