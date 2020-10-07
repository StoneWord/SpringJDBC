package com.ssm.dao;

import java.util.List;

import nuc.ssm.entity.User;

public interface UserDao {
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(int id);
	//ͨ��id��ѯ
	public User findUserById(int id);
	//��ѯ�����û�
	public List<User> findAllUser();
}
