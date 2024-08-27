package retracemissingnumber;

public class ArithmeticSequenceSummation {

    public int sumArithmeticSequence(int infimum, int supremum) throws StackOverflowError {
        return (infimum == 1) ? sumArithmeticSequenceForInfimumEqualToOne(supremum) : sumArithmeticSequenceForInfimumNotEqualToOne(infimum, supremum);
    }

    private int sumArithmeticSequenceForInfimumEqualToOne(int supremum) {

    //  SUMMATION-FORMULA: ((supremum * supremum) + supremum) / 2;

        return Math.divideExact(Math.addExact(Math.multiplyExact(supremum, supremum), supremum), 2);
    }

    private int sumArithmeticSequenceForInfimumNotEqualToOne(int infimum, int supremum) {

    //  ADJUSTED SUMMATION-FORMULA FOR INFIMUM != 1: (((supremum * supremum) + supremum) / 2) - (((infimum - 1) * (infimum - 1) + (infimum - 1)) / 2);

        return Math.divideExact(Math.addExact(Math.multiplyExact(supremum, supremum), supremum), 2)
                - Math.divideExact(Math.addExact(Math.multiplyExact(infimum - 1, infimum - 1), infimum - 1), 2);
    }

}
