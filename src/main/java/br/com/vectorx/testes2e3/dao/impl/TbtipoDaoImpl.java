package br.com.vectorx.testes2e3.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.vectorx.testes2e3.dao.ITbtipo;
import br.com.vectorx.testes2e3.entidade.Tbtipo;
import br.com.vectorx.testes2e3.util.JpaUtil;

public class TbtipoDaoImpl implements ITbtipo {

	
	public List<Tbtipo> listarTipos() {
		EntityManager manager = new JpaUtil().getEntityManager();
		Query query = manager.createQuery("select tb from Tbtipo tb");
		@SuppressWarnings("unchecked")
		List<Tbtipo> tbtipos = query.getResultList();
		manager.close();
		return tbtipos;
	}
	public Tbtipo buscaPorId(Integer id) {
		EntityManager em = new JpaUtil().getEntityManager();
		Tbtipo tbtipo = em.find(Tbtipo.class, id);
		em.close();
		return tbtipo;
	}

}
