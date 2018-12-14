package calculadora.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TESTE-EXEMPLO DE TDD (TEST DRIVEN DEVELOPMENT), AONDE O TESTE � CRIADO ANTES DA FUNCIONALIDADE.
// PRIMEIRO � CRIADA A CLASSE TESTE, QUE IR� VERIFICAR A FUNCIONALIDADE (CALCULADORA).
public class CalculadoraTeste {
	int valorA = 3;
	int valorB = 2;
	
	@Test	//ANNOTATION PARA O jUnit ENTENDER QUE O M�TODO � 'TEST�VEL'
	public void deveriaSomarDoisValoresPassados() throws Exception {  
		// NOME DO METODO DIZ O QUE ELE DEVE FAZER
		int result = Calculadora.soma(valorA, valorB);
	//  assertEquals(expected, actual); -> METODO jUnit, QUE INDICA QUE ESTAMOS QUERENDO AFIRMAR ALGO.
		assertEquals(5, result); // DIZ QUE O RESULTADO ESPERADO De soma � 3 (ESSE � O CARA QUE TESTA!!)
	}   // OBVIAMENTE O TESTE N�O VAI PASSAR. RODAR COM BOT�O DIREITO NA CLASSE -> RUN AS -> jUnit TEST  

	@Test	
	public void deveriaSubtrairDoisValoresPassados() throws Exception {  
		int result = Calculadora.subtrai(valorA, valorB);
		assertEquals(1, result); 
	}  
	
	@Test	
	public void deveriaMultiplicarDoisValoresPassados() throws Exception {  
		int result = Calculadora.multiplica(valorA, valorB);
		assertEquals(6, result); 
	}  
	
	@Test	
	public void deveriaDividirDoisValoresPassados() throws Exception {  
		int result = Calculadora.divide(valorA, valorB);
		assertEquals(1, result); 
	}  
	
	@Test(expected = ArithmeticException.class)	
	public void deveriaLancarExcecaoIndicandoFalhaAoDividirPorZero() throws Exception {  
		int valorB = 0; // <- CONDI��O DO TESTE
		//int result = Calculadora.divide(valorA, valorB); <- N�O UTILIZA O RESULTADO
		//assertEquals(0, result); -> N�O VAI PASSAR POR AQUI, ERRO: 'ArithmeticException'		
		Calculadora.divide(valorA, valorB);
	}  
	
}
