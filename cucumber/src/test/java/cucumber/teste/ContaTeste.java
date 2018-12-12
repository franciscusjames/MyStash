package cucumber.teste;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@ContaTeste", 
   glue = "cucumber.teste.passos", monochrome = true, dryRun = false)
public class ContaTeste {	
	
//  ATRAVÉS DO CUCUMBER, IRÁ CHAMAR 'ContaTestePassos.java' PARA PARA EXECUTAR OS TESTES DE ACEITAÇÃO 
//	   DEFINIDOS NO ARQUIVO 'conta.feature'. 
	
//	Observe que na classe ContaTeste.java existe uma anotação chamada @RunWith(Cucumber.class): 
//	   isso diz ao JUnit que o Cucumber irá assumir o controle da execução dos testes nesta classe. 
//	   Outra anotação definida na classe é a @CucumberOptions, onde podemos definir parâmetros 
//     customizáveis utilizados pelo Cucumber na execução dos testes. Veja a seguir uma descrição 
//	   sobre cada parâmetro desta anotação:
	
//	Features: É utilizada para ajudar o Cucumber na localização das features (especificação executáveis), 
//	   que no caso está localizada em uma pasta dentro do projeto chamada “caracteristicas”;

//	Tags: É utilizada para definir as tags neste parâmetro, uma vez uma mesma tag definida neste atributo 
//	   e no (s) arquivo (s) .feature. Quando o Cucumber executar, esta classe só executará em conjunto 
//	   apenas os arquivos .feature marcados com a mesma tag;

//	Glue: É utilizada para ajudar o Cucumber na localização das classes que contém os passos para os 
//	   testes de aceitação, que no caso estão localizadas no pacote cucumber.teste.passos;

//	Monochrome: É utilizado para definir a formatação do resultado dos testes na saída da console. 
//	   Se marcado como ”true”, o resultado dos testes sai na forma legível, mas se “false”, não sai tão 
//	   legível;

//	DryRun: esta opção pode ser definida como “true” ou “false“. Se estiver marcado como “true”, isso 
//	   significa que o Cucumber só verifica se cada etapa definida no arquivo .feature tem código 
//	   correspondente. Considerando ainda “true”, se na execução de um arquivo .feature o Cucumber não 
//     achar nenhum código (Java) correspondente a esse arquivo, então o Cucumber gera o código 
//	   correspondente. Se marcado como “false”, o Cucumber não faz essa verificação.

}
