package com.zz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.cc.UserJDBCService;
import com.zz.model.User;

@Service
public class UserService {
	@Autowired
	UserJDBCService userJDBCService;

	// 返回所有的数据
	public List<User> seleceAll() {
		return userJDBCService.listStudents();
	}

	public User findName(String name) {
		return userJDBCService.getStudent(name);
	}

	// 通过id查找数据
	public User findId(String id) {
		return userJDBCService.getStudentToId(id);
	}

	public void updateUser(String id, String name, String sex, String phone, String group, String leader) {
		userJDBCService.update(id, name, sex, phone, group, leader);
	}

	public void deleteUser(String id) {
		userJDBCService.delete(id);
	}

	public void addUser(String name, String sex, String phone, String groupz, String leader) {
		userJDBCService.create(name, sex, phone, groupz, leader);
	}
}
