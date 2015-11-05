package br.com.vectorx.testes2e3.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="tbtipo")
public class Tbtipo {
	@Id
	@SequenceGenerator(name="tbtipo_id_seq", sequenceName="tbtipo_id_seq")
	@GeneratedValue(generator="tbtipo_id_seq",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
