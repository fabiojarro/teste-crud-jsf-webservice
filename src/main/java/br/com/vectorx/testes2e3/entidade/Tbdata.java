package br.com.vectorx.testes2e3.entidade;

import java.util.Calendar;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="tbdata")
public class Tbdata {
	@Id
	@SequenceGenerator(name="tbdata_id_seq", sequenceName="tbdata_id_seq")
	@GeneratedValue(generator="tbdata_id_seq",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne 
	@JoinColumn(name="fkano") 
	private Tbano tbano;
	
	@ManyToOne 
	@JoinColumn(name="fktipo") 
	private Tbtipo tbtipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar datainicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar datafim;
	
	private String descricao;

	public Tbdata(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tbano getTbano() {
		return tbano;
	}

	public void setTbano(Tbano tbano) {
		this.tbano = tbano;
	}

	public Tbtipo getTbtipo() {
		return tbtipo;
	}

	public void setTbtipo(Tbtipo tbtipo) {
		this.tbtipo = tbtipo;
	}

	public Calendar getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(Calendar datainicio) {
		this.datainicio = datainicio;
	}

	public Calendar getDatafim() {
		return datafim;
	}

	public void setDatafim(Calendar datafim) {
		this.datafim = datafim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
