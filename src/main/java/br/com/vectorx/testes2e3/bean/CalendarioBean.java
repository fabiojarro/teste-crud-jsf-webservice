package br.com.vectorx.testes2e3.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.vectorx.testes2e3.dao.impl.TbanoDaoImpl;
import br.com.vectorx.testes2e3.dao.impl.TbdataDaoImpl;
import br.com.vectorx.testes2e3.dao.impl.TbtipoDaoImpl;
import br.com.vectorx.testes2e3.entidade.Tbano;
import br.com.vectorx.testes2e3.entidade.Tbdata;
import br.com.vectorx.testes2e3.entidade.Tbtipo;
import br.com.vectorx.testes2e3.util.DataUtil;


@ManagedBean(name="datasbean")
@ViewScoped
public class CalendarioBean implements Serializable{
	
	private static final long serialVersionUID = 5397665964773343773L;

	private Tbano frmtbano = new Tbano();
	
	private Tbtipo frmtbtipo = new Tbtipo();
	
	private Date frmdatainicio;
	
	private Date frmdatafim;
	
	private String frmdtdescricao;
	
	private Tbdata tbdata = new Tbdata();
	
	private Tbano tbano = new Tbano();
	
	private Tbtipo tbtipo = new Tbtipo();
	
	private List<Tbtipo> listatipos = new TbtipoDaoImpl().listarTipos();
	
	private List<Tbdata> todasasdatas;
	
	private String dtdescricao;
	
	private Integer ano;
	
	private Date datainicio;
	
	private Date datafim;
	
	public CalendarioBean() {
		this.listatipos = new TbtipoDaoImpl().listarTipos();
	}
	
	public Tbano getFrmtbano() {
		return frmtbano;
	}

	public void setFrmtbano(Tbano frmtbano) {
		this.frmtbano = frmtbano;
	}

	public Tbtipo getFrmtbtipo() {
		return frmtbtipo;
	}

	public void setFrmtbtipo(Tbtipo frmtbtipo) {
		this.frmtbtipo = frmtbtipo;
	}

	public Date getFrmdatainicio() {
		return frmdatainicio;
	}

	public void setFrmdatainicio(Date frmdatainicio) {
		this.frmdatainicio = frmdatainicio;
	}

	public Date getFrmdatafim() {
		return frmdatafim;
	}

	public void setFrmdatafim(Date frmdatafim) {
		this.frmdatafim = frmdatafim;
	}

	public String getFrmdtdescricao() {
		return frmdtdescricao;
	}

	public void setFrmdtdescricao(String frmdtdescricao) {
		this.frmdtdescricao = frmdtdescricao;
	}

	public List<Tbdata> getTodasasdatas() {
		return new TbdataDaoImpl().listarDatas();
	}

	public void setTodasasdatas(List<Tbdata> todasasdatas) {
		this.todasasdatas = todasasdatas;
	}

	public List<Tbtipo> getListatipos() {
		return listatipos;
	}

	public void setListatipos(List<Tbtipo> listatipos) {
		this.listatipos = listatipos;
	}

	public String getDtdescricao() {
		return this.tbdata.getDescricao();
	}

	public void setDtdescricao(String dtdescricao) {
		this.dtdescricao = dtdescricao;
	}

	public Tbano getTbano() {
		return this.tbano;
	}

	public void setTbano(Tbano tbano) {
		this.tbano = tbano;
	}

	public Tbtipo getTbtipo() {
		return this.tbtipo;
	}

	public void setTbtipo(Tbtipo tbtipo) {
		this.tbtipo = tbtipo;
	}
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Date getDatainicio() {
		return this.datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Date getDatafim() {
		return this.datafim;
	}

	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}

	public Tbdata getTbdata() {
		return tbdata;
	}

	public void setTbdata(Tbdata tbdata) {
		this.tbdata = tbdata;
	}

	public Integer getIdano() {
		return ano;
	}

	public void setIdano(Integer idano) {
		this.ano = idano;
	}
	
	public List<Tbdata> obterDatas(){
		return new TbdataDaoImpl().listarDatas();
	}
	
	public void alterar(RowEditEvent event) {
		Tbdata tbdata1 = ((Tbdata) event.getObject());
		this.tbdata.setId(tbdata1.getId());
		this.tbdata.setTbano(new TbanoDaoImpl().buscaPorAno(this.tbano.getAno()));
		this.tbdata.setTbtipo(new TbtipoDaoImpl().buscaPorId(this.tbtipo.getId()));
		this.tbdata.setDatainicio(DataUtil.datetoCalendar(datainicio));
		this.tbdata.setDatafim(DataUtil.datetoCalendar(datafim));
		this.tbdata.setDescricao(dtdescricao);
		new TbdataDaoImpl().atualiza(this.tbdata);		
		this.tbdata = new Tbdata();
		
		FacesMessage msg = new FacesMessage("Editado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        

        this.tbano = new Tbano();
        this.tbtipo = new Tbtipo();
        this.dtdescricao = null;
        this.datainicio = null;
        this.datafim = null;
    }
	
	public void iniciaredicao(RowEditEvent event){
		
		setTbdata((Tbdata) event.getObject());
		setDatainicio(this.tbdata.getDatainicio().getTime());
		setDatafim(this.tbdata.getDatafim().getTime());
		setTbano(this.tbdata.getTbano());
		setTbtipo(this.tbdata.getTbtipo());	
	}
     
    public void cancelar(RowEditEvent event) {
    	FacesMessage msg = new FacesMessage("Edição Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void remover() {
    	new TbdataDaoImpl().remove(this.tbdata);
    	FacesMessage msg = new FacesMessage("Removido com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void adicionar(){
    	Tbdata tbdata = new Tbdata();
    	tbdata.setDatainicio(DataUtil.datetoCalendar(this.frmdatainicio));
    	tbdata.setDatafim(DataUtil.datetoCalendar(this.frmdatafim));
    	tbdata.setTbano(new TbanoDaoImpl().buscaPorAno(this.frmtbano.getAno()));    	
    	tbdata.setTbtipo(new TbtipoDaoImpl().buscaPorId(this.frmtbtipo.getId()));
    	tbdata.setDescricao(this.frmdtdescricao);

        new TbdataDaoImpl().inserir(tbdata);

        this.frmtbano = new Tbano();
        this.frmtbtipo = new Tbtipo();
        this.frmdtdescricao = null;
        this.frmdatainicio = null;
        this.frmdatafim = null;
    }
	
}
