package br.com.vectorx.testes2e3.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.vectorx.testes2e3.dao.ITbanoDao;
import br.com.vectorx.testes2e3.entidade.Tbano;
import br.com.vectorx.testes2e3.util.JpaUtil;

public class TbanoDaoImpl implements ITbanoDao{
	
	public TbanoDaoImpl(){
		
	}
	
	public Tbano buscaPorAno(Integer ano) {
		EntityManager manager = new JpaUtil().getEntityManager();
		Query query = manager.createQuery("select tb from Tbano tb where tb.ano=:pAno");
		query.setParameter("pAno", ano);
		
		@SuppressWarnings("unchecked")
		List<Tbano> tbanos = query.getResultList();
		manager.close();
		return tbanos.isEmpty()? null : tbanos.get(0);
	}
	public Tbano buscaPorId(Integer id) {
		EntityManager em = new JpaUtil().getEntityManager();
		Tbano tbano = em.find(Tbano.class, id);
		em.close();
		return tbano;
	}
	public void adiciona(Tbano tbano) {
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(tbano);
		em.getTransaction().commit();
		em.close();
	}
}
