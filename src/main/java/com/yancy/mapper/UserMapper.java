/**
 *  �ӿ�
 */
package com.yancy.mapper;

import java.awt.List;

import com.yancy.model.User;

/**
 * @author Yancy
 *
 */
public interface UserMapper {

	public User selectOneUser(String id); // ��ȡһ���û�
	
	public User selectOneUserByName(String username);	// �����û�����ѯ�û�

	public List selectAllUser(); // ��ȡ�����û�

	public void deleteUser(); // ɾ�������û�

	public void insertUser(User user); // ����һ���û�
}
