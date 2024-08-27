package retracemissingnumber;

public class RecursiveSumGenerator {

    public int calculateSum(int infimum, int supremum) {

        if(infimum >= supremum) {
            throw new IllegalArgumentException("Supremum must be greater than infimum.");
        }

        try{
            return calculateProvisionalResult(infimum, supremum - infimum, 0);
        } catch(StackOverflowError soe) {
            soe.printStackTrace();
            return new ArithmeticSequenceSummation().sumArithmeticSequence(infimum, supremum);
        }
    }

    private int calculateProvisionalResult(int infimum, int counter, int sum) throws StackOverflowError {
        sum += infimum;
        return (verifyBaseCase(counter)) ? sum : calculateProvisionalResult(++infimum, --counter, sum);
    }

    private boolean verifyBaseCase(int counter) {
        return counter == 0;
    }
}
