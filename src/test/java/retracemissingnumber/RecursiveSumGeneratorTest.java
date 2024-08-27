package retracemissingnumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cases for calculateSum() are being tested against the summation formula for arithmetic sequences.
 * For sets with an infimum other than 1, the formula is adjusted.
 * The IllegalArgumentException in the caluclateSum() method, is not going to be triggered in the current design,
 * since the exact same Exception would be triggered first by the createSet() method from the SetCreator class.
 * In case that the design of the application should change, the Exception in the RecursiveSumCreator is
 * retained for straightforward adaptions and also for testing purposes.
 */

class RecursiveSumGeneratorTest {

    RecursiveSumGenerator recursiveSumGenerator = new RecursiveSumGenerator();

    @Test
    @DisplayName("calculateSum(1, 11335) returns 64246780")
    void given1And11335_whenCalculateSum_thenReturn64246780() {
        int infimum = 1;
        int supremum = 11_335;

        int actual = recursiveSumGenerator.calculateSum(infimum, supremum);
        int expected = ((supremum * supremum) + supremum) / 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("calculateSum(1, 5) returns 15")
    void given1And5_whenCalculateSum_thenReturn15() {
        int infimum = 1;
        int supremum = 5;

        int actual = recursiveSumGenerator.calculateSum(infimum, supremum);
        int expected = ((supremum * supremum) + supremum) / 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("calculateSum(2, 5) returns 14")
    void given2And5_whenCalculateSum_thenReturn14() {
        int infimum = 2;
        int supremum = 5;

        int actual = recursiveSumGenerator.calculateSum(infimum, supremum);
        int expected = (((supremum * supremum) + supremum) / 2) - (((supremum - (supremum - infimum) - 1) * (supremum - (supremum - infimum) - 1) + (supremum - (supremum - infimum) -1)) / 2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("calculateSum(-5, -1) returns -15")
    void givenMinus1AndMinus5_whenCalculateSum_thenReturnMinus15() {
        int actual = recursiveSumGenerator.calculateSum(-5, -1);
        int expected = -15;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("calculateSum(1, (int) Math.pow(2, 16)) throws StackOverflowError")
    void given1And2ToThePowerOf16_whenCalculateSum_thenThrowStackOverflowError() {
        Assertions.assertThrows(ArithmeticException.class, () ->
                recursiveSumGenerator.calculateSum(1, (int) Math.pow(2, 16))
        );
    }

    @Test
    @DisplayName("calculateSum((int) -Math.pow(2, 16), -1) throws StackOverflowError")
    void given2ToThePowerOf15_whenCalculateSum_thenThrowStackOverflowError() {
        Assertions.assertThrows(ArithmeticException.class, () ->
                recursiveSumGenerator.calculateSum((int) -Math.pow(2, 16), -1)
        );
    }
}