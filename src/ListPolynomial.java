package ex_3;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial(List<Double> derivativeCoeffs) {
        /* TODO */
        coefficients = new ArrayList<>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficientAt(int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
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
        double[] coeffs = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            coeffs[i] = coefficients.get(i);
        }
        return coeffs;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtStart(double coefficient) {
        /* TODO */
        coefficients.add(0, coefficient);
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
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
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
        return coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, i);
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
        List<Double> derivativeCoeffs = new ArrayList<>();
        for (int i = 1; i < coefficients.size(); i++) {
            derivativeCoeffs.add(coefficients.get(i) * i);
        }
        return new ListPolynomial(derivativeCoeffs);
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        /* TODO */
        int maxDegree = Math.max(this.degree(), another.degree());
        List<Double> resultCoeffs = new ArrayList<>();
        for (int i = 0; i <= maxDegree; i++) {
            double thisCoeff = (i <= this.degree()) ? this.coefficientAt(i) : 0;
            double anotherCoeff = (i <= another.degree()) ? another.coefficientAt(i) : 0;
            resultCoeffs.add(thisCoeff + anotherCoeff);
        }
        return new ListPolynomial(resultCoeffs);
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        /* TODO */
        int maxDegree = Math.max(this.degree(), another.degree());
        List<Double> resultCoeffs = new ArrayList<>();
        for (int i = 0; i <= maxDegree; i++) {
            double thisCoeff = (i <= this.degree()) ? this.coefficientAt(i) : 0;
            double anotherCoeff = (i <= another.degree()) ? another.coefficientAt(i) : 0;
            resultCoeffs.add(thisCoeff - anotherCoeff);
        }
        return new ListPolynomial(resultCoeffs);
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        /* TODO */
        int newDegree = this.degree() + another.degree();
        List<Double> resultCoeffs = new ArrayList<>();
        for (int i = 0; i <= newDegree; i++) {
            double coeff = 0;
            for (int j = 0; j <= i; j++) {
                if (j <= this.degree() && (i - j) <= another.degree()) {
                    coeff += this.coefficientAt(j) * another.coefficientAt(i - j);
                }
            }
            resultCoeffs.add(coeff);
        }
        return new ListPolynomial(resultCoeffs);
    }

}
