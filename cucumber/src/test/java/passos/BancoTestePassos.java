package passos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.model.Banco;
import cucumber.model.Conta;

public class BancoTestePassos {
	  
//	SER� CHAMADA PELO CUCUMBER (MEDIANTE CHAMADA DA CLASSE 'BancoTeste') PARA EXECUTAR OS PASSOS
//	   (TESTES DE ACEITA��O) DEFINIDOS NO ARQUIVO 'banco.feature'.
	
    private Banco banco;
    private int totalContas;
    private Double totalDinheiro;

    @Dado("^que as contas sao do \"(.*?)\"$")
    public void que_as_contas_sao_do(String nome, List<Conta> listaDeContas) throws Throwable {
          // Defini��o do banco e associando as contas
          banco = new Banco(nome, listaDeContas);
    }

    @Dado("^o calculo do total de contas criadas$")
    public void o_calculo_do_total_de_contas_criadas() throws Throwable {
          totalContas = banco.getListaDeContas().size();
    }

    @Entao("^o total de contas e (\\d+)$")
    public void o_total_de_contas_e(int totalContasEsperado) throws Throwable {
          assertEquals("O c�lculo do total de contas est� incorreto", 
          totalContasEsperado, totalContas);
    }

    @Dado("^o calculo do total de dinheiro$")
    public void o_calculo_do_total_de_dinheiro() throws Throwable {
          totalDinheiro = banco.getListaDeContas().stream().mapToDouble
          (c -> c.getSaldo()).sum();
    }

    @Entao("^o total de dinheiro no banco e (\\d+)$")
    public void o_total_de_dinheiro_no_banco_e(Double totalDinheiroEsperado) throws Throwable {
          assertEquals("O c�lculo do total de dinheiro no banco " + banco.getNome() 
           + " est� incorreto",
           totalDinheiroEsperado, totalDinheiro);
    }
    
}