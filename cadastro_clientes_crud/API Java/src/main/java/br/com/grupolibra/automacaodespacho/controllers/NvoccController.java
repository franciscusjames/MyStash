package br.com.grupolibra.automacaodespacho.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupolibra.automacaodespacho.repositories.cms.CMSNvoccRepository;

@RestController
public class NvoccController {

	@Autowired
	private CMSNvoccRepository cmsNvoccRepository;

//  GET NVOCC BY OBJREF
	@CrossOrigin
	@GetMapping(value="api/cliente/nvocc/{objref}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object findNvocc(@PathVariable BigDecimal objref) {
		return cmsNvoccRepository.findByObjref(objref);
	}	

}