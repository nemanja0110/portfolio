package validatecreditcard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

/**
 * valid sequences for the parameterized test are provided by the following website:
 * <a href="https://www.freeformatter.com/credit-card-number-generator-validator.html">Credit Card Number Generator - Validator</a>
 */

class LuhnAlgorithmTest {

    LuhnAlgorithm luhnAlgorithm = new LuhnAlgorithm();

    @ParameterizedTest
    @DisplayName("Valid Numeric Sequences Return True")
    @MethodSource("numeric_sequences")
    void givenValidNumericSequence_whenVerifyValidity_thenReturnTrue(String sequence) {
        Assertions.assertTrue(luhnAlgorithm.verifyValidity(sequence));
    }

    private static Stream<Arguments> numeric_sequences() {
        return Stream.of(
                Arguments.of("4556258205802873"),   //  VISA
                Arguments.of("5455072116610328"),   //  MasterCard
                Arguments.of("374351947061805"),    //  American Express
                Arguments.of("6011739418660954"),   //  Discover
                Arguments.of("36256736720356"),     //  Diners Club
                Arguments.of("6759337018137832")    //  Maestro
        );
    }

    @Test
    @DisplayName("Given Random Sequence When NotVerifyValidity Returns False")
    void givenInvalidNumericSequence_whenVerifyValidity_thenReturnFalse() {

        int failingRandomNumber = new Random().nextInt(Integer.MAX_VALUE);
        failingRandomNumber += (!luhnAlgorithm.verifyValidity(String.valueOf(failingRandomNumber))) ? 0 : 1;

        System.out.println(failingRandomNumber);

        String randomSequence = String.valueOf(failingRandomNumber);

        Assertions.assertFalse(luhnAlgorithm.verifyValidity(randomSequence));
    }

    @Test
    @DisplayName("Empty Sequence Throws NumberFormatException")
    void givenEmptySequence_whenVerifyValidity_thenThrowNumberFormatException() {

        String emptySequence = "";

        Exception exception = Assertions.assertThrows(NumberFormatException.class,
                () -> luhnAlgorithm.verifyValidity(emptySequence)
        );

        String expected = NumberFormatException.class.getTypeName();
        String actual = exception.getClass().getTypeName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String Argument w/ Length Smaller Than 2 throws NumberFormatException")
    void givenNumericStringOfLengthSmallerThan2_whenVerifyValidity_thenThrowNumberFormatException() {

        String failingNumericValue = "1";

        int actualLength = failingNumericValue.length();
        int expectedLength = 1;

        Assertions.assertEquals(actualLength, expectedLength);

        Exception exception = Assertions.assertThrows(NumberFormatException.class,
                () -> luhnAlgorithm.verifyValidity(failingNumericValue)
        );

        String expected = NumberFormatException.class.getTypeName();
        String actual = exception.getClass().getTypeName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Non-Numeric Sequence Throws NumberFormatException")
    void givenNonNumericSequence_whenVerifyValidity_thenThrowNumberFormatException() {

        String nonNumericSequence = "abcde";

        Exception exception = Assertions.assertThrows(NumberFormatException.class,
                () -> luhnAlgorithm.verifyValidity(nonNumericSequence)
        );

        String expected = NumberFormatException.class.getTypeName();
        String actual = exception.getClass().getTypeName();

        Assertions.assertEquals(expected, actual);
    }
}