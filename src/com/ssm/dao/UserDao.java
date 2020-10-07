package com.ssm.dao;

import java.util.List;

import nuc.ssm.entity.User;

public interface UserDao {
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(int id);
	//通过id查询
	public User findUserById(int id);
	//查询所有用户
	public List<User> findAllUser();
}
