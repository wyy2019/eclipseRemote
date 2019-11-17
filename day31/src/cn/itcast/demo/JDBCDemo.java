package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


# ���п�ɾ
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
public class JDBCDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		/*1.ע������
			ʹ��java.sql.DriverManager�ྲ̬����registerDriver(Driver driver)
			Driver��һ���ӿڣ��������ݣ�MySQL���������е�ʵ����
			DriverManager.registerDriver(new Driver());
			ͨ����������Driver()��Դ�룬���ǿ��Կ�����ʹ����һ�д���ע��������ע��2����������
			����ע�������Ƽ�ʹ�÷��似��Class.forName("foo.bah.Driver")������������뵽�ڴ�
		 */		
		Class.forName("com.mysql.jdbc.Driver");//��������ע��
		
		//2.������ݿ������,DriverManager���о�̬����
		//DriverManager.getConnection(url, user, password)
		//����ֵ��Connection�ӿ�ʵ����,��mysql����������
		//url:���ݿ����ӵ�ַ		jdbc:mysql://��������IP���˿ں�//���ݿ�����
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		Connection con =  DriverManager.getConnection(url, username, password);

		//3.��ȡ���ִ��ƽ̨��ͨ�����ݿ����Ӷ��󣬻�ȡ��SQL����ִ���߶���
		//con������÷���  Statement createStatement()��ȡStatement���󣬽�SQL��䷢�͵����ݿ�
		//����ֵ��Statement�ӿڵ�ʵ���������mysql����������
		Statement stat = con.createStatement();
		
		//4.ִ��SQL���
		//ͨ��ִ���߶�����÷���ִ��SQL��䣬��ȡ���
		//int executeUpdate(String sql)		ִ�����ݿ��е�SQL���,	insert delete update
		//����ֵint,�����ɹ����ݱ������
		int row = stat.executeUpdate("INSERT INTO sort(sname, sprice, sdesc) VALUES('��������',3000,'���Ŵ���')");
		System.out.println(row);
		
		//6.�ͷ���Դ
		stat.close();
		con.close();
		
	}
}
