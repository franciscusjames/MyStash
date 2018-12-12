package mock.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//UM MOCK � BASICAMENTE UM OBJETO FALSO, CAPAZ DE SIMULAR AS DEPENDENCIAS DE UM OJBETO,
//  E � CAPAZ DE SIMULAR DETERMINADAS A��ES DESSE OBJETO.

//PQ � USADO? -> PARA TESTAR O COMPORTAMENTO DE OUTROS OBJETOS DESEJADOS, E TER CERTEZA 
//  DE QUE TUDO OCORREU CONFORME O PENSADO.
public class PessoaTeste {
	//SITUA��O: UMA APLICA�AO ONDE, CADA VEZ QUE EXCLU�MOS UMA PESSOA, UM LOG � GERADO NO 
	//  BANCO DE DADOS COM O NOME DA PESSOA QUE FOI EXCLUIDA. COMO TER CERTEZA QUE A 
	//  GERA��O DO LOG REALMENTE VAI SER CHAMADA E QUE NADA DE RUIM ACONTECER� NO CAMINHO? 
	//  PODE-SE FAZER UM TESTE 'MOCK' DA CLASSE DE LOG.
	@Test
	public void deveriaCriarUmLogQuandoUmaPessoaForExclu�da() throws Exception {
		Pessoa pessoa = new Pessoa(null);
		pessoa.setNome("Alexandre");
		
		LogMock nossoLogMock = new LogMock();
		
		//RECEBE GERADOR DE LOG DE FORA = INJE��O DE DEPENDENCIA (VIA CONSTRUTOR)
		PessoaController pessoaController = new PessoaController(nossoLogMock);
		pessoaController.exclui(pessoa);
		//COMO SABEREMOS SE O 'CRIARLOG' SER� CHAMADO?
		
		//			    ESPERADO		  VERIFICADO			
		assertEquals(pessoa.getNome(), nossoLogMock.getNome());	
	//  VERIFICA SE O M�TODO DE GERA��O DE LOG FOI REALMENTE INVOCADO,
	//  E SE O NOME NO LOG � O MESMO NOME DA PESSOA.	
	}
	
}
