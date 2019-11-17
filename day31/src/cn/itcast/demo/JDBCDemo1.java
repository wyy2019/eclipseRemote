package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
DBC开发步骤
	1.注册驱动.
		告知JVM使用的是哪z一个数据库驱动
	2.获得连接.
		使用JDBC中的类，完成对MYSQL数据库的连接
	3.获得语句执行平台
		通过连接对象获取对SQL语句的执行者对象
	4.执行sql语句
		使用执行者对象，向数据库执行SQL语句
		获取到数据库的执行结果
	5.处理结果
	6.释放资源.
*/
public class JDBCDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.注册驱动.
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2.获得连接对象
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		// 3.获得SQL语句执行平台
		Statement stat = con.createStatement();
		
		// 4.执行sql语句获取结果集
		// ResultSet executeQuery(String sql)	执行SQL语句中的select查询
		//返回值ResultSet接口的实现类对象，实现类在mysql驱动中
		ResultSet rSet = stat.executeQuery("SELECT * FROM sort;");
		
		// 5.处理结果
		//ResultSet接口方法boolean next() 返回true,有结果集，返回false没有结果集
		while(rSet.next()) {
			//获取每列数据，使用ResultSet接口的方法getXxx()，方法的参数建议写列名
			System.out.println(rSet.getInt("sid") + "\t" +  rSet.getString("sname") + 
					"\t" + rSet.getDouble("sprice") + "\t" + rSet.getString("sdesc"));
		}
		
		// 6.关闭资源
		rSet.close();
		stat.close();
		con.close();
	}

}
