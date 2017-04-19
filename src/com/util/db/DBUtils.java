package com.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	private static String DRIVER;
	
	private static ResourceBundle rb = ResourceBundle.getBundle("com.util.db.db_config");
	
	
	private DBUtils(){}
	
	//ʹ�þ�̬�������������
	static{
		try {
			URL = rb.getString("jdbc.url");
			USERNAME = rb.getString("jdbc.username");
			PASSWORD = rb.getString("jdbc.password");
			DRIVER = rb.getString("jdbc.driver");
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//����һ�����ݿ����ӵķ���
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��ȡ����ʧ��");
		}
		return conn;
		
	}
	
	//�ر����ݿ�����
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
}
