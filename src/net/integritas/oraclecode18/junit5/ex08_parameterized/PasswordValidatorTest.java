package net.integritas.oraclecode18.junit5.ex08_parameterized;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PasswordValidatorTest {

	PasswordValidator validator = new PasswordValidator();
	
	@Test
	void testHasSpaces_EmptyString() {
		assertFalse(validator.hasSpaces(""));		
	}

	@Test
	void testHasSpaces_1LetterString() {
		assertFalse(validator.hasSpaces("A"));		
	}

	@Test
	void testHasSpaces_3LettersString() {
		assertFalse(validator.hasSpaces("ABC"));		
	}

	@Test
	void testHasSpaces_2LettersStringWithSpaceInTheMiddle() {
		assertTrue(validator.hasSpaces("A C"));		
	}

	@Test
	void testHasSpaces_3LettersStringWithSpaceAtTheEnd() {
		assertTrue(validator.hasSpaces("ABC "));		
	}

	@Test
	void testHasSpaces_StringWith2Spaces() {
		assertTrue(validator.hasSpaces("  "));		
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
