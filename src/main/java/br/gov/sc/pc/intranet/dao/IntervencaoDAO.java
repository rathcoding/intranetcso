package br.gov.sc.pc.intranet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.gov.sc.pc.intranet.cso.entities.Intervencao;
import br.gov.sc.pc.intranet.cso.util.DBManager;

public class IntervencaoDAO {

	private Connection conexao;
	
	public void cadastrar (Intervencao intervencao) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "insert into t_cso_intervencao "
						+ "(id,"
						+ " tipo,"
						+ " data,"
						+ " hora,"
						+ " notas,"
						+ " psi,"
						+ " nome_psi,"
						+ " caso)"
						+ "VALUES (0, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, intervencao.getTipo());
			stmt.setDate(2, intervencao.getData());
			stmt.setTime(3, intervencao.getHora());
			stmt.setString(4, intervencao.getNotas());
			stmt.setString(5, intervencao.getPsi());
			stmt.setString(6, intervencao.getNomePsi());
			stmt.setInt(7, intervencao.getCaso());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<Intervencao> getAllByCaso(Integer caso){
		
		List<Intervencao> lista = new ArrayList<Intervencao>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("select * from t_cso_intervencao where caso = ? order by data asc");
			stmt.setInt(1, caso);
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				
				Integer id = rs.getInt("id");
				String tipo = rs.getString("tipo");
				Date data = rs.getDate("data");
			    Time hora = rs.getTime("hora");
			    String notas = rs.getString("notas");
			    String psi = rs.getString("psi");
			    String nomePsi = rs.getString("nome_psi");
				Intervencao intervencao = new Intervencao(id, tipo, data, hora, notas, psi, nomePsi, caso);
				lista.add(intervencao);
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
	
	public Intervencao getOneById(Integer id){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Intervencao intervencao = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("select * from t_cso_intervencao where id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
		
			if (rs.next()) {
				String tipo = rs.getString("tipo");
				Date data = rs.getDate("data");
			    Time hora = rs.getTime("hora");
			    String notas = rs.getString("notas");
			    String psi = rs.getString("psi");
			    String nomePsi = rs.getString("nome_psi");
				Integer caso = rs.getInt("caso");
				intervencao = new Intervencao(id, tipo, data, hora, notas, psi, nomePsi, caso);
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
		
		return intervencao;
		
	}

	
	public void deleteOne (Integer id) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "delete from t_cso_intervencao where id = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void updateOne (Intervencao intervencao) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "update t_cso_intervencao set"
					+ " tipo = ?,"
					+ " data = ?,"
					+ " hora = ?,"
					+ " notas = ?"
					+ "WHERE id = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, intervencao.getTipo());
			stmt.setDate(2, intervencao.getData());
			stmt.setTime(3, intervencao.getHora());
			stmt.setString(4, intervencao.getNotas());
			stmt.setInt(5, intervencao.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
