package retracemissingnumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SetGeneratorTest {

    SetGenerator setGenerator = new SetGenerator();

    @Test
    @DisplayName("1 And 5 W/ CreateSet Returns Set Of 4 Elements")
    void given1And5_whenCreateSet_thenCreateSetAndRemoveRandomFigureOf4Elements() {
        int infimum = 1;
        int supremum = 5;

        Set<Integer> actual = setGenerator.createSetAndRemoveRandomFigure(1, 5);
        Set<Integer> expectedSuperSet = new HashSet<>(Set.of(1, 2, 3, 4, 5));

        expectedSuperSet.removeAll(actual);
        int removedFigure = expectedSuperSet.hashCode();
        boolean isRemovedFigureWithinRangeOfInfimumAndSupremum = (removedFigure >= infimum) && (removedFigure <= supremum);

        Set<Integer> expected = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        expected.remove(removedFigure);

        Assertions.assertTrue(isRemovedFigureWithinRangeOfInfimumAndSupremum);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(4, actual.size());
    }

    @Test
    @DisplayName("Providing Invalid Arguments When CreateSet Throws IllegalArgumentException")
    void givenInvalidArguments_whenCreateSet_AndRemoveRandomFigure_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                setGenerator.createSetAndRemoveRandomFigure(5, 1)
        );
    }
}