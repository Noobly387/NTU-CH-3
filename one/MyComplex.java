package one;

public class MyComplex {
    private double real, imag;

    /**
     * Constructs MyComplex with real and imag set to 0
     */
    MyComplex() {
        this.real = 0;
        this.imag = 0;
    }

    /**
     * Constructs MyComplex with real and imag set to the parameters
     */
    MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * Returns value of field real
     * 
     * @return real
     */
    public double getReal() {
        return real;
    }

    /**
     * Sets the value of field real
     * 
     * @param real value to set real to
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     * Returns value of field imag
     * 
     * @return imag
     */
    public double getImag() {
        return imag;
    }

    /**
     * Sets the value of the field imag
     * 
     * @param imag vvalue to set imag to
     */
    public void setImag(double imag) {
        this.imag = imag;
    }

    /**
     * Sets real and imag to the parameters
     * 
     * @param real value to set real to
     * @param imag value to set imag to
     */
    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * Returns real and imag in string format (real.real + imag.imag i)
     */
    @Override
    public String toString() {
        return "(" + real + " + " + imag + "i)";
    }

    /**
     * Returns whether the imaginary component is zero
     * 
     * @return whether is real
     */
    public boolean isReal() {
        return (imag == 0);
    }

    /**
     * Returns whether the real component is zero
     * 
     * @return whether is imaginary
     */
    public boolean isImaginary() {
        return (real == 0);
    }

    /**
     * Decides whether the instance is equal to the fields passed
     * 
     * @param real the field to be compared to real
     * @param imag the field to be compared to imag
     * @return whether both are the same
     */
    public boolean equals(double real, double imag) {
        return (this.real == real && this.imag == imag);
    }

    /**
     * Decides whether the instance is equal to the other instance passed
     * 
     * @param myComplex instance to be compared to
     * @return whether both fields are the same
     */
    public boolean equals(MyComplex myComplex) {
        return (this.real == myComplex.real && this.imag == myComplex.imag);
    }

    /**
     * The overall distance in imaginary plane from the origin
     * 
     * @return distance from origin
     */
    public double magnitude() {
        return Math.sqrt(Math.pow(this.imag, 2) + Math.pow(this.real, 2));
    }

    /**
     * Angle from origin
     * 
     * @return angle from origin
     */
    public double argument() {
        return Math.atan2(imag, real);
    }

    /**
     * adds this instance to the one passed
     * 
     * @param that instance to be added to this one
     * @return this instance after adding
     */
    public MyComplex add(MyComplex that) {
        this.imag += that.imag;
        this.real += that.real;
        return this;
    }

    /**
     * adds this instance and the one passed to a new one
     * 
     * @param that instance to be added to this one
     * @return the new instance
     */
    public MyComplex addNew(MyComplex that) {
        return new MyComplex(this.real + that.real, this.imag + that.imag);
    }

    /**
     * subtracts the instance passed from this one
     * 
     * @param that instance to be subtracted
     * @return this instance after subtracting
     */
    public MyComplex subtract(MyComplex that) {
        this.imag -= that.imag;
        this.real -= that.real;
        return this;
    }

    /**
     * subtracts the instance passed from this one into a new one
     * 
     * @param that instance to be subtracted
     * @return the new instance
     */
    public MyComplex subtractNew(MyComplex that) {
        return new MyComplex(this.real - that.real, this.imag - that.imag);
    }

    /**
     * foils this instance with the one passed
     * @param that instance to be foiled with
     * @return this instance after foiling
     */
    public MyComplex multiply(MyComplex that) {
        double imag = (this.real * that.real) - (this.imag * that.imag);
        double real = (this.real * that.imag) + (this.imag + that.real);
        this.real = real;
        this.imag = imag;
        return this;
    }
    /**
     * divides the instance with the one passed
     * @param that instance in the denominator
     * @return this instance after division
     */
    public MyComplex divide(MyComplex that) {
        MyComplex instance = multiply(that.conjugate());
        double denominator = (Math.pow(that.real, 2) + Math.pow(that.imag, 2));
        this.real = instance.real / denominator;
        this.imag = instance.imag / denominator;
        return this;
    }
    /**
     * makes the instance it's own conjugate
     * @return this instance after conjugation
     */
    public MyComplex conjugate() {
        this.imag *= -1;
        return this;
    }
}