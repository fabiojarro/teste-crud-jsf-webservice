package br.com.vectorx.testes2e3.dao;

import java.util.Calendar;
import java.util.List;

import br.com.vectorx.testes2e3.entidade.Tbdata;

public interface ITbdataDao {
	Tbdata buscaPorData(Calendar calendar);
	Tbdata buscaProximoFeriado(Calendar calendar);
	List<Tbdata> listarDatas();
}
