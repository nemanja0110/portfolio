package validatecreditcard;

import java.util.Set;

public enum CreditCardVendor implements CreditCardIdentifiable {

    AMERICAN_EXPRESS("AMERICAN EXPRESS", Set.of(15), Set.of("34", "37")),

    MASTERCARD("MASTERCARD", Set.of(16), Set.of("51", "52", "53", "54", "55")),

    VISA("VISA", Set.of(13, 16), Set.of("4"));

    private final String denomination;

    private final Set<Integer> sequenceLength;

    private final Set<String> subsequence;

    CreditCardVendor(String denomination, Set<Integer> sequenceLength, Set<String> subsequence) {
        this.denomination = denomination;
        this.sequenceLength = sequenceLength;
        this.subsequence = subsequence;
    }

    public Set<Integer> getSequenceLength() {
        return sequenceLength;
    }

    public Set<String> getSubsequence() {
        return subsequence;
    }

    @Override
    public boolean matchCardProperties(String cardNumber) {
        return checkSequenceLength(cardNumber.length()) &&
                checkSubsequence(cardNumber);
    }

    private boolean checkSequenceLength(int numberSequenceLength) {
        return getSequenceLength().contains(numberSequenceLength);
    }

    private boolean checkSubsequence(String cardNumber) {
        return getSubsequence().contains(cardNumber.substring(0, 2))
                || getSubsequence().contains(cardNumber.substring(0, 1));
    }

    @Override
    public String toString() {
        return denomination;
    }

}
