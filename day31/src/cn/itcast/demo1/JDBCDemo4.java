package cn.itcast.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *  	使用PreparedStatement接口，实现数据表的更新操作
 *
 */
public class JDBCDemo4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		Scanner sc = new Scanner(System.in);
		String sname = sc.nextLine();
		String sprice = sc.nextLine();
		String sdesc = sc.nextLine();
		String sid = sc.nextLine();
		
		String sql = "UPDATE sort SET sname=?,sprice=?,sdesc=? WHERE sid=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setObject(1, sname);
		pst.setObject(2, sprice);
		pst.setObject(3, sdesc);
		pst.setObject(4, sid);
		System.out.println( pst.executeUpdate() );
		
		pst.close();
		con.close();

	}

}
