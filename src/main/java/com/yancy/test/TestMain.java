/**
 * 
 */
package com.yancy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yancy.mapper.UserMapper;
import com.yancy.model.User;

/**
 * ������
 * 
 * @author Yancy
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();

		// ����User����
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		String userid = UUID.randomUUID().toString().replaceAll("-",""); 
		user.setUserid(userid);
		user.setUsername("������");
		user.setPassword("123");

		userMapper.insertUser(user);
		System.out.println(" --- �����û��ɹ� ---");
		session.commit();
		session.close();
	}

}
