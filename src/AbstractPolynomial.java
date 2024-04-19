package ex_3;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        /* TODO *
         */
        StringBuilder builder = new StringBuilder();
        int degree = degree();
        for (int i = 0; i <= degree; i++) {
            double coefficient = coefficientAt(i);
            if (coefficient != 0) {
                if (builder.length() > 0) {
                    builder.append(" + ");
                }
                builder.append(coefficient);
                if (i > 0) {
                    builder.append("x");
                    if (i > 1) {
                        builder.append("^").append(i);
                    }
                }
            }
        }
        return builder.toString();

    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        int degree = degree();
        double[] derivativeCoefficients = new double[degree];
        for (int i = 1; i <= degree; i++) {
            derivativeCoefficients[i - 1] = coefficientAt(i) * i;
        }
        return derivativeCoefficients;
    }
}
