package br.gov.sc.pc.intranet.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.gov.sc.pc.intranet.cso.util.DBManager;

public class TipoCasoDAO implements Serializable {

	private static final long serialVersionUID = -4093354714781377566L;
	
	private Connection conexao;
	
	public List<String> getAll(){
		
		List<String> lista = new ArrayList<String>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("select * from t_cso_tipo_caso order by tipo asc");
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				
				String tipo = rs.getString("tipo");
				lista.add(tipo);
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
