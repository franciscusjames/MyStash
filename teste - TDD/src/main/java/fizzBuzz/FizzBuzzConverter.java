package fizzBuzz;

public class FizzBuzzConverter {
	// RECEBE UM NUMERO ALEATORIO > 0, SE O NUMERO FOR DIVISIVEL POR 3, RETORNA 'FIZZ', SE O NUMERO FOR
	//   DIVISIVEL POR 5 RETORNA 'BUZZ', SE O NUMERO FOR DIVISIVEL POR 5 E POR 3 RETORNA 'FIZZBUZZ'.

	public String convert(int i) {
		if(i % 15 == 0) {	//ESTA CONDIÇÃO ESTÁ EM PRIMEIRO POR SER COMBINAÇÃO DE 3 E 5
			return "FizzBuzz"; }
		
		if(i % 3 == 0) {
			return "Fizz"; }
		
		if(i % 5 == 0) {
			return "Buzz"; }
		
		return String.valueOf(i);
	}
	
}
