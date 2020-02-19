package two;

public class MyPolynomial {

    private double[] coeffs;

    /**
     * Constructs the object with field coeffs set to @param coeffs
     * 
     * @param coeffs coeffs to set to the field
     */
    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    /**
     * Returns order of highest nonzero coefficient
     * 
     * @return degree of polynomial
     */
    public int getDegree() {
        for (int i = this.coeffs.length - 1; i >= 0; i--) {
            if (this.coeffs[i] != 0) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Returns a string-formatted version of the polynomial, ignores
     * zero-coefficients, other than the zeroeth-order coefficient, which will be
     * returned regardless of value.
     * 
     * @return String formatted coeffs
     */
    @Override
    public String toString() {
        String out = new String();
        for (int i = 0; i < this.coeffs.length - 1; i++) {
            if (coeffs[i] != 0) {
                out += coeffs[i] + "x^" + (this.coeffs.length - i - 1);
                if (i != this.coeffs.length - 1) {
                    out += '+';
                }
            }
        }
        out += coeffs[this.coeffs.length - 1];
        return out;
    }

    /**
     * Plugs n chugs
     * 
     * @param x plug
     * @return chug
     */
    public double evaluate(double x) {
        double out = 0;
        for (int i = coeffs.length - 1; i > 0; i--) {
            out += Math.pow(x, i) * coeffs[i];
        }
        out += coeffs[0];
        return out;
    }

    /**
     * Adds to polynomials, really just adds up their coeffs
     * 
     * @param that polynomial to add
     * @return this polynomial after adding corresponding coeffs
     */
    public MyPolynomial add(MyPolynomial that) {
        int target = coeffs.length;
        if (that.coeffs.length < this.coeffs.length) {
            target = that.coeffs.length;
        }
        for (int i = 0; i < target; i++) {
            coeffs[i] += that.coeffs[i];
        }
        return this;
    }

    /**
     * Multiplies polynomials, has to do it in reverse order to keep coeffs
     * formatted correctly
     * 
     * @param that polynomial to multiply with
     * @return this polynomial after multiplying
     */
    public MyPolynomial multiply(MyPolynomial that) {
        double coeffs[] = new double[this.coeffs.length + that.coeffs.length - 1];
        for (int i = this.coeffs.length - 1; i >= 0; i--) {
            for (int j = that.coeffs.length - 1; j >= 0; j--) {
                coeffs[i + j] += this.coeffs[i] * that.coeffs[j];
            }
        }
        this.coeffs = coeffs;
        return this;
    }
}