package br.com.grupolibra.automacaodespacho.models.cms;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "CMSCliente.findAll", query = "SELECT d FROM CMSCliente d")
@Table(name="SGIPA_CLIENTE_DUCA")
public class CMSCliente {
	
	@Id
	@Column(name = "OBJREF")
	private BigDecimal objref;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CNPJ")
	private String cnpj;
	
	@Column(name = "CONTATO")
	private String contato;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "WFK_USUINCL")
	private String wfk_usuincl;
	
	@Column(name = "WFK_DTAINCL")
	private Date wfk_dtaincl;
	
	@Column(name = "WFK_USUALTE")
	private String wfk_usualte;
	
	@Column(name = "WFK_DTAALTE")
	private Date wfk_dtaalte;
	
	@Column(name = "CODIGOSOM")
	private String codigosom;
	
	@Column(name = "ESTADO")
	private Integer estado;
	
	@Column(name = "OBJREF_MUNICIPIO")
	private BigDecimal objref_municipio;
	
	@Column(name = "INSCRESTADUAL")
	private String inscrestadual;
	
	@Column(name = "SITUACAO")
	private Integer situacao;
	
	@Column(name = "CAPTACAO")
	private Integer captacao;
	
	@Column(name = "CEP")
	private String cep;
	
	@Column(name = "OBJREF_CLIENTECOR")
	private BigDecimal objref_clientecor;
	
	@Column(name = "REFERENCIAWMSCLIENTE")
	private Integer referenciawmscliente;
	
	@Column(name = "REFERENCIAWMSNVOCC")
	private Integer referenciawmsnvocc;
	
	@Column(name = "INTEGRACAOCRM")
	private Integer integracaocrm;
	
	@Column(name = "ID_SAP")
	private String id_sap;
	
	@Column(name = "EMAIL")
	private String email;

	
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public String getCodigosom() {
		return codigosom;
	}

	public void setCodigosom(String codigosom) {
		this.codigosom = codigosom;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public BigDecimal getObjref_municipio() {
		return objref_municipio;
	}

	public void setObjref_municipio(BigDecimal objref_municipio) {
		this.objref_municipio = objref_municipio;
	}

	public String getInscrestadual() {
		return inscrestadual;
	}

	public void setInscrestadual(String inscrestadual) {
		this.inscrestadual = inscrestadual;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Integer getCaptacao() {
		return captacao;
	}

	public void setCaptacao(Integer captacao) {
		this.captacao = captacao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public BigDecimal getObjref_clientecor() {
		return objref_clientecor;
	}

	public void setObjref_clientecor(BigDecimal objref_clientecor) {
		this.objref_clientecor = objref_clientecor;
	}

	public Integer getReferenciawmscliente() {
		return referenciawmscliente;
	}

	public void setReferenciawmscliente(Integer referenciawmscliente) {
		this.referenciawmscliente = referenciawmscliente;
	}

	public Integer getReferenciawmsnvocc() {
		return referenciawmsnvocc;
	}

	public void setReferenciawmsnvocc(Integer referenciawmsnvocc) {
		this.referenciawmsnvocc = referenciawmsnvocc;
	}

	public Integer getIntegracaocrm() {
		return integracaocrm;
	}

	public void setIntegracaocrm(Integer integracaocrm) {
		this.integracaocrm = integracaocrm;
	}

	public String getId_sap() {
		return id_sap;
	}

	public void setId_sap(String id_sap) {
		this.id_sap = id_sap;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}