package br.gov.sc.pc.intranet.cso.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Intervencao implements Serializable {

	private static final long serialVersionUID = 6455480908642451675L;
	
	private Integer id;
    private String tipo;
    private Date data;
    private Time hora;
    private String notas;
    private String psi;
    private Integer caso;
	
    public Intervencao() {
		super();
	}

	public Intervencao(Integer id, String tipo, Date data, Time hora, String notas, String psi, Integer caso) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.data = data;
		this.hora = hora;
		this.notas = notas;
		this.psi = psi;
		this.caso = caso;
	}

	public Intervencao(String tipo, Date data, Time hora, String notas, String psi, Integer caso) {
		super();
		this.id = 0;
		this.tipo = tipo;
		this.data = data;
		this.hora = hora;
		this.notas = notas;
		this.psi = psi;
		this.caso = caso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getPsi() {
		return psi;
	}

	public void setPsi(String psi) {
		this.psi = psi;
	}

	public Integer getCaso() {
		return caso;
	}

	public void setCaso(Integer caso) {
		this.caso = caso;
	}

	@Override
	public String toString() {
		return "Intervencao [id=" + id + ", tipo=" + tipo + ", data=" + data + ", hora=" + hora + ", notas=" + notas
				+ ", psi=" + psi + ", caso=" + caso + "]";
	}
    
}
