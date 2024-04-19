package ex_3;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức sử dụng phương pháp Newton-Raphson.
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức.
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        /* TODO */
        double x0 = (lower + upper) / 2;
        for (int i = 0; i < maxIterations; i++) {
            double f = polynomial.evaluate(x0);
            double fPrime = polynomial.derivative().evaluate(x0);
            double x1 = x0 - f / fPrime;
            if (Math.abs(x1 - x0) < tolerance || f == 0) {
                return x1;
            }
            x0 = x1;
        }
        return (lower + upper) / 2;
    }
}
