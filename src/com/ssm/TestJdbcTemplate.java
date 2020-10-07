package com.ssm;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ssm.dao.UserDao;

import nuc.ssm.entity.User;

public class TestJdbcTemplate {

	public static void main(String[] args) {
		//��ʼ��spring����������applicationContext.xml����
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ���������JdbcTemplateʵ��
		JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
		String sql = "create table user1(id int primary key auto_increment,userName varchar(20),password varchar(32))";
		//ʹ��execute��������ִ��sql��䣬������
		jdbcTemplate.execute(sql);
		System.out.println("�û���user1�����ɹ���");
	}
	
	public UserDao getUserDao() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao ud = (UserDao)ctx.getBean("userDao");
		return ud;
	}
	
	
	@Test
	public void addUserTest() {
		UserDao ud = getUserDao();
		User user = new User("��ΰ","admin");
		int result = ud.addUser(user);
		
		if(result>0) {
			System.out.println("�ɹ������ݱ��в�����"+result+"������");
		}else {
			System.out.println("�����ݱ��в�������ʧ�ܣ�");
		}
	}
	
	
	 @Test 
	 public void updateUserTest() { 
		 UserDao ud = getUserDao();
		 User user = new User(2,"����","111");
		 int result = ud.updateUser(user);
		 if(result>0) {
			 System.out.println("�ɹ��޸���"+result+"������");
		 }else {
			 System.out.println("�޸Ĳ���ִ��ʧ�ܣ�");
		 }
	 }
	 
	 @Test
	 public void deleteUserTest() {
		 UserDao ud = getUserDao();
		 int result = ud.deleteUser(3);
		 if(result>0) {
			 System.out.println("�ɹ�ɾ����"+result+"������");
		 }else {
			 System.out.println("ɾ������ִ��ʧ�ܣ�");
		 }
	 }
	 
	 @Test
	 public void findUserByIdTest() {
		 UserDao ud = getUserDao();
		 User user = ud.findUserById(1);
		 System.out.println(user);
	 }
	 
	 @Test
	 public void findAllUserTest() {
		 UserDao ud = getUserDao();
		 List<User> users = ud.findAllUser();
		 for(User user:users) {
			 System.out.println(user);
		 }
	 }

}
