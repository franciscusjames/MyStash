package br.com.grupolibra.automacaodespacho.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupolibra.automacaodespacho.models.cms.CMSCliente;
import br.com.grupolibra.automacaodespacho.repositories.cms.CMSClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private CMSClienteRepository cmsClienteRepository;
	
//	ESTA VARIVEL É CONSTANTE !!! ( OU NAO ??? ) <---
	private static final String wfk_usuincl = "APIDUE";
	
//  GET - OBJREF
	@CrossOrigin
	@GetMapping(value="api/cliente/objref/{objref}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	CMSCliente findByObjref(@PathVariable BigDecimal objref) {
		return cmsClienteRepository.findByObjref(objref); 
	}

//  GET - CNPJ
	@CrossOrigin
	@GetMapping(value="api/cliente/cnpj/{cnpj}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	CMSCliente findByCnpj(@PathVariable String cnpj) {
		return cmsClienteRepository.findByCnpj(cnpj); 
	} 
	
//  GET ALL - LISTA DE CLIENTES
	@CrossOrigin
	@RequestMapping(value = "api/clientes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ArrayList<CMSCliente> getClientes() {
		return cmsClienteRepository.findAll(); 
	} 
	
//  POST
	@CrossOrigin
	@PostMapping(value="api/cliente")        
	public Object newCliente(@RequestBody CMSCliente newCliente) {
	//	VERFICA SE JÁ EXISTE OBJREF	
		BigDecimal obj = newCliente.getObjref();
		CMSCliente aux = cmsClienteRepository.findByObjref(obj);
		if(aux!=null && obj.equals(aux.getObjref())) {
			return "ObjRef já existe!"; 
		}	
	//	VERFICA SE CNPJ JÁ ESTÁ CADASTRADO		
		String cnpj = newCliente.getCnpj();
		CMSCliente aux2 = cmsClienteRepository.findByCnpj(cnpj);
		if(aux2!=null && cnpj.equals(aux2.getCnpj())) {
			return "CNPJ já cadastrado!"; 
		}
	//	GRAVA REGISTRO CASO NAO EXISTA OBJREF NEM CNPJ NA TABELA
		newCliente.setWfk_usuincl(wfk_usuincl);  				//CONSTANTE DECLARADA NO INICIO DO CONTROLLER			
		newCliente.setWfk_dtaincl(new Date(System.currentTimeMillis()));  // SYSTEM DATE
		return cmsClienteRepository.save(newCliente); 
	}
	
//  DELETE
	@CrossOrigin
	@DeleteMapping("api/cliente/{objref}")
	public Object deleteCliente(@PathVariable BigDecimal objref) {
		CMSCliente cliente = cmsClienteRepository.findByObjref(objref);
		try {
			cmsClienteRepository.delete(cliente); 
			return cliente; 
		}
		catch(Exception z) {
			return "Erro ao deletar registro ObjRef: " + objref; 
		}
	}
			
//  UPDATE (PUT)
	@CrossOrigin
	@PutMapping(value="api/cliente/{objref}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object updateCliente(@RequestBody CMSCliente newCliente, @PathVariable BigDecimal objref) {
		CMSCliente sgipa_cliente = cmsClienteRepository.findByObjref(objref);
	//	sgipa_cliente.setObjref(newCliente.getObjref());	//MESMO OBJREF - NAO MUDA
		sgipa_cliente.setNome(newCliente.getNome());
	//	sgipa_cliente.setCnpj(newCliente.getCnpj());		//MESMO CNPJ - NAO MUDA
		sgipa_cliente.setContato(newCliente.getContato());
		sgipa_cliente.setTelefone(newCliente.getTelefone());
		sgipa_cliente.setWfk_usuincl(wfk_usuincl);  		//CONSTANTE DECLARADA NO INICIO DO CONTROLLER
		sgipa_cliente.setWfk_dtaincl(new Date(System.currentTimeMillis()));	// SYSTEM DATE
		sgipa_cliente.setWfk_usualte(newCliente.getWfk_usualte());
		sgipa_cliente.setWfk_dtaalte(newCliente.getWfk_dtaalte());
		sgipa_cliente.setCodigosom(newCliente.getCodigosom());
		sgipa_cliente.setEstado(newCliente.getEstado());
		sgipa_cliente.setObjref_municipio(newCliente.getObjref_municipio());
		sgipa_cliente.setInscrestadual(newCliente.getInscrestadual());
		sgipa_cliente.setSituacao(newCliente.getSituacao());
		sgipa_cliente.setCaptacao(newCliente.getCaptacao());
		sgipa_cliente.setCep(newCliente.getCep());
		sgipa_cliente.setObjref_clientecor(newCliente.getObjref_clientecor());
		sgipa_cliente.setReferenciawmscliente(newCliente.getReferenciawmscliente());
		sgipa_cliente.setReferenciawmsnvocc(newCliente.getReferenciawmsnvocc());
		sgipa_cliente.setIntegracaocrm(newCliente.getIntegracaocrm());
		sgipa_cliente.setId_sap(newCliente.getId_sap());
		sgipa_cliente.setEmail(newCliente.getEmail());
		return cmsClienteRepository.save(sgipa_cliente); 
	}

}
