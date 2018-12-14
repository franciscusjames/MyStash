package calculadora.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TESTE-EXEMPLO DE TDD (TEST DRIVEN DEVELOPMENT), AONDE O TESTE É CRIADO ANTES DA FUNCIONALIDADE.
// PRIMEIRO É CRIADA A CLASSE TESTE, QUE IRÁ VERIFICAR A FUNCIONALIDADE (CALCULADORA).
public class CalculadoraTeste {
	int valorA = 3;
	int valorB = 2;
	
	@Test	//ANNOTATION PARA O jUnit ENTENDER QUE O MÉTODO É 'TESTÁVEL'
	public void deveriaSomarDoisValoresPassados() throws Exception {  
		// NOME DO METODO DIZ O QUE ELE DEVE FAZER
		int result = Calculadora.soma(valorA, valorB);
	//  assertEquals(expected, actual); -> METODO jUnit, QUE INDICA QUE ESTAMOS QUERENDO AFIRMAR ALGO.
		assertEquals(5, result); // DIZ QUE O RESULTADO ESPERADO De soma É 3 (ESSE É O CARA QUE TESTA!!)
	}   // OBVIAMENTE O TESTE NÃO VAI PASSAR. RODAR COM BOTÃO DIREITO NA CLASSE -> RUN AS -> jUnit TEST  

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
		int valorB = 0; // <- CONDIÇÃO DO TESTE
		//int result = Calculadora.divide(valorA, valorB); <- NÃO UTILIZA O RESULTADO
		//assertEquals(0, result); -> NÃO VAI PASSAR POR AQUI, ERRO: 'ArithmeticException'		
		Calculadora.divide(valorA, valorB);
	}  
	
}
