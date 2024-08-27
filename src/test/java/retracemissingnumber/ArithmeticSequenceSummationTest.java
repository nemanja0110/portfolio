package retracemissingnumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticSequenceSummationTest {

    ArithmeticSequenceSummation arithmeticSequenceSummation = new ArithmeticSequenceSummation();

    @Test
    @DisplayName("Test Case With Positive Valid Arguments")
    void given3And5_whenCalculateGaussSum_thenReturn12() {
        int infimum = 3, supremum = 5;
        int actual = arithmeticSequenceSummation.sumArithmeticSequence(infimum, supremum);
        int expected = 12;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test Case To Identify Positive Corner Case")
    void given1And46340_whenCalculateGaussSum_thenReturn1073720970() {
        int infimum = 1, supremum = 46_340;
        int actual = arithmeticSequenceSummation.sumArithmeticSequence(infimum, supremum);
        int expected = 1_073_720_970;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Infimum Of 1 And Supremum Of 46_341 Causes Overflow")
    void givenLargeSupremum_whenCalculateGaussSum_thenThrowArithmeticException() {
        Assertions.assertThrows(ArithmeticException.class, () ->
                arithmeticSequenceSummation.sumArithmeticSequence(1, 46_341)
        );
    }

    @Test
    @DisplayName("Infimum Of -46_340 And Supremum Of -1 Causes Underflow")
    void givenSmallInfimum_whenCalculateGaussSum_thenThrowArithmeticException() {
        Assertions.assertThrows(ArithmeticException.class, () ->
                arithmeticSequenceSummation.sumArithmeticSequence(-46_340, -1)
        );
    }

}