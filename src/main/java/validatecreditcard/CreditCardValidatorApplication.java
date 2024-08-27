package validatecreditcard;

public class CreditCardValidatorApplication {

    public static void main(String[] args) {

        CommandLineInterface commandLineInterface = new CommandLineInterface();

        commandLineInterface.interactWithUser(args);

    }
}
