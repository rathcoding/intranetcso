package br.gov.sc.pc.intranet.cso.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Caso implements Serializable {

	private static final long serialVersionUID = 676757126909033935L;
	
	private Integer id;
	private String sgpe;
    private String tipo;
    private String cid;
    private Date data_inicio;
    private Date data_fim_prev;
	private Date data_fim;
	private String cpfServidor;
	private String nomeServidor;
	private String cpfPsi;
	private String nomePsi;
	
	private Servidor servidor;
	private List<Intervencao> intervencoes;

	
	public Caso() {
		super();
	}

	public Caso(Integer id, String sgpe, String tipo, String cid, Date data_inicio, Date data_fim_prev,
			Date data_fim, String cpfServidor, String nomeServidor, String cpfPsi, String nomePsi) {
		super();
		this.id = id;
		this.sgpe = sgpe;
		this.tipo = tipo;
		this.cid = cid;
		this.data_inicio = data_inicio;
		this.data_fim_prev = data_fim_prev;
		this.data_fim = data_fim;
		this.cpfServidor = cpfServidor;
		this.nomeServidor = nomeServidor;
		this.cpfPsi = cpfPsi;
		this.nomePsi = nomePsi;
		
	}
	
	public Caso(String sgpe, String tipo, String cid, Date data_inicio, Date data_fim_prev,
			Date data_fim, String cpfServidor, String nomeServidor, String cpfPsi, String nomePsi) {
		super();
		this.id = 0;
		this.sgpe = sgpe;
		this.tipo = tipo;
		this.cid = cid;
		this.data_inicio = data_inicio;
		this.data_fim_prev = data_fim_prev;
		this.data_fim = data_fim;
		this.cpfServidor = cpfServidor;
		this.nomeServidor = nomeServidor;
		this.cpfPsi = cpfPsi;
		this.nomePsi = nomePsi;
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSgpe() {
		return sgpe;
	}

	public void setSgpe(String sgpe) {
		this.sgpe = sgpe;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim_prev() {
		return data_fim_prev;
	}

	public void setData_fim_prev(Date data_fim_prev) {
		this.data_fim_prev = data_fim_prev;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}
	
	public String getCpfServidor() {
		return cpfServidor;
	}

	public void setCpfServidor(String cpfServidor) {
		this.cpfServidor = cpfServidor;
	}
	
	public String getNomeServidor() {
		return nomeServidor;
	}

	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}
	
	public String getCpfPsi() {
		return cpfPsi;
	}

	public void setCpfPsi(String cpfPsi) {
		this.cpfPsi = cpfPsi;
	}
	public String getNomePsi() {
		return nomePsi;
	}

	public void setNomePsi(String nomePsi) {
		this.nomePsi = nomePsi;
	}
	
	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public List<Intervencao> getIntervencoes() {
		return intervencoes;
	}
	
	public void setIntervencoes(List<Intervencao> intervencoes) {
		this.intervencoes = intervencoes;
	}

	@Override
	public String toString() {
		return "Caso [id=" + id + ", sgpe=" + sgpe + ", tipo=" + tipo + ", cid=" + cid + ", data_inicio=" + data_inicio
				+ ", data_fim_prev=" + data_fim_prev + ", data_fim=" + data_fim + ", cpfServidor=" + cpfServidor
				+ ", nomeServidor=" + nomeServidor + ", cpfPsi=" + cpfPsi + ", nomePsi=" + nomePsi + "]";
	}

}
