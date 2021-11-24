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
	private String psi;
	private String servidorCPF;
	private Servidor servidor;
	private List<Intervencao> intervencoes;

	
	public Caso() {
		super();
	}

//	public Caso(Integer id, String sgpe, String tipo, String cid, Date data_inicio, Date data_fim_prev,
//			Date data_fim, String psi, String servidorCPF, Servidor servidor) {
//		super();
//		this.id = id;
//		this.sgpe = sgpe;
//		this.tipo = tipo;
//		this.cid = cid;
//		this.data_inicio = data_inicio;
//		this.data_fim_prev = data_fim_prev;
//		this.data_fim = data_fim;
//		this.psi = psi;
//		this.servidorCPF = servidorCPF;
//		this.servidor = servidor;
//		
//	}

	public Caso(Integer id, String sgpe, String tipo, String cid, Date data_inicio, Date data_fim_prev,
			Date data_fim, String psi, String servidorCPF) {
		super();
		this.id = id;
		this.sgpe = sgpe;
		this.tipo = tipo;
		this.cid = cid;
		this.data_inicio = data_inicio;
		this.data_fim_prev = data_fim_prev;
		this.data_fim = data_fim;
		this.psi = psi;
		this.servidorCPF = servidorCPF;
		
	}
	
	public Caso(String sgpe, String tipo, String cid, Date data_inicio, Date data_fim_prev,
			Date data_fim, String psi, String servidorCPF) {
		super();
		this.id = 0;
		this.sgpe = sgpe;
		this.tipo = tipo;
		this.cid = cid;
		this.data_inicio = data_inicio;
		this.data_fim_prev = data_fim_prev;
		this.data_fim = data_fim;
		this.psi = psi;
		this.servidorCPF = servidorCPF;
		
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
	
	public String getPsi() {
		return psi;
	}

	public void setPsi(String psi) {
		this.psi = psi;
	}
	
	public String getServidorCPF() {
		return servidorCPF;
	}

	public void setServidorCPF(String servidorCPF) {
		this.servidorCPF = servidorCPF;
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
		return "Caso [id=" + id + ", sgpe=" + sgpe + ", tipo=" + tipo + ", cid=" + cid 
				+ ", data_inicio=" + data_inicio + ", data_fim_prev=" + data_fim_prev 
				+ ", data_fim=" + data_fim + ", psi=" + psi + ", servidorCPF=" + servidorCPF + "]";
	}

}
