package one;

public class TestDriver {
    /**
     * checks all the operations... assignment was vague
     * @param args
     */
    public static void main(String[] args) {
        MyComplex comp1 = new MyComplex(1.2, 2.4);
        MyComplex comp2 = new MyComplex();
        comp2.setImag(643.2);
        comp2.setReal(2131.1);
        comp2.setValue(1,1);
        System.out.println(comp1.toString() + " : " + comp2.toString());
        comp1.add(comp2);
        System.out.println(comp1.toString());
        comp1.addNew(comp2);
        System.out.println(comp1.toString());
        comp1.subtract(comp2);
        comp1.subtractNew(comp2);
        System.out.println(comp1);
        comp1.multiply(comp2);
        System.out.println(comp1);
        comp1.divide(comp2);
        System.out.println(comp1);
        System.out.println(comp1.magnitude() + " : " + comp1.argument());
        
    }
}