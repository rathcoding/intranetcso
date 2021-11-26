package br.gov.sc.pc.intranet.cso.dto;

import java.io.Serializable;

public class PsiDTO implements Serializable {

	private static final long serialVersionUID = -7816651641448190712L;
	
	private String cpf;
	private String nome;
	private String lotacao;
	private Integer acesso;
	
	public PsiDTO () {
		super();
	}
	
	public PsiDTO(String cpf, String nome, String lotacao, Integer acesso) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.lotacao = lotacao;
		this.acesso = acesso;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return "PsiDTO [cpf=" + cpf + ", nome=" + nome + ", lotacao=" + lotacao + ", acesso=" + acesso + "]";
	}
	
	

}
