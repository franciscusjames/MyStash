package mock.teste;

//CONTROLLER
public class PessoaController {
//	private PessoaDAO pessoaDAO;
	private GeradorDeLog log;
	
	//RECEBE LOG DE FORA (INTERFACE) = INJEÇÃO DE DEPENDENCIA
	public PessoaController(GeradorDeLog log) {
//		pessoaDAO = new PessoaDAO();
		this.log = log;
	}
	
	public void exclui(Pessoa pessoa) {
//		pessoaDAO.exclui(pessoa);
		log.criaLog(pessoa.getNome());
	}
	
}
