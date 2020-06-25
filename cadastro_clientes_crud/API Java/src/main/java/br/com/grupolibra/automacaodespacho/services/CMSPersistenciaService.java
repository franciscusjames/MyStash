/*
package br.com.grupolibra.automacaodespacho.services;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.grupolibra.automacaodespacho.models.cms.CMSCliente;
import br.com.grupolibra.automacaodespacho.repositories.cms.CMSClienteRepository;
import oracle.jdbc.OracleTypes;

@Service
public class CMSPersistenciaService {
	
	@Value("${cms.datasource.username}")
	private String user;

	@Value("${cms.datasource.password}")
	private String password;

	@Value("${cms.datasource.url}")
	private String url;
	
	@Autowired
	private CMSClienteRepository cmsClienteRepository;
	
	private static final String wfk_usuincl = "APIDUE";
	
	public void insertCMSCliente(BigDecimal objref, String cnpj) {
		CMSCliente sgipa_cliente = new CMSCliente();
		sgipa_cliente.setObjref(objref);
		sgipa_cliente.setNome("Projeto Teste 02");
		sgipa_cliente.setCnpj(cnpj);
		sgipa_cliente.setContato(null);
		sgipa_cliente.setTelefone(null);
		sgipa_cliente.setWfk_usuincl(wfk_usuincl);
		sgipa_cliente.setWfk_dtaincl(new Date(System.currentTimeMillis()));
		sgipa_cliente.setWfk_usualte(null);
		sgipa_cliente.setWfk_dtaalte(null);
		sgipa_cliente.setCodigosom(null);
		sgipa_cliente.setEstado(null);
		sgipa_cliente.setObjref_municipio(null);
		sgipa_cliente.setInscrestadual(null);
		sgipa_cliente.setSituacao(0);
		sgipa_cliente.setCaptacao(null);
		sgipa_cliente.setCep(null);
		sgipa_cliente.setObjref_clientecor(null);
		sgipa_cliente.setReferenciawmscliente(null);
		sgipa_cliente.setReferenciawmsnvocc(null);
		sgipa_cliente.setIntegracaocrm(null);
		sgipa_cliente.setId_sap(null);
		sgipa_cliente.setEmail(null);
		cmsClienteRepository.save(sgipa_cliente);
	}
	
	public BigDecimal getNextObjref(String procedureName, String param) throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);
		CallableStatement stmt = conn.prepareCall("{call " + procedureName + "(?,?)}");
        stmt.setString(1, param);
        stmt.registerOutParameter(2, OracleTypes.INTEGER);
        stmt.execute();
        String output = stmt.getObject(2).toString();
        return new BigDecimal(output);
	}
	
}	*/