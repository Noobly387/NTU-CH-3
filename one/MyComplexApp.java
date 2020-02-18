package one;

import java.util.Scanner;

public class MyComplexApp {
    
    private static Scanner in = new Scanner(System.in);
    /**
     * gets input
     * @return next line inputted into stdin
     */
    private static String getInput() {
        return in.nextLine();
    }
    /**
     * parses user input into a complex
     * @param st input string from user in form "x.x y.y"
     * @return MyComplex x.x+y.yi
     */
    private static MyComplex getComplex(String st) {
        String[] numbers = st.split("\\s");
        double[] doubles = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            doubles[i] = Double.parseDouble(numbers[i]);
        }
        return new MyComplex(doubles[0], doubles[1]);
    }
    /**
     * whether something is or not, returns string accordingly
     * @param c whether is or not
     * @return not or ""
     */
    private static String reel(boolean c){
        if(c){
            return "";
        }else{
            return "NOT";
        }
    }
    /**
     * just prints things according to spec
     * @param args doesnt matter
     */
    public static void main(String[] args) {
        System.out.print("Enter complex number 1 (real and imaginary part): ");
        MyComplex comp1 = getComplex(getInput());
        System.out.print("Enter complex number 2 (real and imaginary part): ");
        MyComplex comp2 = getComplex(getInput());
        in.close();
        System.out.println();

        System.out.println("Number 1 is: " + comp1.toString());
        System.out.println(comp1.toString() + " is " + reel(comp1.isReal()) + " a pure real number");
        System.out.println(comp1.toString() + " is " + reel(comp1.isImaginary()) + " a pure imaginary number");
        System.out.println();

        System.out.println("Number 2 is: " + comp2.toString());
        System.out.println(comp2.toString() + " is " + reel(comp2.isReal()) + " a pure real number");
        System.out.println(comp2.toString() + " is " + reel(comp2.isImaginary()) + " a pure imaginary number");
        System.out.println();

        System.out.println(comp1.toString()+" is "+reel(comp1.equals(comp2))+" equal to " + comp2.toString());
        System.out.println(comp1.toString() + " + " + comp2.toString() + " = " + comp1.addNew(comp2).toString());
        System.out.println(comp1.toString() + " - " + comp2.toString() + " = " + comp1.subtractNew(comp2).toString());
        
    }
}