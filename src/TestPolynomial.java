package ex_3;

import java.util.ArrayList;
import java.util.List;

public class TestPolynomial {
    public static void main(String[] args) {
        testArrayPolynomial();
        testListPolynomial();
        testRootSolver();
    }

    public static void testArrayPolynomial() {
        System.out.println("Test ArrayPolynomial:");
        double[] coefficients = {2, 5, 3, 1.5, 6};
        // Tạo một đa thức mới
        ArrayPolynomial polynomial = new ArrayPolynomial(coefficients);
        // Thêm các hệ số vào đa thức
        polynomial.insertAtEnd(1);
        polynomial.insertAtEnd(2);
        polynomial.insertAtEnd(3);
        // Kiểm tra các hệ số
        System.out.println("Coefficients:");
        for (int i = 0; i < polynomial.coefficients().length; i++) {
            System.out.print(polynomial.coefficientAt(i) + " ");
        }
        System.out.println();
        // Tính giá trị của đa thức khi biết giá trị của x
        System.out.println("Value at x = 2: " + polynomial.evaluate(2));
        // Tính đạo hàm của đa thức
        Polynomial derivative = polynomial.derivative();
        System.out.println("Derivative:");
        for (int i = 0; i <= derivative.degree(); i++) {
            System.out.print(derivative.coefficientAt(i) + " ");
        }
        System.out.println();
        // Xuống dòng để phân biệt kết quả của các test
        System.out.println();
    }

    public static void testListPolynomial() {
        System.out.println("Test ListPolynomial:");
        List<Double> coefficients = new ArrayList<>();
        coefficients.add(1.0);
        coefficients.add(2.2);
        coefficients.add(4.2);
        coefficients.add(12.5);
        coefficients.add(5.6);
        // Tạo một đa thức mới
        ListPolynomial polynomial = new ListPolynomial(coefficients);
        // Thêm các hệ số vào đa thức
        polynomial.insertAtEnd(1);
        polynomial.insertAtEnd(2);
        polynomial.insertAtEnd(3);
        // Kiểm tra các hệ số
        System.out.println("Coefficients:");
        for (int i = 0; i < polynomial.coefficients().length; i++) {
            System.out.print(polynomial.coefficientAt(i) + " ");
        }
        System.out.println();
        // Tính giá trị của đa thức khi biết giá trị của x
        System.out.println("Value at x = 2: " + polynomial.evaluate(2));
        // Tính đạo hàm của đa thức
        Polynomial derivative = polynomial.derivative();
        System.out.println("Derivative:");
        for (int i = 0; i <= derivative.degree(); i++) {
            System.out.print(derivative.coefficientAt(i) + " ");
        }
        System.out.println();
        // Xuống dòng để phân biệt kết quả của các test
        System.out.println();
    }

    public static void testRootSolver() {
        System.out.println("Test RootSolver:");
        double[] coefficients = {1, 2, 3, 4, 5, 6};
        // Tạo một đa thức
        ArrayPolynomial polynomial = new ArrayPolynomial(coefficients);
        polynomial.insertAtEnd(1);
        polynomial.insertAtEnd(-2);
        polynomial.insertAtEnd(1);
        // Tạo một BisectionSolver với độ chính xác 0.001 và tối đa 100 lần lặp
        BisectionSolver bisectionSolver = new BisectionSolver(0.001, 100);
        // Tìm nghiệm của đa thức trong khoảng [0, 2] bằng phương pháp chia đôi (Bisection)
        double root = bisectionSolver.solve(polynomial, 0, 2);
        System.out.println("Root using Bisection method: " + root);
        // Xuống dòng để phân biệt kết quả của các test
        System.out.println();
    }
}