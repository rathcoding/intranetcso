package br.gov.sc.pc.intranet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.gov.sc.pc.intranet.cso.entities.Servidor;
import br.gov.sc.pc.intranet.cso.util.DBManager;

public class ServidorDAO {
	
	private Connection conexao;
	
	public void cadastrar (Servidor servidor) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "insert into t_cso_servidor"
					+ " (cpf,"
					+ " nome,"
					+ " cargo,"
					+ " data_nascimento,"
					+ " matricula,"
					+ " data_ingresso,"
					+ " data_cargo,"
					+ " email,"
					+ " telefone,"
					+ " celular,"
					+ " unidade)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, servidor.getCpf());
			stmt.setString(2, servidor.getNome());
			stmt.setString(3, servidor.getCargo());
			stmt.setDate(4, servidor.getData_nascimento());
			stmt.setString(5, servidor.getMatricula());
			stmt.setDate(6, servidor.getData_ingresso());
			stmt.setDate(7, servidor.getData_cargo());
			stmt.setString(8, servidor.getEmail());
			stmt.setString(9, servidor.getTelefone());
			stmt.setString(10, servidor.getCelular());
			stmt.setString(11, servidor.getUnidade());
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

	public Servidor getOneByCpf(String cpf) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			String sql = "select * from t_cso_servidor where cpf = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();
			
			if (rs.next()){
				String nome = rs.getString("nome");
				String cargo = rs.getString("cargo");
				Date data_nascimento = rs.getDate("data_nascimento");
				String matricula = rs.getString("matricula");
				Date data_ingresso = rs.getDate("data_ingresso");
				Date data_cargo = rs.getDate("data_cargo");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				String celular = rs.getString("celular");
				String unidade = rs.getString("unidade");
				
				Servidor servidor = new Servidor(cpf, nome, cargo, data_nascimento, matricula, data_ingresso,
												 data_cargo, email, telefone, celular, unidade);
				return servidor;
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
	
	public List<Servidor> getAll(){
		
		List<Servidor> lista = new ArrayList<Servidor>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = DBManager.obterConexao();
			stmt = conexao.prepareStatement("select * from t_cso_servidor");
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String cargo = rs.getString("cargo");
				Date data_nascimento = rs.getDate("data_nascimento");
				String matricula = rs.getString("matricula");
				Date data_ingresso = rs.getDate("data_ingresso");
				Date data_cargo = rs.getDate("data_cargo");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				String celular = rs.getString("celular");
				String unidade = rs.getString("unidade");
				
				Servidor servidor = new Servidor(cpf, nome, cargo, data_nascimento, matricula, data_ingresso,
												 data_cargo, email, telefone, celular, unidade);
				lista.add(servidor);
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
