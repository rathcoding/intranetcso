package br.gov.sc.pc.intranet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.gov.sc.pc.intranet.cso.entities.Caso;
import br.gov.sc.pc.intranet.cso.util.DBManager;

public class CasoDAO {

	private Connection conexao;
	
	public void cadastrar (Caso caso) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "insert into t_cso_caso "
						+ "(id,"
						+ " sgpe,"
						+ " tipo,"
						+ " cid,"
						+ " data_inicio,"
						+ " data_fim_prev,"
						+ " data_fim,"
						+ " psi,"
						+ " servidor)"
						+ "VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, caso.getSgpe());
			stmt.setString(2, caso.getTipo());
			stmt.setString(3, caso.getCid());
			stmt.setDate(4, caso.getData_inicio());
			stmt.setDate(5, caso.getData_fim_prev());
			stmt.setDate(6, caso.getData_fim());
			stmt.setString(7, caso.getPsi());
			stmt.setString(8, caso.getServidor());
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
	
	public List<Caso> getAllByPsi(String psi){
		
		List<Caso> lista = new ArrayList<Caso>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("select * from t_cso_caso where psi = ? order by data_inicio desc");
			stmt.setString(1, psi);
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String sgpe = rs.getString("sgpe");
			    String tipo = rs.getString("tipo");
			    String cid = rs.getString("cid");
			    Date data_inicio = rs.getDate("data_inicio");
			    Date data_fim_prev = rs.getDate("data_fim_prev");
				Date data_fim = rs.getDate("data_fim");
			    String servidor = rs.getString("servidor");
				Caso caso = new Caso(id, sgpe, tipo, cid, data_inicio, data_fim_prev, data_fim, psi, servidor);
				lista.add(caso);
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
	
	public Caso getOneById(Integer id){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Caso caso = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("select * from t_cso_caso where id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
		
			if (rs.next()) {
				String sgpe = rs.getString("sgpe");
			    String tipo = rs.getString("tipo");
			    String cid = rs.getString("cid");
			    Date data_inicio = rs.getDate("data_inicio");
			    Date data_fim_prev = rs.getDate("data_fim_prev");
				Date data_fim = rs.getDate("data_fim");
				String psi = rs.getString("psi");
			    String servidor = rs.getString("servidor");
				caso = new Caso(id, sgpe, tipo, cid, data_inicio, data_fim_prev, data_fim, psi, servidor);
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
		
		return caso;
		
	}

	
	public void deleteOne (Integer id) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "delete from t_cso_caso where id = ? cascade";
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

	public void updateOne (Caso caso) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "update t_cso_caso set"
					+ " sgpe = ?,"
					+ " tipo = ?,"
					+ " cid = ?,"
					+ " data_inicio = ?,"
					+ " data_fim_prev = ?,"
					+ " data_fim = ?,"
					+ " psi = ?,"
					+ " servidor = ?"
					+ "WHERE id = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, caso.getSgpe());
			stmt.setString(2, caso.getTipo());
			stmt.setString(3, caso.getCid());
			stmt.setDate(4, caso.getData_inicio());
			stmt.setDate(5, caso.getData_fim_prev());
			stmt.setDate(6, caso.getData_fim());
			stmt.setString(7, caso.getPsi());
			stmt.setString(8, caso.getServidor());
			stmt.setInt(9, caso.getId());
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

