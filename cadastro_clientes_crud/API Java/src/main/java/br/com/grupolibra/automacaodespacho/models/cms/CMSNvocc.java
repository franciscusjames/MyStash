package br.com.grupolibra.automacaodespacho.models.cms;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "CMSNvocc.findAll", query = "SELECT d FROM CMSNvocc d")
@Table(name="SGIPA_NVOCC")
public class CMSNvocc {
	
	@Id
	@Column(name = "OBJREF")
	private BigDecimal objref;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "SIGLANIC")
	private String siglanic;
	
	@Column(name = "WFK_USUINCL")
	private String wfk_usuincl;
	
	@Column(name = "WFK_DTAINCL")
	private Date wfk_dtaincl;
	
	@Column(name = "WFK_USUALTE")
	private String wfk_usualte;
	
	@Column(name = "WFK_DTAALTE")
	private Date wfk_dtaalte;
	
	@Column(name = "BLOQUEIOHBLLCL")
	private Integer bloqueiohbllcl;
	
	@Column(name = "BLOQUEIOHBLFCL")
	private Integer bloqueiohblfcl;

	
	public BigDecimal getObjref() {
		return objref;
	}

	public void setObjref(BigDecimal objref) {
		this.objref = objref;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSiglanic() {
		return siglanic;
	}

	public void setSiglanic(String siglanic) {
		this.siglanic = siglanic;
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

	public Integer getBloqueiohbllcl() {
		return bloqueiohbllcl;
	}

	public void setBloqueiohbllcl(Integer bloqueiohbllcl) {
		this.bloqueiohbllcl = bloqueiohbllcl;
	}

	public Integer getBloqueiohblfcl() {
		return bloqueiohblfcl;
	}

	public void setBloqueiohblfcl(Integer bloqueiohblfcl) {
		this.bloqueiohblfcl = bloqueiohblfcl;
	}
	
}