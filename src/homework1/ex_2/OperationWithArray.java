package homework1.ex_2;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class OperationWithArray {
    public int[] sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++ ) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
    public  void printPrimeNumber(int[] array) {
        System.out.println("Các số nguyên tố trong mảng là: ");
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (isPrime(array[i])) {
                set.add(array[i]);
            }
        }
        for (int i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public  void printPerfectNumber(int[] array) {
        System.out.println("Các số hoàn hảo trong mảng là: ");
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (isPerfect(array[i])) {
                set.add(array[i]);
            }
        }
        for (int i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public  void printArray(int[] array) {
        System.out.println("Mảng vừa nhập vào là: ");
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if(i != array.length - 1) {
                System.out.print(array[i] + " ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("]");
    }

    public int[] inputValue(Random random) {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
        return sortArray(array);
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPerfect(int number) {
        if (number <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}
