package retracemissingnumber;

import java.util.Scanner;
import java.util.Set;

import static retracemissingnumber.NumberRetracerApplication.main;

public class CommandLineInterface {

    public void interactWithUser(String[] args) {

        SetGenerator setGenerator = new SetGenerator();
        RecursiveSumGenerator recursiveSumGenerator = new RecursiveSumGenerator();
        Scanner scanner = new Scanner(System.in);

        String infimumInput, supremumInput, reprise;
        int infimum, supremum;
        boolean isInfimumAndSupremumValid = true;

        System.out.println("********** RETRACE RANDOMLY REMOVED FIGURE FROM SEQUENTIAL SET OF WHOLE NUMBERS **********");

        do {
            try {
                System.out.print("\n" + "Select infimum: ");
                infimumInput = scanner.nextLine();
                infimum = Integer.parseInt(infimumInput);

                System.out.print("Select supremum: ");
                supremumInput = scanner.nextLine();
                supremum = Integer.parseInt(supremumInput);

                try {
                    Set<Integer> set = setGenerator.createSetAndRemoveRandomFigure(infimum, supremum);
                    System.out.println("\n" + "Sequential subset: " + set);
                    int expectedSum;

                    try {
                        expectedSum = recursiveSumGenerator.calculateSum(infimum, supremum);
                        System.out.println("\n" + "Expected sum: " + expectedSum);

                        int actualSum = set.stream().reduce(0, Integer::sum);
                        System.out.println("Actual sum: " + actualSum);

                        System.out.println("\n" + "Retraced figure: " + (expectedSum - actualSum));
                    } catch(ArithmeticException ae) {
                        ae.printStackTrace();
                    }

                    isInfimumAndSupremumValid = false;

                } catch(IllegalArgumentException iae) {
                    System.out.println(iae.getLocalizedMessage());
                    System.out.println("Do you want to try again? (Y/N)");

                    do {
                        reprise = scanner.nextLine();
                        if(reprise.equalsIgnoreCase("N")) {
                            isInfimumAndSupremumValid = false;
                        }
                    } while(!reprise.equalsIgnoreCase("Y") && !reprise.equalsIgnoreCase("N"));
                }

            } catch(NumberFormatException nfe) {
                nfe.printStackTrace();
                System.out.println("Invalid Input. Do you want to try again? (Y/N)");

                do {
                    reprise = scanner.nextLine();
                    if(reprise.equalsIgnoreCase("N")) {
                        isInfimumAndSupremumValid = false;
                    }
                } while(!reprise.equalsIgnoreCase("Y") && !reprise.equalsIgnoreCase("N"));
            }

        } while(isInfimumAndSupremumValid);

        System.out.print("Exit application? (Y/N): ");
        reprise = scanner.nextLine();

        if(reprise.equalsIgnoreCase("N")) {
            main(args);
        }
    }

}
