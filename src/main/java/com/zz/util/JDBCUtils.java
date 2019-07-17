package com.zz.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.zz.model.User;

/**
 *
 * @author Administrator
 */
@Service
public class JDBCUtils {

	/*
	 * private static final String driver = "com.mysql.jdbc.Driver"; // 数据库驱动 //
	 * 连接数据库的URL地址 private static final String url =
	 * "jdbc:mysql://localhost:3306/zuopin20164081337?useSSL=false"; private static
	 * final String username = "root";// 数据库的用户名 private static final String
	 * password = "admin";// 数据库的密码
	 * 
	 * private static Connection conn = null;
	 * 
	 * // 静态代码块负责加载驱动 static { try { Class.forName(driver);
	 * System.out.println("加载成功"); } catch (Exception ex) { ex.printStackTrace(); }
	 * }
	 */

	public static DataSource ds = null;

	static {
		// 新建一个配置文件对象
		Properties prop = new Properties();
		try {
			// 通过类加载器找到文件路径，读配置文件
			InputStream in = new JDBCUtils().getClass().getClassLoader().getResourceAsStream("jdbc.properties");
			// 把文件以输入流的形式加载到配置对象中
			prop.load(in);
			// 创建数据源对象
			ds = DruidDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			System.out.println("连接数据库成功!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			// ?判断rs 等是否为空
			// 1.没有意义
			// 2.如果为空会出现空指针异常
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	public static void main(String[] args) {
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			System.out.println("链接成功");
		} else {
			System.out.println("连接失败");
		}

		String sql = "select * from person";

		Connection conn = JDBCUtils.getConnection(); // 获取数据库连接
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<User> lists = new ArrayList<User>();
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setSex(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setGroupz(rs.getString(6));
				user.setLeader(rs.getString(6));
				System.out.println("-------获取数据中--------");
				System.out.println(user.toString());
				lists.add(user);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	*/

}
