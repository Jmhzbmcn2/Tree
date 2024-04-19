package ex_3;

public class PolynomialRootFinding {
    private Polynomial poly;
    private RootSolver rootSolver;

    /**
     * Khởi tạo đa thức.
     * @param polynomial
     */
    public PolynomialRootFinding(Polynomial polynomial) {
        /* TODO */
        this.poly = polynomial;

    }

    /**
     * Khởi tạo đa thức và phương pháp tìm nghiệm.
     * @param polynomial
     * @param rootSolver
     */
    public PolynomialRootFinding(Polynomial polynomial, RootSolver rootSolver) {
        /* TODO */
        this.poly = polynomial;
        this.rootSolver = rootSolver;
    }

    public void setPoly(Polynomial poly) {
        /* TODO */
        this.poly = poly;
    }

    public void setRootSolver(RootSolver rootSolver) {
        /* TODO */
        this.rootSolver = rootSolver;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp đã cho.
     * @param lower
     * @param upper
     * @return
     */
    public double solve(double lower, double upper) {
        /* TODO */
        if (poly == null || rootSolver == null) {
            throw new IllegalStateException("Polynomial or RootSolver is not set");
        }
        return rootSolver.solve(poly, lower, upper);
    }
}
