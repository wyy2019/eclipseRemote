package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


# 这行可删
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
public class JDBCDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		/*1.注册驱动
			使用java.sql.DriverManager类静态方法registerDriver(Driver driver)
			Driver是一个接口，参数传递，MySQL驱动程序中的实现类
			DriverManager.registerDriver(new Driver());
			通过看驱动类Driver()的源码，我们可以看到，使用上一行代码注册驱动会注册2次驱动程序
			所有注册驱动推荐使用反射技术Class.forName("foo.bah.Driver")，将驱动类加入到内存
		 */		
		Class.forName("com.mysql.jdbc.Driver");//避免两次注册
		
		//2.获得数据库的连接,DriverManager类中静态方法
		//DriverManager.getConnection(url, user, password)
		//返回值是Connection接口实现类,在mysql驱动程序中
		//url:数据库连接地址		jdbc:mysql://连接主机IP：端口号//数据库名字
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		Connection con =  DriverManager.getConnection(url, username, password);

		//3.获取语句执行平台，通过数据库连接对象，获取到SQL语句的执行者对象
		//con对象调用方法  Statement createStatement()获取Statement对象，将SQL语句发送到数据库
		//返回值是Statement接口的实现类对象，在mysql驱动程序中
		Statement stat = con.createStatement();
		
		//4.执行SQL语句
		//通过执行者对象调用方法执行SQL语句，获取结果
		//int executeUpdate(String sql)		执行数据库中的SQL语句,	insert delete update
		//返回值int,操作成功数据表多少行
		int row = stat.executeUpdate("INSERT INTO sort(sname, sprice, sdesc) VALUES('美容美发',3000,'热门促销')");
		System.out.println(row);
		
		//6.释放资源
		stat.close();
		con.close();
		
	}
}
