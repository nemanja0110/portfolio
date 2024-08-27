package validatecreditcard;

import java.util.Scanner;

public class CommandLineInterface {

    public void interactWithUser(String[] args) {
        CreditCardReviewer creditCardInspector = new CreditCardReviewer();

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("Please enter a credit card number: ");

            try {
                String creditCardNumber = scanner.nextLine();
                System.out.println("The provided credit card number is: " + creditCardInspector.evaluateCardNumber(creditCardNumber));
                break;

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

                System.out.println("The provided credit card number is incorrect.");
                System.out.println("Do you want to enter another credit card number? (y/n)");
                String proceed = scanner.nextLine();

                if(proceed.equalsIgnoreCase("y")) {
                    continue;
                }
                break;
            }
        }

        System.out.println("Do you want to exit the application? (y/n)");
        String repeat = scanner.nextLine();

        if(repeat.equalsIgnoreCase("y")) {
            scanner.close();
            System.exit(0);
        }

        if(repeat.equalsIgnoreCase("n") && !repeat.equalsIgnoreCase("y")) {
            CreditCardValidatorApplication.main(args);
        }

    }

}
