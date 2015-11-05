package br.com.vectorx.testes2e3.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="tbano")
public class Tbano {
	@Id
	@SequenceGenerator(name="tbano_id_seq", sequenceName="tbano_id_seq")
	@GeneratedValue(generator="tbano_id_seq",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	private Integer ano;
	
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
