/*
package br.com.grupolibra.automacaodespacho.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
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
import br.com.grupolibra.automacaodespacho.models.cms.CMSEmailAutorizadoNvocc;
import br.com.grupolibra.automacaodespacho.repositories.cms.CMSClienteRepository;
import br.com.grupolibra.automacaodespacho.repositories.cms.CMSEmailAutorizadoNvoccRepository;
import br.com.grupolibra.automacaodespacho.repositories.cms.CMSMunicipioRepository;
import br.com.grupolibra.automacaodespacho.repositories.cms.CMSNvoccRepository;

@RestController
public class PadraoController {
	
	@Autowired
	private CMSClienteRepository cmsClienteRepository;
	
	@Autowired
	private CMSMunicipioRepository cmsMunicipioRepository;
	
	@Autowired
	private CMSNvoccRepository cmsNvoccRepository;
	
	@Autowired
	private CMSEmailAutorizadoNvoccRepository cmsEmailAutorizadoNvoccRepository;
	
//	@Autowired
//	private CMSPersistenciaService cmsPersistenciaService;
	
//	ESTA VARIVEL É CONSTANTE !!! ( OU NAO ??? ) <---
	private static final String wfk_usuincl = "APIDUE";
	
	
////MUNICIPIO - GET BY OBJREF
	@CrossOrigin
	@GetMapping(value="api/cliente/municipio/{objref}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object findMunicipio(@PathVariable BigDecimal objref) {
		return cmsMunicipioRepository.findByObjref(objref);
	}
	
////NVOCC - GET BY OBJREF
	@CrossOrigin
	@GetMapping(value="api/cliente/nvocc/{objref}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object findNvocc(@PathVariable BigDecimal objref) {
		return cmsNvoccRepository.findByObjref(objref);
	}	
	
////EMAIL - GET ALL (LISTA DE EMAILS POR OBJREF_CLIENTE)
	@CrossOrigin
	@RequestMapping(value = "api/cliente/emails/{objrefCliente}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CMSEmailAutorizadoNvocc> getEmails(@PathVariable BigDecimal objrefCliente) {
		return cmsEmailAutorizadoNvoccRepository.findByObjrefCliente(objrefCliente); 
	} 
	
////EMAIL - POST
	@CrossOrigin
	@PostMapping(value="api/cliente/email")        
	public Object newEmail(@RequestBody CMSEmailAutorizadoNvocc newEmail) {
		newEmail.setWfk_usuincl(wfk_usuincl);  			//CONSTANTE DECLARADA NO INICIO DO CONTROLLER			
		newEmail.setWfk_dtaincl(new Date(System.currentTimeMillis()));  // SYSTEM DATE
		return cmsEmailAutorizadoNvoccRepository.save(newEmail); 
	}
	
////EMAIL - DELETE
	@CrossOrigin
	@DeleteMapping("api/cliente/email/{objref}")
	public Object deleteEmail(@PathVariable BigDecimal objref) {
		CMSEmailAutorizadoNvocc email = cmsEmailAutorizadoNvoccRepository.findByObjref(objref);
		try {
			cmsEmailAutorizadoNvoccRepository.delete(email); 
			return email; 
		}
		catch(Exception z) {
			return "Erro ao deletar email ObjRef: " + objref; 
		}
	}
	
////EMAIL - DELETE ALL (LIST) BY objrefCliente
	@CrossOrigin
	@Transactional
	@DeleteMapping("api/cliente/emails/{objrefCliente}")
	public void deleteAllEmails(@PathVariable BigDecimal objrefCliente) {
		cmsEmailAutorizadoNvoccRepository.deleteByObjrefCliente(objrefCliente);
	}
	
////EMAIL - UPDATE (PUT)
//	@CrossOrigin
//	@PutMapping(value="api/cliente/email/{objref}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public Object updateEmail(@RequestBody CMSEmailAutorizadoNvocc newEmail, @PathVariable BigDecimal objref) {
//		CMSEmailAutorizadoNvocc updEmail = cmsEmailAutorizadoNvoccRepository.findByObjref(objref);
//		updEmail.setNome(newEmail.getNome());
//		updEmail.setEmail(newEmail.getEmail());
//		updEmail.setWfk_usuincl(wfk_usuincl);  		//CONSTANTE DECLARADA NO INICIO DO CONTROLLER
//		updEmail.setWfk_dtaincl(new Date(System.currentTimeMillis()));	// SYSTEM DATE
//		updEmail.setWfk_usualte(newEmail.getWfk_usualte());
//		updEmail.setWfk_dtaalte(newEmail.getWfk_dtaalte());
//		return cmsEmailAutorizadoNvoccRepository.save(updEmail); 
//	}	
	
////////////////CLIENTE 	
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
	//	return "Erro ao atualizar ObjRef: " + objref; 
	}

}


/*
    @CrossOrigin
	@RequestMapping(value = "api/clientes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CMSCliente> getClientes() {
		List<CMSCliente> lista = cmsClienteRepository.findByCnpj("60561719000719");
		return lista; 	} 
	
	@CrossOrigin
	@RequestMapping(value = "api/cliente", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String setClientes() throws SQLException {
		BigDecimal objref = cmsPersistenciaService.getNextObjref("SP_WSD_WOJ_REG_OBJREFDISP", "t35::sgipa::parametrizacao::cliente::cliente");
		cmsPersistenciaService.insertCMSCliente(objref, "123456789");
		return "Inseriu"; 	}   

} */
