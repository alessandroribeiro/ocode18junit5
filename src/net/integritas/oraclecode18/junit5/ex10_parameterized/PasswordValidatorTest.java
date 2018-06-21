package net.integritas.oraclecode18.junit5.ex10_parameterized;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PasswordValidatorTest {

	PasswordValidator validator = new PasswordValidator();

	@DisplayName("hasSpaces")
	@ParameterizedTest(name="\"{0}\": {1}")
	@CsvSource({"'',FALSE","ABC,FALSE","A,FALSE","A B,TRUE","'ABC ',TRUE","ABCD,FALSE"})
	void testHasSpaces(String param, boolean result) {
		assertEquals(result,validator.hasSpaces(param));		
	}

	
}
