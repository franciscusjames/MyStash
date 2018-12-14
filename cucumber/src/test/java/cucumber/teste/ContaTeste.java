package cucumber.teste;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@ContaTeste", 
   glue = "cucumber.teste.passos", monochrome = true, dryRun = false)
public class ContaTeste {	
	
//  ATRAV�S DO CUCUMBER, IR� CHAMAR 'ContaTestePassos.java' PARA PARA EXECUTAR OS TESTES DE ACEITA��O 
//	   DEFINIDOS NO ARQUIVO 'conta.feature'. 
	
//	Observe que na classe ContaTeste.java existe uma anota��o chamada @RunWith(Cucumber.class): 
//	   isso diz ao JUnit que o Cucumber ir� assumir o controle da execu��o dos testes nesta classe. 
//	   Outra anota��o definida na classe � a @CucumberOptions, onde podemos definir par�metros 
//     customiz�veis utilizados pelo Cucumber na execu��o dos testes. Veja a seguir uma descri��o 
//	   sobre cada par�metro desta anota��o:
	
//	Features: � utilizada para ajudar o Cucumber na localiza��o das features (especifica��o execut�veis), 
//	   que no caso est� localizada em uma pasta dentro do projeto chamada �caracteristicas�;

//	Tags: � utilizada para definir as tags neste par�metro, uma vez uma mesma tag definida neste atributo 
//	   e no (s) arquivo (s) .feature. Quando o Cucumber executar, esta classe s� executar� em conjunto 
//	   apenas os arquivos .feature marcados com a mesma tag;

//	Glue: � utilizada para ajudar o Cucumber na localiza��o das classes que cont�m os passos para os 
//	   testes de aceita��o, que no caso est�o localizadas no pacote cucumber.teste.passos;

//	Monochrome: � utilizado para definir a formata��o do resultado dos testes na sa�da da console. 
//	   Se marcado como �true�, o resultado dos testes sai na forma leg�vel, mas se �false�, n�o sai t�o 
//	   leg�vel;

//	DryRun: esta op��o pode ser definida como �true� ou �false�. Se estiver marcado como �true�, isso 
//	   significa que o Cucumber s� verifica se cada etapa definida no arquivo .feature tem c�digo 
//	   correspondente. Considerando ainda �true�, se na execu��o de um arquivo .feature o Cucumber n�o 
//     achar nenhum c�digo (Java) correspondente a esse arquivo, ent�o o Cucumber gera o c�digo 
//	   correspondente. Se marcado como �false�, o Cucumber n�o faz essa verifica��o.

}
