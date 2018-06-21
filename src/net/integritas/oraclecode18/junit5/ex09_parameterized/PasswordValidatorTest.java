package net.integritas.oraclecode18.junit5.ex09_parameterized;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PasswordValidatorTest {

	PasswordValidator validator = new PasswordValidator();
	
	@ParameterizedTest(name="\"{0}\" doesnt have spaces")
	@ValueSource(strings= {"","A","ABC"})
	void testHasSpaces_FALSE(String param) {
		assertFalse(validator.hasSpaces(param));		
	}

	@ParameterizedTest(name="\"{0}\" has spaces")
	@ValueSource(strings= {"A C","ABC ","  "})
	void testHasSpaces_TRUE(String param) {
		assertTrue(validator.hasSpaces(param));		
	}


	/*
	@DisplayName("hasSpaces")
	@ParameterizedTest(name="input \"{0}\" , returns {1}")
	@CsvSource({",FALSE"," ,TRUE","ABC,FALSE","A,FALSE","A B,TRUE","ABC ,TRUE","ABCD,FALSE"})
	void testHasSpaces(String input, Boolean expectedResult) {
		assertEquals(expectedResult,validator.validate(input));
	}
*/
	
}
