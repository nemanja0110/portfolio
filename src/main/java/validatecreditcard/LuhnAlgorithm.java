package validatecreditcard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LuhnAlgorithm {

    public boolean verifyValidity(String cardNumber) throws NumberFormatException {

        return (
                createCheckSum(
                        extractEvenParityIndices(
                                reverseAndIndex(cardNumber)
                        ),
                        reduceIndicesToSingleDigit(
                                multiplyIndicesByTwo(
                                        extractOddParityIndices(
                                                reverseAndIndex(cardNumber)
                                        )
                                )
                        )
                ) % 10
        ) == 0;
    }

    private List<String> reverseAndIndex(String cardNumber) {
        return new ArrayList<>(List.of(cardNumber.split(""))).reversed();
    }

    private List<String> extractOddParityIndices(List<String> cardNumberReversedAndIndexed) {
        return IntStream
                .range(0, cardNumberReversedAndIndexed.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(cardNumberReversedAndIndexed::get)
                .collect(Collectors.toList());
    }

    private List<String> extractEvenParityIndices(List<String> cardNumberReversedAndIndex) {
        return IntStream
                .range(0, cardNumberReversedAndIndex.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(cardNumberReversedAndIndex::get)
                .collect(Collectors.toList());
    }

    private List<String> multiplyIndicesByTwo(List<String> cardNumberReversedAndOddParityIndexed) {
        return cardNumberReversedAndOddParityIndexed.stream()
                .mapToInt(Integer::parseInt)
                .mapToObj(n -> Integer.toString(n + n))
                .collect(Collectors.toList());
    }

    private List<String> reduceIndicesToSingleDigit(List<String> cardNumberReversedAndOddParityIndicesDoubled) {
        return new ArrayList<>(
                List.of(String.join("", cardNumberReversedAndOddParityIndicesDoubled).split(""))
        );
    }

    private int createCheckSum(
            List<String> cardNumberReversedAndEvenParityIndexed,
            List<String> cardNumberReversedAndOddParityIndexed) {

        return Stream
                .concat(
                        cardNumberReversedAndEvenParityIndexed.stream(),
                        cardNumberReversedAndOddParityIndexed.stream()
                )
                .mapToInt(Integer::parseInt)
                .sum();
    }

}
