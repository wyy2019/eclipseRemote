package cn.itcast.jdbcutil;
/**
 *  ʵ��JDBC�Ĺ�����
 *  ���巽����ֱ�ӷ������ݿ�����Ӷ���
 *  
 *  ���巽�����ر���Դ
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class JDBCUtils {
	
	//1.��������˽�л�
	/*
	 * ��Ϊ������һ������¶��Ǿ�ֱ̬�ӵ��õģ�����Ҫ����
	 * ���Խ����췽��˽�л�����������������
	 */
	private JDBCUtils() {}	
	
	private static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String password = "root";
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e + "���ݿ�����ʧ��!");
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public static void close(Connection con, Statement stat) {
		if(stat!=null) {
			try {
				stat.close();
			} catch (SQLException e) {}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {}
		}
	}
	
	public static void close(Connection con, Statement stat, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		
		if(stat!=null) {
			try {
				stat.close();
			} catch (SQLException e) {}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {}
		}
	}
	
}
