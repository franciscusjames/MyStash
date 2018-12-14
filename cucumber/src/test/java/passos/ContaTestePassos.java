package passos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.es.Dado;
import cucumber.api.java.gl.E;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import cucumber.model.Conta;

public class ContaTestePassos {
	
//  Observe que na classe ContaTestePassos estamos utilizadas as anota��es @Dado, @Quando, @E e @Entao, 
//	   que correspondem ao mesmo conte�do e as palavras-chave do Gherkin definidas nos arquivos .feature. 
//	   Outro ponto a destacar � que em todos os m�todos da classe ContaTestePassos definimos algumas 
//	   express�es regulares, como (\\d+) (extrai valor decimal), \"(.*?)\" (extrai qualquer valor string). 
//	   Isso diz ao Cucumber para extrair os valores definidos no arquivo .feature a qual a classe corresponde,
//	   e em tempo de execu��o injetar esses valores nos par�metros de cada m�todo correspondente.

//	Por fim, note que dentro de cada anota��o existe no in�cio uma express�o regular �^� e no final �$�: as 
//	   duas express�es estabelecem o in�cio e fim da leitura do Cucumber em cada linha da especifica��o.
	
    private Conta conta;

    @Dado("^a conta criada para o dono \"(.*?)\" de numero (\\d+) com o limite (\\d+) e saldo (\\d+)$")
    public void a_conta_criada_para_o_dono_de_numero_com_o_limite_e_saldo(String dono, int numero, Double limite,
                 Double saldo) throws Throwable {
          // Defini��o de conta
          conta = new Conta(dono, numero, limite, saldo);
    }

    @Quando("^o dono realiza o deposito no valor de (\\d+) na conta$")
    public void o_dono_realiza_o_deposito_no_valor_de_na_conta(Double valorDeposito) throws Throwable {
          assertTrue("O dono " + conta.getDono() + " n�o tem limite dispon�vel na conta para este valor de deposito",
                        conta.depositar(valorDeposito));
    }

    @E("^o dono realiza o primeiro saque no valor de (\\d+) na conta$")
    public void o_dono_realiza_o_primeiro_saque_no_valor_de_na_conta(Double valorSaque) throws Throwable {
          assertTrue("O dono " + conta.getDono() + " n�o tem saldo dispon�vel na conta para este valor de saque",
                        conta.sacar(valorSaque));
    }

    @E("^o dono realiza o segundo saque no valor de (\\d+) na conta$")
    public void o_dono_realiza_o_segundo_saque_no_valor_de_na_conta(Double valorSaque) throws Throwable {
          assertTrue("O dono " + conta.getDono() + " n�o tem saldo dispon�vel na conta para este valor de saque",
                        conta.sacar(valorSaque));
    }

    @Entao("^o dono tem o saldo no valor de (\\d+) na conta$")
    public void o_dono_tem_o_saldo_na_conta_no_valor_de(Double saldoEsperado) throws Throwable {
          assertEquals("O dono " + conta.getDono() + " est� com o saldo incorreto na conta", saldoEsperado,
                        conta.getSaldo());
    }
    
}