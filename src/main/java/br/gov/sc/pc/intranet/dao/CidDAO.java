package br.gov.sc.pc.intranet.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.gov.sc.pc.intranet.cso.util.DBManager;

public class CidDAO implements Serializable {

	private static final long serialVersionUID = 3853167299159254694L;
	
	private Connection conexao;
	
	public List<String> getAll(){
		
		List<String> lista = new ArrayList<String>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("select * from t_cso_cid order by cid asc");
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				
				String cid = rs.getString("cid");
				lista.add(cid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	

}
