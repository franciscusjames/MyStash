package fizzBuzz;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {

	FizzBuzzConverter fizzBuzz = new FizzBuzzConverter();
	
	@Test
	public void fizzBuzzConverterPassaNumeroNormal() {
		Assert.assertEquals("1", fizzBuzz.convert(1));
	}

	@Test
	public void fizzBuzzConverterMultiploDeTres() {
		Assert.assertEquals("Fizz", fizzBuzz.convert(3));
	}
	
	@Test
	public void fizzBuzzConverterMultiploDeCinco() {
		Assert.assertEquals("Buzz", fizzBuzz.convert(5));
	}
	
	@Test
	public void fizzBuzzConverterMultiploDeAmbos() {
		Assert.assertEquals("FizzBuzz", fizzBuzz.convert(15));
	}
	
}
