package com.yancy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.yancy.mapper.UserMapper;
import com.yancy.model.*;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper mapper;	//��ʼ�����ݿ��������

	/**
	 * �����û�����ȡ�û���Ϣ
	 */
	public User getUserByName(String name) {
		return mapper.selectOneUserByName(name);
	}

	/**
	 * �û���¼������ǰ�������username��password����֤�����Ƿ����
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @return ���Ϸ���true
	 */
	public boolean login(String username, String password) {
		User user = mapper.selectOneUserByName(username);
		if (user == null || !password.equals(user.getPassword()))
			return false;
		else
			return true;
	}
	
	/**
	 * �û�ע��
	 */
	public void register(int userid, String username, String password) {
		System.out.println(" ==== ����һ���û�  ==== ");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setUserid(userid);
		mapper.insertUser(user);
	}
}
