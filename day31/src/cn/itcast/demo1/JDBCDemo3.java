package cn.itcast.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *  Java程序实现用户登录，用户名和密码，数据库检查
 *  防止被别人注入攻击
 *  Statement接口实现类，作用执行SQL语句，返回结果集
 *  有一个子接口PreparedStatement  (SQL预编译存储，多次高效的执行SQL,还可防止注入攻击)
 *  返回值是PreparedStatement接口的实现类对象，在数据库的驱动程序中
 *  如何获取接口的实现类？
 *  	PreparedStatement prepareStatement(String sql)
 *
 */
public class JDBCDemo3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		Scanner sc = new Scanner(System.in);
		String uname = sc.nextLine();
		String pwd = sc.nextLine();
		
		//执行SQL语句，数据表，查询用户和密码，如果存在，登录成功，不存在登录失败
		String sql = "SELECT * FROM users WHERE username=? AND PASSWORD=?";
		//调用Connection接口的方法prepareStatement,获取prepareStatement接口的实现类
		//方法中的参数，SQL语句中的参数全部用?代替
		PreparedStatement pst = con.prepareStatement(sql);
		//调用pst对象set方法，设置问号占位符上的参数
		pst.setObject(1, uname);
		pst.setObject(2, pwd);
		ResultSet rSet = pst.executeQuery();
		while(rSet.next()) {
			System.out.println(rSet.getString("username") + "\t" + rSet.getString("PASSWORD"));
			
		}
		
		rSet.close();
		pst.close();
		con.close();

	}

}
