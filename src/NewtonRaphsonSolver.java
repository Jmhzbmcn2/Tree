package midtermkhoakhoa.polynomial;

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
        Polynomial derivative = polynomial.derivative();
        int n = 1;
        double x0 = -20; //guess x0
        double h = polynomial.evaluate(x0) / derivative.evaluate(x0);
        while (n <= maxIterations && Math.abs(h) >= tolerance) {
            h = polynomial.evaluate(x0) / derivative.evaluate(x0);
            x0 = x0 - h;
        }
        return x0;
    }
}
