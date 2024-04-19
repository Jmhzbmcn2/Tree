package midtermkhoakhoa.polynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        /* TODO */
        this.coefficients = new ArrayList<>();
    }
    public ListPolynomial(double[] array) {
        this.coefficients = new ArrayList<>();
        for (double coefficient : array) {
            coefficients.add(coefficient);
        }

    }
    private boolean checkBoundaries(int index) {
        return index >= 0 && index < this.coefficients.size();
    }
    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficientAt(int index) {
        /* TODO */
        if (!checkBoundaries(index)) {
            return -1;
        }
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return mảng các hệ số của đa thức
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtStart(double coefficient) {
        /* TODO */
        coefficients.add(0,coefficient);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtEnd(double coefficient) {
        /* TODO */
        coefficients.add(coefficient);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public void insertAtPosition(int index, double coefficient) {
        /* TODO */
        if (!checkBoundaries(index)) {
            return;
        }
        coefficients.add(index, coefficient);
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
        coefficients.set(index, coefficient);
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        return coefficients.size() + 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = coefficients.get(coefficients.size() - 1);
        for (int i = coefficients.size() - 2; i >= 0; i--) {
            result = result * x + coefficients.get(i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        return new ListPolynomial(differentiate());
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        int size = Math.max(this.degree(), another.degree()) - 1;
        double[] sum = new double[size];

        // Initialize the product polynomial
        for (int i = 0; i < coefficients.size(); i++) {
            sum[i] = coefficients.get(i);
        }

        for (int i = 0; i < another.degree() - 1; i++) {
            sum[i] += another.coefficientAt(i);
        }
        return new ListPolynomial(sum);
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        /* TODO */
        int size = Math.max(this.degree(), another.degree()) - 1;
        double[] sum = new double[size];

        // Initialize the product polynomial
        for (int i = 0; i < coefficients.size(); i++) {
            sum[i] = coefficients.get(i);
        }

        for (int i = 0; i < another.degree() - 1; i++) {
            sum[i] -= another.coefficientAt(i);
        }
        return new ListPolynomial(sum);
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        int sharedSize = coefficients.size() + another.degree() - 1 - 1;
        double[] prod = new double[sharedSize];

        // Multiply two polynomials term by term
        // Take ever term of first polynomial
        for (int i = 0; i < this.coefficients.size(); i++)
        {
            // Multiply the current term of first polynomial
            // with every term of second polynomial.
            for (int j = 0; j < another.degree() - 1; j++)
            {
                prod[i + j] += coefficients.get(i) * another.coefficientAt(j);
            }
        }
        return new ListPolynomial(prod);
    }
}
