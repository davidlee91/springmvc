package com.yancy.service;

import java.util.UUID;

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
	public boolean register(String username, String password) {
		System.out.println(" ==== ����һ���û�  ==== ");
		User userSelect = getUserByName(username);
		if (userSelect != null) {
			System.out.println(" --- ע����û��Ѵ��� --- ");
			return false;
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		String userid = UUID.randomUUID().toString().replaceAll("-",""); // ����uuid���ɲ��ظ�id
		user.setUserid(userid);
		mapper.insertUser(user);
		
		return true;
	}
}
