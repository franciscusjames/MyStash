package mock.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//UM MOCK É BASICAMENTE UM OBJETO FALSO, CAPAZ DE SIMULAR AS DEPENDENCIAS DE UM OJBETO,
//  E É CAPAZ DE SIMULAR DETERMINADAS AÇÕES DESSE OBJETO.

//PQ É USADO? -> PARA TESTAR O COMPORTAMENTO DE OUTROS OBJETOS DESEJADOS, E TER CERTEZA 
//  DE QUE TUDO OCORREU CONFORME O PENSADO.
public class PessoaTeste {
	//SITUAÇÃO: UMA APLICAÇAO ONDE, CADA VEZ QUE EXCLUÍMOS UMA PESSOA, UM LOG É GERADO NO 
	//  BANCO DE DADOS COM O NOME DA PESSOA QUE FOI EXCLUIDA. COMO TER CERTEZA QUE A 
	//  GERAÇÃO DO LOG REALMENTE VAI SER CHAMADA E QUE NADA DE RUIM ACONTECERÁ NO CAMINHO? 
	//  PODE-SE FAZER UM TESTE 'MOCK' DA CLASSE DE LOG.
	@Test
	public void deveriaCriarUmLogQuandoUmaPessoaForExcluída() throws Exception {
		Pessoa pessoa = new Pessoa(null);
		pessoa.setNome("Alexandre");
		
		LogMock nossoLogMock = new LogMock();
		
		//RECEBE GERADOR DE LOG DE FORA = INJEÇÃO DE DEPENDENCIA (VIA CONSTRUTOR)
		PessoaController pessoaController = new PessoaController(nossoLogMock);
		pessoaController.exclui(pessoa);
		//COMO SABEREMOS SE O 'CRIARLOG' SERÁ CHAMADO?
		
		//			    ESPERADO		  VERIFICADO			
		assertEquals(pessoa.getNome(), nossoLogMock.getNome());	
	//  VERIFICA SE O MÉTODO DE GERAÇÃO DE LOG FOI REALMENTE INVOCADO,
	//  E SE O NOME NO LOG É O MESMO NOME DA PESSOA.	
	}
	
}
