package mock.teste;

//O MOCK DEVE SIMULAR O FUNCIONAMENTO DA FUNCIONALIDADE, OU SEJA, ELE N�O CONTER� C�DIGO
//  ALGUM, SER� APENAS PARA VERIFICARMOS SE ELE FOI CHAMADO. UMA IDEIA SERIA CRIAR UMA CLASSE
//  QUE EXTENDE A CLASSE DE LOG, MAS VAMOS CRIAR UMA INTERFACE PARA IMPLEMENTARMOS.
public interface GeradorDeLog {
	
	public void criaLog(String nomeDaPessoa);
	
}
