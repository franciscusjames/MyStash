package fizzBuzz;

public class TesteMain {

	public static void main(String[] args) {
		
		FizzBuzzConverter fizzBuzz = new FizzBuzzConverter();
		
		String result = fizzBuzz.convert(7);
		System.out.println(result);
		
		result = fizzBuzz.convert(12);
		System.out.println(result);
		
		result = fizzBuzz.convert(9);
		System.out.println(result);
		
		result = fizzBuzz.convert(35);
		System.out.println(result);
		
		result = fizzBuzz.convert(90);
		System.out.println(result);

	}

}
