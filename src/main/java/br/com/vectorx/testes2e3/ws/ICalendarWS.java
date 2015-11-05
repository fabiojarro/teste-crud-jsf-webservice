package br.com.vectorx.testes2e3.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import br.com.vectorx.testes2e3.ws.fault.DataException;

@WebService
public interface ICalendarWS {
	
	@WebMethod(action="VerificaDataNaoUtil",operationName="VerificaDataNaoUtil")
	@WebResult(name="DataNaoUtil")
	boolean isDataNaoUtil(@XmlElement(required=true) @WebParam(name="Data") String data) throws DataException;
	
	@WebMethod(action="RetornaProximaDataNaoUtil",operationName="RetornaProximaDataNaoUtil")
	@WebResult(name="ProximaDataUtil")
	String getDataNaoUtil();
}
