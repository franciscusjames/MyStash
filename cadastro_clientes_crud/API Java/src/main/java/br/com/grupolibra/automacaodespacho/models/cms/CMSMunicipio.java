package br.com.grupolibra.automacaodespacho.models.cms;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "CMSMunicipio.findAll", query = "SELECT d FROM CMSMunicipio d")
@Table(name="SGIPA_MUNICIPIO")
public class CMSMunicipio {
	
	@Id
	@Column(name = "OBJREF")
	private BigDecimal objref;
	
	@Column(name = "OBJREF_UF")
	private BigDecimal objref_uf;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "WFK_USUINCL")
	private String wfk_usuincl;
	
	@Column(name = "WFK_DTAINCL")
	private Date wfk_dtaincl;
	
	@Column(name = "WFK_USUALTE")
	private String wfk_usualte;
	
	@Column(name = "WFK_DTAALTE")
	private Date wfk_dtaalte;
	
	@Column(name = "DTAHUB")
	private Integer dtahub;
	
	@Column(name = "HRPREVISAOCHEGADA")
	private Integer hrprevisaochegada;

	
	public BigDecimal getObjref() {
		return objref; 
	}

	public void setObjref(BigDecimal objref) {
		this.objref = objref; 
	}

	public BigDecimal getObjref_uf() {
		return objref_uf; 
	}

	public void setObjref_uf(BigDecimal objref_uf) {
		this.objref_uf = objref_uf; 
	}

	public String getNome() {
		return nome; 
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getWfk_usuincl() {
		return wfk_usuincl; 
	}

	public void setWfk_usuincl(String wfk_usuincl) {
		this.wfk_usuincl = wfk_usuincl; 
	}

	public Date getWfk_dtaincl() {
		return wfk_dtaincl; 
	}

	public void setWfk_dtaincl(Date wfk_dtaincl) {
		this.wfk_dtaincl = wfk_dtaincl; 
	}

	public String getWfk_usualte() {
		return wfk_usualte; 
	}

	public void setWfk_usualte(String wfk_usualte) {
		this.wfk_usualte = wfk_usualte; 
	}

	public Date getWfk_dtaalte() {
		return wfk_dtaalte; 
	}

	public void setWfk_dtaalte(Date wfk_dtaalte) {
		this.wfk_dtaalte = wfk_dtaalte; 
	}

	public Integer getDtahub() {
		return dtahub; 
	}

	public void setDtahub(Integer dtahub) {
		this.dtahub = dtahub; 
	}

	public Integer getHrprevisaochegada() {
		return hrprevisaochegada; 
	}

	public void setHrprevisaochegada(Integer hrprevisaochegada) {
		this.hrprevisaochegada = hrprevisaochegada; 
	}
	
}
