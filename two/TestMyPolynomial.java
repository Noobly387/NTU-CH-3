package two;

public class TestMyPolynomial {
    /**
     * Test driver, uses every method in MyPolynomial
     * 
     * @param args doesnt matter, not used
     */
    public static void main(String... args) {
        MyPolynomial poly1 = new MyPolynomial(1, 0, 0, 1, 0);
        MyPolynomial poly2 = new MyPolynomial(0, 0, 0, 0, 2);

        System.out.println(poly1.multiply(poly2).toString());
        // should print with coeffs 2,0,0,2,0
        System.out.println(poly1.getDegree());
        // should print 4
        System.out.println(poly1.evaluate(1));
        // should also print 4

        poly1 = new MyPolynomial(1, 0, 0, 1, 0);
        System.out.println(poly1.add(poly2).toString());
        // should print with coeffs 1,0,0,1,2
    }
}