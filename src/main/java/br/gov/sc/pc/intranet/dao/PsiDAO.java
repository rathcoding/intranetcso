package br.gov.sc.pc.intranet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.gov.sc.pc.intranet.cso.entities.Psi;
import br.gov.sc.pc.intranet.cso.util.DBManager;


public class PsiDAO {
	
	private Connection conexao;
	
	public void cadastrar (Psi psi) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "insert into t_cso_psi (cpf, senha, lotacao, acesso) VALUES (?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, psi.getCPF());
			stmt.setString(2, psi.getSenha());
			stmt.setString(3, psi.getLotacao());			
			stmt.setInt(4, psi.getAcesso());
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

	public Psi getOneByCPF(String cpf) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "select * from t_cso_psi where cpf = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();
			
			if (rs.next()){
				String senha = rs.getString("senha");
				String lotacao = rs.getString("lotacao");
				Integer acesso = rs.getInt("acesso");
				Psi psi = new Psi(cpf, senha, lotacao, acesso);
				return psi;
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
		return null;
	}
	
	public List<Psi> getAll(){
		
		List<Psi> lista = new ArrayList<Psi>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("select * from t_cso_psi");
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				String cpf = rs.getString("cpf");
				String senha = rs.getString("senha");
				String lotacao = rs.getString("lotacao");
				Integer acesso = rs.getInt("acesso");
				Psi psi = new Psi(cpf, senha, lotacao, acesso);
				lista.add(psi);
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
