package br.com.grupolibra.automacaodespacho.repositories.cms;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.grupolibra.automacaodespacho.models.cms.CMSNvocc;

@Repository
public interface CMSNvoccRepository extends CrudRepository<CMSNvocc, Long> {
	
//	@Query("SELECT d FROM CMSNvocc d where rownum <11")
//	public ArrayList<CMSNvocc> findAll();
	
//	public List<CMSNvocc> findByCnpj(String cnpj);
	public CMSNvocc findByObjref(BigDecimal objref);
//	public CMSNvocc findByCnpj(String cnpj);
	
}
