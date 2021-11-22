package br.gov.sc.pc.intranet.cso.entities;

import java.io.Serializable;
import java.sql.Date;

public class Caso implements Serializable {

	private static final long serialVersionUID = 676757126909033935L;
	
	private Integer id;
	private String sgpe;
    private String tipo;
    private String cid;
    private Date data_inicio;
    private Date data_fim_prev;
	private Date data_fim;
	private String servidor;
	private String psi;

	
	public Caso() {
		super();
	}

	public Caso(Integer id, String sgpe, String tipo, String cid, Date data_inicio, Date data_fim_prev,
			Date data_fim, String psi, String servidor) {
		super();
		this.id = id;
		this.sgpe = sgpe;
		this.tipo = tipo;
		this.cid = cid;
		this.data_inicio = data_inicio;
		this.data_fim_prev = data_fim_prev;
		this.data_fim = data_fim;
		this.servidor = servidor;
		this.psi = psi;
		
	}

	public Caso(String sgpe, String tipo, String cid, Date data_inicio, Date data_fim_prev,
			Date data_fim, String psi, String servidor) {
		super();
		this.id = 0;
		this.sgpe = sgpe;
		this.tipo = tipo;
		this.cid = cid;
		this.data_inicio = data_inicio;
		this.data_fim_prev = data_fim_prev;
		this.data_fim = data_fim;
		this.servidor = servidor;
		this.psi = psi;
		
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

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	@Override
	public String toString() {
		return "Caso [id=" + id + ", sgpe=" + sgpe + ", tipo=" + tipo + ", cid=" + cid + ", data_inicio=" + data_inicio
				+ ", data_fim_prev=" + data_fim_prev + ", data_fim=" + data_fim + ", servidor=" + servidor + ", psi="
				+ psi + "]";
	}
	
}
