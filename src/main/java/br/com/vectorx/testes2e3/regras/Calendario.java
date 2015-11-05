package br.com.vectorx.testes2e3.regras;

import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import br.com.vectorx.testes2e3.dao.ITbdataDao;
import br.com.vectorx.testes2e3.dao.impl.TbdataDaoImpl;
import br.com.vectorx.testes2e3.entidade.Tbdata;

public class Calendario {

	private static DateTime diaNaoUtil(DateTime datetime){
		datetime = datetime.dayOfMonth().roundFloorCopy();
		ITbdataDao tbdataDao = new TbdataDaoImpl();
		Tbdata tbdata = tbdataDao.buscaProximoFeriado(datetime.toCalendar(Locale.getDefault()));
		if (tbdata != null){
			return new DateTime(tbdata.getDatainicio());	
		}else{
			return null;
		}
	}
	
	private static DateTime proximoFinaldeSemana(DateTime datetime){
		
		datetime = datetime.dayOfMonth().roundFloorCopy();
		if(datetime.getDayOfWeek() == DateTimeConstants.SUNDAY){
			return datetime.plusDays(6);
		}
		if(datetime.getDayOfWeek() == DateTimeConstants.SATURDAY){
			return datetime.plusDays(1);
		}
		Integer dias = DateTimeConstants.SATURDAY - datetime.getDayOfWeek();
		return datetime.plusDays(dias);
	}
	
	private static boolean isFeriadoPonto(DateTime data){		
		ITbdataDao tbdatadao = new TbdataDaoImpl();
		Tbdata tbdata = tbdatadao.buscaPorData(data.toCalendar(Locale.getDefault()));
		return tbdata == null ? false : true;
	}	
	
	private static boolean isFinaldeSemana(DateTime data){
		if(data.getDayOfWeek() == DateTimeConstants.SUNDAY || data.getDayOfWeek()== DateTimeConstants.SATURDAY){
			return true;
		}
			return false;
	}
	
	public static boolean isDataValida(DateTime data){
		return isFinaldeSemana(data) || isFeriadoPonto(data) ;
	}
	
	
	public static DateTime getProximaDataNaoUtil(DateTime diadasemana){
		
		DateTime proximoFinalSemana = proximoFinaldeSemana(diadasemana);
		
		DateTime proximoDiaNaoUtil = diaNaoUtil(diadasemana);
		
		if(proximoDiaNaoUtil==null){
			return proximoFinalSemana;
		}
		
		return proximoFinalSemana.isBefore(proximoDiaNaoUtil) ? proximoFinalSemana : proximoDiaNaoUtil;
	}
	
}
