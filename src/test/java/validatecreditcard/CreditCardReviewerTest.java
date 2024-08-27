package validatecreditcard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CreditCardReviewerTest {

    CreditCardReviewer creditCardReviewer = new CreditCardReviewer();

    @ParameterizedTest
    @DisplayName("Valid Numeric Sequences Return Corresponding Vendor")
    @MethodSource("numeric_sequences")
    void givenValidNumericSequences_whenEvaluateCardNumber_thenReturnCorrespondingVendor(String sequence, String expectedVendor) {
        Assertions.assertEquals(expectedVendor, creditCardReviewer.evaluateCardNumber(sequence));
    }

    private static Stream<Arguments> numeric_sequences() {
        return Stream.of(
                Arguments.of("4556258205802873", "VISA"),
                Arguments.of("5455072116610328", "MASTERCARD"),
                Arguments.of("374351947061805", "AMERICAN EXPRESS"),
                Arguments.of("6011739418660954", "NOT SUPPORTED"),   //  Discover
                Arguments.of("36256736720356", "NOT SUPPORTED"),     //  Diners Club
                Arguments.of("6759337018137832", "NOT SUPPORTED")    //  Maestro
        );
    }

    @Test
    @DisplayName("Invalid Numeric Sequence Returns Invalid")
    void givenInvalidNumericSequence_whenEvaluateCardNumber_thenReturnInvalid() {
        String invalidNumericSequence = "0123456789";
        String actual = creditCardReviewer.evaluateCardNumber(invalidNumericSequence);
        String expected = "INVALID";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty Sequence Throws Exception")
    void givenEmptySequence_whenEvaluateCardNumber_thenThrowException() {
        String emptySequence = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> creditCardReviewer.evaluateCardNumber(emptySequence));
    }
}