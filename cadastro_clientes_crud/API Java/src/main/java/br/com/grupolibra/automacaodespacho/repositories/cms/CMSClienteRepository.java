package br.com.grupolibra.automacaodespacho.repositories.cms;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.grupolibra.automacaodespacho.models.cms.CMSCliente;

@Repository
public interface CMSClienteRepository extends CrudRepository<CMSCliente, Long> {
	
	@Query("SELECT d FROM CMSCliente d where rownum <11")
	public ArrayList<CMSCliente> findAll();
	
//	public List<CMSCliente> findByCnpj(String cnpj);
	public CMSCliente findByObjref(BigDecimal objref);
	public CMSCliente findByCnpj(String cnpj);
	
}