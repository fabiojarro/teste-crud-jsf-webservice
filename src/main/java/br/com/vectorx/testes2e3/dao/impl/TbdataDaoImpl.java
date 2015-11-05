package br.com.vectorx.testes2e3.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.vectorx.testes2e3.dao.ITbdataDao;
import br.com.vectorx.testes2e3.entidade.Tbdata;
import br.com.vectorx.testes2e3.util.JpaUtil;

public class TbdataDaoImpl implements ITbdataDao {

	public TbdataDaoImpl() {
		
	}
	
	public List<Tbdata> listarDatas(){
		EntityManager manager = new JpaUtil().getEntityManager();
		Query query = manager.createQuery("select tb from Tbdata tb");
		@SuppressWarnings("unchecked")
		List<Tbdata> tbdatas = query.getResultList();
		manager.close();
		return tbdatas;
	}
	public Tbdata buscaPorData(Calendar calendar) {		
		
		EntityManager manager = new JpaUtil().getEntityManager();
		
		Query query = manager.createQuery
						("select tb from Tbdata tb where :pData>=tb.datainicio and" +
						" :pData <=tb.datafim");
		
		query.setParameter("pData", calendar);
		
		@SuppressWarnings("unchecked")
		List<Tbdata> tbdata = query.getResultList();
		manager.close();
		return tbdata.isEmpty()? null : tbdata.get(0);
	}
	
	public Tbdata buscaProximoFeriado(Calendar calendar){
		
		EntityManager manager = new JpaUtil().getEntityManager();
	    
		Query query = manager.createQuery
						("select tb from Tbdata tb where tb.datainicio>:pData" +
						" order by tb.datainicio");
		
		query.setParameter("pData", calendar);		
		@SuppressWarnings("unchecked")
		List<Tbdata> tbdata = query.getResultList();
		manager.close();		
		return tbdata.isEmpty()? null : tbdata.get(0);
	}
	
	public void atualiza(Tbdata tbdata) {
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();

		em.merge(tbdata);

		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Tbdata tbdata) {
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(tbdata));
		em.getTransaction().commit();
		em.close();
	}

	public Tbdata busporId(Integer idData) {
		EntityManager em = new JpaUtil().getEntityManager();
		Tbdata tbdata = em.find(Tbdata.class, idData);
		em.close();
		return tbdata;
	}

	public void inserir(Tbdata tbdata) {

		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(tbdata);
		em.getTransaction().commit();
		em.close();
		
	}
}
