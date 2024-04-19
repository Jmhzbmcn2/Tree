package midtermkhoakhoa.polynomial;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        /* TODO */
        this.coefficents = new double[DEFAULT_CAPACITY];
    }
    public ArrayPolynomial(double[] array) {
        this.coefficents = array;
        this.size = array.length;
    }
    private boolean checkBoundaries(int index) {
        return index >= 0 && index < size;
    }
    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficientAt(int index) {
        /* TODO */
        if (!checkBoundaries(index)) {
            return -1;
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
        if (size == coefficents.length) {
            allocateMore();
        }
        for (int i = size; i > 0; i--) {
            coefficents[i] = coefficents[i-1];
        }
        coefficents[0] = coefficient;
        size++;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtEnd(double coefficient) {
        if (size == coefficents.length) {
            allocateMore();
        }
        coefficents[size] = coefficient;
        size++;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public void insertAtPosition(int index, double coefficient) {
        /* TODO */
        if (size == coefficents.length) {
            allocateMore();
        }
        if (!checkBoundaries(index)) {
            return;
        }
        for (int i = size; i > index; i--) {
            coefficents[i] = coefficents[i - 1];
        }
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
        if (!checkBoundaries(index)) {
            return;
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
        return this.size + 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = coefficents[coefficents.length - 1];
        for (int i = coefficents.length - 2; i >= 0; i--) {
            result = result * x + coefficents[i];
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
        return new ArrayPolynomial(differentiate());
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        /* TODO */
        int size = Math.max(this.degree(), another.degree()) - 1;
        double[] sum = new double[size];

        // Initialize the product polynomial
        if (this.size >= 0) System.arraycopy(coefficents, 0, sum, 0, this.size);

        for (int i = 0; i < another.size; i++) {
            sum[i] += another.coefficientAt(i);
        }
        return new ArrayPolynomial(sum);
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        /* TODO */
        int size = Math.max(this.degree(), another.degree()) - 1;
        double[] sum = new double[size];

        // Initialize the product polynomial
        if (this.size >= 0) System.arraycopy(coefficents, 0, sum, 0, this.size);

        for (int i = 0; i < another.degree() - 1; i++) {
            sum[i] -= another.coefficientAt(i);
        }
        return new ArrayPolynomial(sum);
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        /* TODO */
        int sharedSize = this.size + another.degree() - 1 - 1;
        double[] prod = new double[sharedSize];

        // Multiply two polynomials term by term
        // Take ever term of first polynomial
        for (int i = 0; i < this.size; i++)
        {
            // Multiply the current term of first polynomial
            // with every term of second polynomial.
            for (int j = 0; j < another.degree() - 1; j++)
            {
                prod[i + j] += coefficents[i] * another.coefficientAt(j);
            }
        }
        return new ArrayPolynomial(prod);
    }

    /**
     * Thêm kích thước mảng gấp đôi để lưu đa thức.
     */
    private void allocateMore() {
        double[] newData = new double[coefficents.length * 2];
        System.arraycopy(coefficents,
                0,
                newData,
                0,
                size);
        coefficents = newData;
    }
}
