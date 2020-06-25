package br.com.grupolibra.automacaodespacho.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupolibra.automacaodespacho.repositories.cms.CMSMunicipioRepository;

@RestController
public class MunicipioController {
	
	@Autowired
	private CMSMunicipioRepository cmsMunicipioRepository;

//  GET MUNICIPIO BY OBJREF
	@CrossOrigin
	@GetMapping(value="api/cliente/municipio/{objref}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object findMunicipio(@PathVariable BigDecimal objref) {
		return cmsMunicipioRepository.findByObjref(objref);
	}
	
}