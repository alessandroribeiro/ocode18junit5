package net.integritas.oraclecode18.junit5.exxx_repeated;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PasswordValidatorTest {

	PasswordValidator validator = new PasswordValidator();

	@DisplayName("hasSpaces")
	@ParameterizedTest(name="\"{0}\": {1}")
	@CsvSource({",FALSE","ABC,FALSE","A,FALSE","A B,TRUE","ABCD,FALSE"})
	void testHasSpaces(String param, boolean result) {
		assertEquals(result,validator.hasSpaces(param));		
	}


    @RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void customDisplayName(TestInfo testInfo) {
        assertEquals(testInfo.getDisplayName(), "Repeat! 1/3");
    }

    @RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    void customDisplayNameWithLongPattern(TestInfo testInfo) {
    	//testInfo.
        assertEquals(testInfo.getDisplayName(), "Details... :: repetition 1 of 5");
    }
	
	
}
