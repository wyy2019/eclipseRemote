package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *  Java����ʵ���û���¼���û��������룬���ݿ���
 *  ��ʾ������ע�빥��
 *
 */
public class JDBCDemo2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stat = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		String uname = sc.nextLine();
		String pwd = sc.nextLine();
		
		//ִ��SQL��䣬���ݱ���ѯ�û������룬������ڣ���¼�ɹ��������ڵ�¼ʧ��
		String sql = "SELECT * FROM users WHERE username='" + uname + "' AND PASSWORD='" + pwd + "'";
		System.out.println(sql);
		ResultSet rSet = stat.executeQuery(sql);
		while(rSet.next()) {
			System.out.println(rSet.getString("username") + "\t" + rSet.getString("PASSWORD"));
			
		}
		
		rSet.close();
		stat.close();
		con.close();

	}

}
