package midtermkhoakhoa.polynomial;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int deg = 0; deg < degree() - 1; deg++) {
            sb.append(coefficientAt(deg)).append(" ");
            if (deg != 0) {
                sb.append("x ^ ").append(deg);
            }
            sb.append(" + ");
        }
        String result = sb.toString();
        return result.substring(0, result.length() - 3) + "]";
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        double[] result = new double[this.coefficients().length - 1];
        for (int i = 1; i < degree() - 1; i++) {
            result[i-1] = coefficientAt(i) * i;
        }
        return result;
    }
}
