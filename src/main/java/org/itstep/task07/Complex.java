package org.itstep.task07;

public class Complex {
    private double real;
    private double imaginary;

    public Complex() {
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public boolean equals(Complex complex){
        return complex.getReal() == this.getReal() && complex.getImaginary() == this.getImaginary();
    }
    public Complex plus(Complex complex){
        return new Complex(this.getReal() + complex.getReal(), this.getImaginary() + complex.getImaginary());
    }
}
