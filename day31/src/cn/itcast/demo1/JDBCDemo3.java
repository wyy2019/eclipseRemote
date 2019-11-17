package cn.itcast.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *  Java����ʵ���û���¼���û��������룬���ݿ���
 *  ��ֹ������ע�빥��
 *  Statement�ӿ�ʵ���࣬����ִ��SQL��䣬���ؽ����
 *  ��һ���ӽӿ�PreparedStatement  (SQLԤ����洢����θ�Ч��ִ��SQL,���ɷ�ֹע�빥��)
 *  ����ֵ��PreparedStatement�ӿڵ�ʵ������������ݿ������������
 *  ��λ�ȡ�ӿڵ�ʵ���ࣿ
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
		
		//ִ��SQL��䣬���ݱ���ѯ�û������룬������ڣ���¼�ɹ��������ڵ�¼ʧ��
		String sql = "SELECT * FROM users WHERE username=? AND PASSWORD=?";
		//����Connection�ӿڵķ���prepareStatement,��ȡprepareStatement�ӿڵ�ʵ����
		//�����еĲ�����SQL����еĲ���ȫ����?����
		PreparedStatement pst = con.prepareStatement(sql);
		//����pst����set�����������ʺ�ռλ���ϵĲ���
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
