package com.yancy.util;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis������
 * MybatisUtil.getSession() ��ȡsession;
 * MybatisUtil.closeSession() �ر�session;
 * @author Yancy
 * 
 */
public class MybatisUtil {

	private static SqlSessionFactory sessionFactory = null;

	/*
	 * ���������̱߳�����Ϊÿһ���̶߳�������һ��session���� ÿһ���߳�ֻ���ҽ��е�����Ψһ��һ��session����
	 * �����̱߳�����session���й������Ա�֤�̰߳�ȫ�������ʵ��ͬʱ����ͬһ��session����
	 * ÿһ���̶߳���newһ���̱߳������Ӷ����䵽�Լ���session����
	 */
	private static ThreadLocal<SqlSession> threadlocal = new ThreadLocal<SqlSession>();

	// ����sessionFactory������Ϊ����Ӧ�ó���ֻ��Ҫһ��ʵ�����󣬹��þ�̬�����
	static {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����sessionFactory���� ��������
	 * @return sessionFactory
	 */
	public static SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * �½�session�Ự������session�����̱߳�����
	 */
	private static void newSession() {
		// ��һ��session�Ự
		SqlSession session = sessionFactory.openSession();
		// ��session�Ự�����ڱ��̱߳�����
		threadlocal.set(session);
	}
	
	/**
	 * ����session����
	 * @return session
	 */
	public static SqlSession getSession(){

		//���ȴ��̱߳�����ȡsession����
		SqlSession session = threadlocal.get();
		//����̱߳����е�sessionΪnull��
		if(session==null){
			//�½�session�Ự������session�����̱߳�����
			newSession();
			//�ٴδ��̱߳�����ȡsession����
			session = threadlocal.get();
		}
		return session;
	}
	
	/**
	 * �ر�session���󣬲����̱߳�����ɾ��
	 */
	public static void closeSession(){
		//��ȡ���̱߳�����session����
		SqlSession session = threadlocal.get();
		//���session����Ϊ�գ��ر�sessoin���󣬲�����̱߳���
		if(session!=null){
			session.close();
			threadlocal.set(null);
		}
	}

}
