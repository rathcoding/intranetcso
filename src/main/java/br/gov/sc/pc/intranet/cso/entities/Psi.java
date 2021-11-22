package br.gov.sc.pc.intranet.cso.entities;

import java.io.Serializable;

import br.gov.sc.pc.intranet.cso.util.Criptografia;

public class Psi implements Serializable {

	private static final long serialVersionUID = 8168478245470976275L;
	
	private String cpf;
	private String senha;
	private String lotacao;
	private Integer acesso;
	
	
	public Psi() {
		super();
	}
	
	public Psi(String cpf, String senha, String lotacao, Integer acesso) {
		super();
		this.cpf = cpf;
		this.setSenha(senha);
		this.lotacao = lotacao;
		this.acesso = acesso;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		try {
			this.senha = Criptografia.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getLotacao() {
		return lotacao;
	}
	
	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}
	
	public Integer getAcesso() {
		return acesso;
	}
	
	public void setAcesso(Integer acesso) {
		this.acesso = acesso;
	}
	
	@Override
	public String toString() {
		return "Psi [cpf=" + cpf + ", senha=" + senha + ", lotacao=" + lotacao + ", acesso=" + acesso + "]";
	}
	
}
