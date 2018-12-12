package calculadora.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TESTE-EXEMPLO DE TDD (TEST DRIVEN DEVELOPMENT), AONDE O TESTE � CRIADO ANTES DA FUNCIONALIDADE.
// PRIMEIRO � CRIADA A CLASSE TESTE, QUE IR� VERIFICAR A FUNCIONALIDADE (CALCULADORA).
public class CalculadoraTeste {

	@Test	//ANNOTATION PARA O jUnit ENTENDER QUE O M�TODO � 'TEST�VEL'
	public void deveriaSomarDoisValoresPassados() throws Exception {  
		// NOME DO METODO DIZ O QUE ELE DEVE FAZER
		int valorA = 3;
		int valorB = 2;
		//int result = 0;
		
		// CLASSE RESPONS�VEL PELA IMPLEMENTA��O DA FUNCIONALIDADE (CRIAR CLASSE E M�TODO)
		Calculadora calculadora = new Calculadora();
		int result = calculadora.soma(valorA, valorB);
		
	//  assertEquals(expected, actual); -> METODO jUnit, QUE INDICA QUE ESTAMOS QUERENDO AFIRMAR ALGO.
		assertEquals(5, result); // DIZ QUE O RESULTADO ESPERADO De soma � 3 (ESSE � O CARA QUE TESTA!!)
	
	}   // OBVIAMENTE O TESTE N�O VAI PASSAR. RODAR COM BOT�O DIREITO NA CLASSE -> RUN AS -> jUnit TEST  

	@Test	
	public void deveriaSubtrairDoisValoresPassados() throws Exception {  
		int valorA = 3;
		int valorB = 2;
		Calculadora calculadora = new Calculadora();
		int result = calculadora.subtrai(valorA, valorB);
		assertEquals(1, result); 
	}  
	
	@Test	
	public void deveriaMultiplicarDoisValoresPassados() throws Exception {  
		int valorA = 3;
		int valorB = 2;
		Calculadora calculadora = new Calculadora();
		int result = calculadora.multiplica(valorA, valorB);
		assertEquals(6, result); 
	}  
	
	@Test	
	public void deveriaDividirDoisValoresPassados() throws Exception {  
		int valorA = 3;
		int valorB = 2;
		Calculadora calculadora = new Calculadora();
		int result = calculadora.divide(valorA, valorB);
		assertEquals(1, result); 
	}  
	
	@Test(expected = ArithmeticException.class)	
	public void deveriaLancarExcecaoIndicandoFalhaAoDividirPorZero() throws Exception {  
		int valorA = 3;
		int valorB = 0; // <- CONDI��O DO TESTE
		Calculadora calculadora = new Calculadora();
		//int result = calculadora.divide(valorA, valorB); <- N�O UTILIZA O RESULTADO
		calculadora.divide(valorA, valorB);
		//assertEquals(0, result); -> N�O VAI PASSAR POR AQUI, ERRO: 'ArithmeticException'
	}  
	
}
