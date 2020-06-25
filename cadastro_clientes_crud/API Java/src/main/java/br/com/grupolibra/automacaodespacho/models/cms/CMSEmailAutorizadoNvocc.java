package br.com.grupolibra.automacaodespacho.models.cms;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "CMSEmailAutorizadoNvocc.findAll", query = "SELECT d FROM CMSEmailAutorizadoNvocc d")
@Table(name="SGIPA_EMAILAUTORIZADONVOCC")
public class CMSEmailAutorizadoNvocc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMAILNVOCC_ID_SEQ")
    @SequenceGenerator(sequenceName = "EMAILNVOCC_ID_SEQ", allocationSize = 1, name = "EMAILNVOCC_ID_SEQ")
	@Column(name = "OBJREF")
	private BigDecimal objref;
	
	@Column(name = "OBJREF_CLIENTE")
	private BigDecimal objrefCliente;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "WFK_USUINCL")
	private String wfk_usuincl;
	
	@Column(name = "WFK_DTAINCL")
	private Date wfk_dtaincl;
	
	@Column(name = "WFK_USUALTE")
	private String wfk_usualte;
	
	@Column(name = "WFK_DTAALTE")
	private Date wfk_dtaalte;

	
	public BigDecimal getObjref() {
		return objref;
	}

	public void setObjref(BigDecimal objref) {
		this.objref = objref;
	}

	public BigDecimal getObjrefCliente() {
		return objrefCliente;
	}

	public void setObjrefCliente(BigDecimal objrefCliente) {
		this.objrefCliente = objrefCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	
}
