package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
DBC��������
	1.ע������.
		��֪JVMʹ�õ�����zһ�����ݿ�����
	2.�������.
		ʹ��JDBC�е��࣬��ɶ�MYSQL���ݿ������
	3.������ִ��ƽ̨
		ͨ�����Ӷ����ȡ��SQL����ִ���߶���
	4.ִ��sql���
		ʹ��ִ���߶��������ݿ�ִ��SQL���
		��ȡ�����ݿ��ִ�н��
	5.������
	6.�ͷ���Դ.
*/
public class JDBCDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.ע������.
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2.������Ӷ���
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		
		// 3.���SQL���ִ��ƽ̨
		Statement stat = con.createStatement();
		
		// 4.ִ��sql����ȡ�����
		// ResultSet executeQuery(String sql)	ִ��SQL����е�select��ѯ
		//����ֵResultSet�ӿڵ�ʵ�������ʵ������mysql������
		ResultSet rSet = stat.executeQuery("SELECT * FROM sort;");
		
		// 5.������
		//ResultSet�ӿڷ���boolean next() ����true,�н����������falseû�н����
		while(rSet.next()) {
			//��ȡÿ�����ݣ�ʹ��ResultSet�ӿڵķ���getXxx()�������Ĳ�������д����
			System.out.println(rSet.getInt("sid") + "\t" +  rSet.getString("sname") + 
					"\t" + rSet.getDouble("sprice") + "\t" + rSet.getString("sdesc"));
		}
		
		// 6.�ر���Դ
		rSet.close();
		stat.close();
		con.close();
	}

}
