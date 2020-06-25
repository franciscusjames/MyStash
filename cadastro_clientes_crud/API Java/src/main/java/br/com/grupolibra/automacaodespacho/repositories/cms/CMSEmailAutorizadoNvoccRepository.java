package br.com.grupolibra.automacaodespacho.repositories.cms;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.grupolibra.automacaodespacho.models.cms.CMSEmailAutorizadoNvocc;

@Repository
public interface CMSEmailAutorizadoNvoccRepository extends CrudRepository<CMSEmailAutorizadoNvocc, Long> {
	
	public List<CMSEmailAutorizadoNvocc> findByObjrefCliente(BigDecimal objrefCliente);
	public void deleteByObjrefCliente(BigDecimal objrefCliente);
	public CMSEmailAutorizadoNvocc findByObjref(BigDecimal objrefCliente);
	
}