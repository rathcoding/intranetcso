package br.gov.sc.pc.intranet.cso.dao;

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
						+ " cpfServidor,"
						+ " nomeServidor,"
						+ " cpfPsi,"
						+ " nomePsi)"
						+ "VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, caso.getSgpe());
			stmt.setString(2, caso.getTipo());
			stmt.setString(3, caso.getCid());
			stmt.setDate(4, caso.getData_inicio());
			stmt.setDate(5, caso.getData_fim_prev());
			stmt.setDate(6, caso.getData_fim());
			stmt.setString(7, caso.getCpfServidor());
			stmt.setString(8, caso.getNomeServidor());
			stmt.setString(9, caso.getCpfPsi());
			stmt.setString(10, caso.getNomePsi());
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
			stmt = conexao.prepareStatement("select * from t_cso_caso where cpfPsi = ? order by data_inicio desc");
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
			    String cpfServidor = rs.getString("cpfServidor");
			    String nomeServidor = rs.getString("nomeServidor");
			    String nomePsi = rs.getString("nomePsi");
				Caso caso = new Caso(id, sgpe, tipo, cid, data_inicio, data_fim_prev, data_fim, cpfServidor, nomeServidor, psi, nomePsi);
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
			    String cpfServidor = rs.getString("cpfServidor");
			    String nomeServidor = rs.getString("nomeServidor");
				String cpfPsi = rs.getString("cpfPsi");
				String nomePsi = rs.getString("nomePsi");
				caso = new Caso(id, sgpe, tipo, cid, data_inicio, data_fim_prev, data_fim, cpfServidor, nomeServidor, cpfPsi, nomePsi);
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

	public List<Caso> getAllByServidor(String cpf){
		
		List<Caso> lista = new ArrayList<Caso>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("select * from t_cso_caso where cpfServidor = ? order by data_inicio desc");
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String sgpe = rs.getString("sgpe");
			    String tipo = rs.getString("tipo");
			    String cid = rs.getString("cid");
			    Date data_inicio = rs.getDate("data_inicio");
			    Date data_fim_prev = rs.getDate("data_fim_prev");
				Date data_fim = rs.getDate("data_fim");
			    String nomeServidor = rs.getString("nomeServidor");
			    String cpfPsi = rs.getString("cpfPsi");
			    String nomePsi = rs.getString("nomePsi");
				Caso caso = new Caso(id, sgpe, tipo, cid, data_inicio, data_fim_prev, data_fim, cpf, nomeServidor, cpfPsi, nomePsi);
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
	
	public void deleteOne (Integer id) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "delete from t_cso_caso where id = ?";
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
					+ " cpfPsi = ?,"
					+ " nomePsi = ?"
					+ "WHERE id = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, caso.getSgpe());
			stmt.setString(2, caso.getTipo());
			stmt.setString(3, caso.getCid());
			stmt.setDate(4, caso.getData_inicio());
			stmt.setDate(5, caso.getData_fim_prev());
			stmt.setDate(6, caso.getData_fim());
			stmt.setString(7, caso.getCpfPsi());
			stmt.setString(8, caso.getNomePsi());
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

