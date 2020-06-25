package br.com.grupolibra.automacaodespacho.repositories.cms;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.grupolibra.automacaodespacho.models.cms.CMSMunicipio;

@Repository
public interface CMSMunicipioRepository extends CrudRepository<CMSMunicipio, Long> {
	
//	@Query("SELECT d FROM CMSMunicipio d where rownum <11")
//	public ArrayList<CMSMunicipio> findAll();
	
//	public List<CMSMunicipio> findByCnpj(String cnpj);
	public CMSMunicipio findByObjref(BigDecimal objref);
//	public CMSMunicipio findByCnpj(String cnpj);
	
}
