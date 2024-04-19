package ex_3;

import java.util.*;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial(double[] derivativeCoefficients) {
        /* TODO */
        coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficientAt(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return coefficents[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        return Arrays.copyOf(coefficents, size);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtStart(double coefficient) {
        /* TODO */
        insertAtPosition(0, coefficient);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtEnd(double coefficient) {
        /* TODO */
        if (size >= coefficents.length) {
            allocateMore();
        }
        coefficents[size++] = coefficient;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public void insertAtPosition(int index, double coefficient) {
        /* TODO */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (size >= coefficents.length) {
            allocateMore();
        }
        // Dịch chuyển các phần tử sang phải để tạo chỗ cho phần tử mới
        System.arraycopy(coefficents, index, coefficents, index + 1, size - index);
        coefficents[index] = coefficient;
        size++;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public void set(int index, double coefficient) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        coefficents[index] = coefficient;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        return size - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += coefficents[i] * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        double[] derivativeCoefficients = new double[size - 1];
        for (int i = 1; i < size; i++) {
            derivativeCoefficients[i - 1] = coefficents[i] * i;
        }
        return new ArrayPolynomial(derivativeCoefficients);
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        /* TODO */
        int newSize = Math.max(size, another.size);
        double[] resultCoefficients = new double[newSize];
        for (int i = 0; i < newSize; i++) {
            double thisCoefficient = (i < size) ? coefficents[i] : 0;
            double anotherCoefficient = (i < another.size) ? another.coefficents[i] : 0;
            resultCoefficients[i] = thisCoefficient + anotherCoefficient;
        }
        return new ArrayPolynomial(resultCoefficients);
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        /* TODO */
        int newSize = Math.max(size, another.size);
        double[] resultCoefficients = new double[newSize];
        for (int i = 0; i < newSize; i++) {
            double thisCoefficient = (i < size) ? coefficents[i] : 0;
            double anotherCoefficient = (i < another.size) ? another.coefficents[i] : 0;
            resultCoefficients[i] = thisCoefficient - anotherCoefficient;
        }
        return new ArrayPolynomial(resultCoefficients);
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        /* TODO */
        int newSize = size + another.size - 1;
        double[] resultCoefficients = new double[newSize];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < another.size; j++) {
                resultCoefficients[i + j] += coefficents[i] * another.coefficents[j];
            }
        }
        return new ArrayPolynomial(resultCoefficients);
    }

    /**
     * Thêm kích thước mảng gấp đôi để lưu đa thức.
     */
    private void allocateMore() {
        /* TODO */
        int newCapacity = coefficents.length * 2;
        coefficents = Arrays.copyOf(coefficents, newCapacity);
    }
}
