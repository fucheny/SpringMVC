package com.zz.cc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.dao.UserDAO;
import com.zz.model.User;
import com.zz.util.JDBCUtils;

@Service
public class UserJDBCService implements UserDAO {

	@Autowired
	JDBCUtils jDBCUtils;

	// 添加实习生数据
	@Override
	public void create(String name, String sex, String phone, String groupz, String leader) {
		String sql = "INSERT INTO person (name, sex, phone, groupz, leader) VALUES (?, ?, ?, ?, ?)";
		Connection conn = jDBCUtils.getConnection();
		// 定义预编译语句对象，此对象可执行动态sql命令。
		PreparedStatement pstmt = null;
		System.out.println("正在插入数据");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, sex);
			pstmt.setString(3, phone);
			pstmt.setString(4, groupz);
			pstmt.setString(5, leader);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtils.close(conn, pstmt, null);
			System.out.println("插入数据成功");
		}
	}

	// 通过名字查询实习生数据
	@Override
	public User getStudent(String name) {
		String sql = "select * from person where name = ?";
		Connection conn = jDBCUtils.getConnection(); // 获取数据库连接
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(Integer.parseInt(rs.getString(1)));
				user.setName(rs.getString(2));
				user.setSex(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setGroupz(rs.getString(5));
				user.setLeader(rs.getString(6));
			}
			System.out.println("查询出来了：" + user.toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return user;
	}

	// 通过ID查询实习生数据
	@Override
	public User getStudentToId(String id) {
		String sql = "select * from person where id = ?";
		Connection conn = jDBCUtils.getConnection(); // 获取数据库连接
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(Integer.parseInt(rs.getString(1)));
				user.setName(rs.getString(2));
				user.setSex(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setGroupz(rs.getString(5));
				user.setLeader(rs.getString(6));
			}
			System.out.println("查询出来了：" + user.toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return user;
	}

	// 返回所有实习生的数据
	@Override
	public List<User> listStudents() {

		String sql = "select * from person";
		Connection conn = jDBCUtils.getConnection(); // 获取数据库连接
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<User> lists = new ArrayList<User>();
		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setSex(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setGroupz(rs.getString(5));
				user.setLeader(rs.getString(6));
//				System.out.println("--------获取数据中--------");
//				System.out.println(user.toString());
				lists.add(user);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lists;
	}

	// 通过名字 字段 删除实习生的数据
	@Override
	public void delete(String id) {
		String sql = "delete from person where id = ?";

		Connection conn = jDBCUtils.getConnection(); // 获取数据库连接
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.executeUpdate(); // 执行删除操作
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 通过名字字段来更新实习生的 数据
	@Override
	public void update(String id, String name, String sex, String phone, String group, String leader) {
		String sql = "update person set name=?, sex=?,phone=?, groupz=?, leader=? WHERE id=?";
		Connection conn = jDBCUtils.getConnection(); // 获取数据库连接
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, sex);
			pstmt.setString(3, phone);
			pstmt.setString(4, group);
			pstmt.setString(5, leader);
			pstmt.setInt(6, Integer.parseInt(id));
			pstmt.executeUpdate(); // 执行删除操作
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
