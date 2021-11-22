package br.gov.sc.pc.intranet.cso.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

	public static Connection obterConexao() {
		
		Connection conexao = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String serverName = "localhost";
			String mydatabase = "cso";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root";
			String password = "root";
			
			conexao = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conexao;
	}
}
