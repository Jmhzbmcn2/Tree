package homework1.ex_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        OperationWithArray testMain = new OperationWithArray();
        int[] array = testMain.inputValue(random);
        testMain.printArray(array);
        testMain.printPerfectNumber(array);
        testMain.printPrimeNumber(array);

    }
}
