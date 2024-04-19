package midtermkhoakhoa.polynomial;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public SecantSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp Secant
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức trong khoảng [lower, upper]
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        /* TODO */
        double n = 0, xm, x0, c;
        if (polynomial.evaluate(lower) * polynomial.evaluate(upper) < 0)
        {
            do {

                // calculate the intermediate
                // value
                x0 = (lower * polynomial.evaluate(upper) - upper * polynomial.evaluate(lower))
                        / (polynomial.evaluate(upper) - polynomial.evaluate(lower));

                // check if x0 is root of
                // equation or not
                c = polynomial.evaluate(lower) * polynomial.evaluate(x0);

                // update the value of interval
                lower = upper;
                upper = x0;

                // update number of iteration
                n++;

                // if x0 is the root of equation
                // then break the loop
                if (c == 0)
                    break;
                xm = (lower * polynomial.evaluate(upper) - upper * polynomial.evaluate(lower))
                        / (polynomial.evaluate(upper) - polynomial.evaluate(lower));

                // repeat the loop until the
                // convergence
            } while (Math.abs(xm - x0) >= tolerance);
            return x0;
        }

        System.out.print("Can not find a" + " root in the given interval");
        return -1;
    }
}
