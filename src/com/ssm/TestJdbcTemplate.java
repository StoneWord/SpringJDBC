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
		//初始化spring容器，加载applicationContext.xml配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过容器获得JdbcTemplate实例
		JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
		String sql = "create table user1(id int primary key auto_increment,userName varchar(20),password varchar(32))";
		//使用execute（）方法执行sql语句，创建表
		jdbcTemplate.execute(sql);
		System.out.println("用户表user1创建成功！");
	}
	
	public UserDao getUserDao() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao ud = (UserDao)ctx.getBean("userDao");
		return ud;
	}
	
	
	@Test
	public void addUserTest() {
		UserDao ud = getUserDao();
		User user = new User("贾伟","admin");
		int result = ud.addUser(user);
		
		if(result>0) {
			System.out.println("成功往数据表中插入了"+result+"条数据");
		}else {
			System.out.println("往数据表中插入数据失败！");
		}
	}
	
	
	 @Test 
	 public void updateUserTest() { 
		 UserDao ud = getUserDao();
		 User user = new User(2,"张三","111");
		 int result = ud.updateUser(user);
		 if(result>0) {
			 System.out.println("成功修改了"+result+"条数据");
		 }else {
			 System.out.println("修改操作执行失败！");
		 }
	 }
	 
	 @Test
	 public void deleteUserTest() {
		 UserDao ud = getUserDao();
		 int result = ud.deleteUser(3);
		 if(result>0) {
			 System.out.println("成功删除了"+result+"条数据");
		 }else {
			 System.out.println("删除操作执行失败！");
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
