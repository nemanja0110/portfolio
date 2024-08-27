# 0. Introduction

My main motivation for this showcase represents an attempt to practice and further improve and refine my programming and mathematical skills. Furthermore I see an opportunity to explore best practices in regards to programming style and methodology.

# 1. Overview

## 1.1. NumberRetracerApplication

The problem at hand revolves around finding a missing figure from a set of sequential numbers. Ever since I encountered this common puzzler, I was intrigued by the many approaches that could lead to the solution of the problem. 

For my initial approach I made use of a for-each-loop to calculate the actual sum and subtract the result from the expected sum. A more elegant approach utilizes the formula for arithmetic sequences, which I implemnted later on.

The solution for the time being utilizes recursive functions to calculate the sum of any given sequence. This approach is highly inefficient, but inspired me to implement a fallback mechanism, which would step in in case a `StackOverflowError` occured. This fallback-mechanism is demonstrated in the following code snippet:

```
public int calculateSum(int infimum, int supremum) {

	if(infimum >= supremum) {
    	throw new IllegalArgumentException("Supremum must be greater than infimum.");
    }

    try {
    	return calculateProvisionalResult(infimum, supremum - infimum, 0);
    } catch(StackOverflowError soe) {
    	soe.printStackTrace();
        return new ArithmeticSequenceSummation().sumArithmeticSequence(infimum, supremum);
    }
}
```

This puzzler has been a very rewarding playground for experimenting with different approaches and implementations. At some point in the future I would like to expand the program even further by allowing to retrace any number of missing elements from a given set, by pure mathematical means.

## 1.2. CreditCardVerifierApplication

This application is build around another common programmer quizzer, with the Luhn-Algorithm at its center. My approach is once again rather inefficent as I am wastefully employing a number of lists to implement Luhn's Algorithm. My main goal was to practice decomposing methods, as this approach is becoming more and more natural, the more I advance as a programmer.

Every step of the Luhn-Algorithm is represented by its own method. Reading the names of the methods provides a precise description of the algorithm, which is demonstrated in the following code snippet:

```
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
```

Another aspect I would like to highlight is the use of enums to define three different credit card vendors. This approach allows for an effortless replacement of existing and/or additon of further vendors.

## 1.3. Gaussian Elimination

**COMING SOON**