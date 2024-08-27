package validatecreditcard;

import java.util.Arrays;

public class CreditCardReviewer {

    private final LuhnAlgorithm luhnAlgorithm;

    public CreditCardReviewer() {
        this.luhnAlgorithm = new LuhnAlgorithm();
    }

    public String evaluateCardNumber(String cardNumber) throws NumberFormatException {
        return (luhnAlgorithm.verifyValidity(cardNumber)) ? findVendor(cardNumber) : "INVALID";
    }

    private String findVendor(String cardNumber) {
        return Arrays.stream(CreditCardVendor.values())
                .filter(vendor -> vendor.matchCardProperties(cardNumber))
                .map(CreditCardVendor::toString)
                .findFirst()
                .orElse("NOT SUPPORTED");
    }

}
