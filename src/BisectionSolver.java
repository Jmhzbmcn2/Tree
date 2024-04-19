package ex_3;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp chia đôi (Bisection)
     * @param polynomial
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        /* TODO */
        double mid;
        for (int i = 0; i < maxIterations; i++) {
            mid = (lower + upper) / 2;
            if (Math.abs(upper - lower) < tolerance || polynomial.evaluate(mid) == 0) {
                return mid;
            }
            if (polynomial.evaluate(lower) * polynomial.evaluate(mid) <= 0) {
                upper = mid;
            } else {
                lower = mid;
            }
        }
        return (lower + upper) / 2;
    }
}
