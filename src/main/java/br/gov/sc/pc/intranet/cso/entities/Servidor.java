package br.gov.sc.pc.intranet.cso.entities;

import java.io.Serializable;
import java.sql.Date;

public class Servidor implements Serializable {

	private static final long serialVersionUID = -2757210524376245033L;
	
	private String cpf;
	private String nome;
	private String cargo;
	private Date data_nascimento;
	private String matricula;
	private Date data_ingresso;
	private Date data_cargo;
	private String email;
	private String telefone;
	private String celular;
	private String unidade;
		
	
	public Servidor() {
		super();
	}
	
	public Servidor(String cpf, String nome, String cargo, Date data_nascimento, String matricula, Date data_ingresso,
			Date data_cargo, String email, String telefone, String celular, String unidade) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.cargo = cargo;
		this.data_nascimento = data_nascimento;
		this.matricula = matricula;
		this.data_ingresso = data_ingresso;
		this.data_cargo = data_cargo;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.unidade = unidade;
	}

	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public Date getData_nascimento() {
		return data_nascimento;
	}
	
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public Date getData_ingresso() {
		return data_ingresso;
	}
	
	public void setData_ingresso(Date data_ingresso) {
		this.data_ingresso = data_ingresso;
	}
	
	public Date getData_cargo() {
		return data_cargo;
	}
	
	public void setData_cargo(Date data_cargo) {
		this.data_cargo = data_cargo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getUnidade() {
		return unidade;
	}
	
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	@Override
	public String toString() {
		return "Servidor [cpf=" + cpf + ", nome=" + nome + ", cargo=" + cargo + ", data_nascimento=" + data_nascimento
				+ ", matricula=" + matricula + ", data_ingresso=" + data_ingresso + ", data_cargo=" + data_cargo
				+ ", email=" + email + ", telefone=" + telefone + ", celular=" + celular + ", unidade=" + unidade + "]";
	}
	
}
