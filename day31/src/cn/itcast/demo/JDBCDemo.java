package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

// hello world 鍙垹杩欒!!!
/**
	DBC寮�鍙戞楠�
		1.娉ㄥ唽椹卞姩.
			鍛婄煡JVM浣跨敤鐨勬槸鍝獄涓�涓暟鎹簱椹卞姩
		2.鑾峰緱杩炴帴.
			浣跨敤JDBC涓殑绫伙紝瀹屾垚瀵筂YSQL鏁版嵁搴撶殑杩炴帴
		3.鑾峰緱璇彞鎵ц骞冲彴
			閫氳繃杩炴帴瀵硅薄鑾峰彇瀵筍QL璇彞鐨勬墽琛岃�呭璞�
		4.鎵цsql璇彞
			浣跨敤鎵ц鑰呭璞★紝鍚戞暟鎹簱鎵цSQL璇彞
			鑾峰彇鍒版暟鎹簱鐨勬墽琛岀粨鏋�
		5.澶勭悊缁撴灉
		6.閲婃斁璧勬簮.
 */
public class JDBCDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		/*1.娉ㄥ唽椹卞姩
			浣跨敤java.sql.DriverManager绫婚潤鎬佹柟娉時egisterDriver(Driver driver)
			Driver鏄竴涓帴鍙ｏ紝鍙傛暟浼犻�掞紝MySQL椹卞姩绋嬪簭涓殑瀹炵幇绫�
			DriverManager.registerDriver(new Driver());
			閫氳繃鐪嬮┍鍔ㄧ被Driver()鐨勬簮鐮侊紝鎴戜滑鍙互鐪嬪埌锛屼娇鐢ㄤ笂涓�琛屼唬鐮佹敞鍐岄┍鍔ㄤ細娉ㄥ唽2娆￠┍鍔ㄧ▼搴�
			鎵�鏈夋敞鍐岄┍鍔ㄦ帹鑽愪娇鐢ㄥ弽灏勬妧鏈疌lass.forName("foo.bah.Driver")锛屽皢椹卞姩绫诲姞鍏ュ埌鍐呭瓨
		 */		
		Class.forName("com.mysql.jdbc.Driver");//閬垮厤涓ゆ娉ㄥ唽
		
		//2.鑾峰緱鏁版嵁搴撶殑杩炴帴,DriverManager绫讳腑闈欐�佹柟娉�
		//DriverManager.getConnection(url, user, password)
		//杩斿洖鍊兼槸Connection鎺ュ彛瀹炵幇绫�,鍦╩ysql椹卞姩绋嬪簭涓�
		//url:鏁版嵁搴撹繛鎺ュ湴鍧�		jdbc:mysql://杩炴帴涓绘満IP锛氱鍙ｅ彿//鏁版嵁搴撳悕瀛�
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		Connection con =  DriverManager.getConnection(url, username, password);

		//3.鑾峰彇璇彞鎵ц骞冲彴锛岄�氳繃鏁版嵁搴撹繛鎺ュ璞★紝鑾峰彇鍒癝QL璇彞鐨勬墽琛岃�呭璞�
		//con瀵硅薄璋冪敤鏂规硶  Statement createStatement()鑾峰彇Statement瀵硅薄锛屽皢SQL璇彞鍙戦�佸埌鏁版嵁搴�
		//杩斿洖鍊兼槸Statement鎺ュ彛鐨勫疄鐜扮被瀵硅薄锛屽湪mysql椹卞姩绋嬪簭涓�
		Statement stat = con.createStatement();
		
		//4.鎵цSQL璇彞
		//閫氳繃鎵ц鑰呭璞¤皟鐢ㄦ柟娉曟墽琛孲QL璇彞锛岃幏鍙栫粨鏋�
		//int executeUpdate(String sql)		鎵ц鏁版嵁搴撲腑鐨凷QL璇彞,	insert delete update
		//杩斿洖鍊糹nt,鎿嶄綔鎴愬姛鏁版嵁琛ㄥ灏戣
		int row = stat.executeUpdate("INSERT INTO sort(sname, sprice, sdesc) VALUES('缇庡缇庡彂',3000,'鐑棬淇冮攢')");
		System.out.println(row);
		
		//6.閲婃斁璧勬簮
		stat.close();
		con.close();
		
	}
}
