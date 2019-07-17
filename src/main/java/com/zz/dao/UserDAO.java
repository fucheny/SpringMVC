package com.zz.dao;

import java.util.List;

import com.zz.model.User;

public interface UserDAO {

//	public void setDataSource(DataSource ds);

	public void create(String name, String sex, String phone, String group, String leader);

	public User getStudent(String name);

	// 通过id查找学生数据
	public User getStudentToId(String id);

	public List<User> listStudents();

	public void delete(String id);

	public void update(String id, String name, String sex, String phone, String group, String leader);

}
