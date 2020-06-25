package br.com.grupolibra.automacaodespacho.controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupolibra.automacaodespacho.models.cms.CMSEmailAutorizadoNvocc;
import br.com.grupolibra.automacaodespacho.repositories.cms.CMSEmailAutorizadoNvoccRepository;

@RestController
public class EmailController {
	
	@Autowired
	private CMSEmailAutorizadoNvoccRepository cmsEmailAutorizadoNvoccRepository;

//	ESTA VARIVEL É CONSTANTE !!! ( OU NAO ??? ) <---
	private static final String wfk_usuincl = "APIDUE";

//  GET ALL (LISTA DE EMAILS POR OBJREF_CLIENTE)
	@CrossOrigin
	@RequestMapping(value = "api/cliente/emails/{objrefCliente}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CMSEmailAutorizadoNvocc> getEmails(@PathVariable BigDecimal objrefCliente) {
		return cmsEmailAutorizadoNvoccRepository.findByObjrefCliente(objrefCliente); 
	} 
	
//  POST
	@CrossOrigin
	@PostMapping(value="api/cliente/email")        
	public Object newEmail(@RequestBody CMSEmailAutorizadoNvocc newEmail) {
		newEmail.setWfk_usuincl(wfk_usuincl);  			//CONSTANTE DECLARADA NO INICIO DO CONTROLLER			
		newEmail.setWfk_dtaincl(new Date(System.currentTimeMillis()));  // SYSTEM DATE
		return cmsEmailAutorizadoNvoccRepository.save(newEmail); 
	}
	
//  DELETE
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
	
//  DELETE ALL (LIST) BY objrefCliente
	@CrossOrigin
	@Transactional
	@DeleteMapping("api/cliente/emails/{objrefCliente}")
	public void deleteAllEmails(@PathVariable BigDecimal objrefCliente) {
		cmsEmailAutorizadoNvoccRepository.deleteByObjrefCliente(objrefCliente);
	}
	
//  UPDATE (PUT)
/*	@CrossOrigin
	@PutMapping(value="api/cliente/email/{objref}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object updateEmail(@RequestBody CMSEmailAutorizadoNvocc newEmail, @PathVariable BigDecimal objref) {
		CMSEmailAutorizadoNvocc updEmail = cmsEmailAutorizadoNvoccRepository.findByObjref(objref);
		updEmail.setNome(newEmail.getNome());
		updEmail.setEmail(newEmail.getEmail());
		updEmail.setWfk_usuincl(wfk_usuincl);  		//CONSTANTE DECLARADA NO INICIO DO CONTROLLER
		updEmail.setWfk_dtaincl(new Date(System.currentTimeMillis()));	// SYSTEM DATE
		updEmail.setWfk_usualte(newEmail.getWfk_usualte());
		updEmail.setWfk_dtaalte(newEmail.getWfk_dtaalte());
		return cmsEmailAutorizadoNvoccRepository.save(updEmail); 
	}	*/	

}
