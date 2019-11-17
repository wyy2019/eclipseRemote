package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *  Java程序实现用户登录，用户名和密码，数据库检查
 *  演示被别人注入攻击
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
		
		//执行SQL语句，数据表，查询用户和密码，如果存在，登录成功，不存在登录失败
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
