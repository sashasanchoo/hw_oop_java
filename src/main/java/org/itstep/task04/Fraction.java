package org.itstep.task04;

public class Fraction {
    private int numerator;//числитель
    private int denominator;//знаменатель

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction() {
    }
    public Fraction addition(Fraction fraction){
        Fraction result = new Fraction();
        if(this.denominator != fraction.denominator){
            int resultDenominator = this.denominator * fraction.denominator;
            result.setNumerator(resultDenominator / this.denominator + resultDenominator / fraction.denominator);
            result.setDenominator(resultDenominator);
        }
        else{
            result.setNumerator(this.numerator + fraction.numerator);
            result.setDenominator(this.denominator);
        }
        if(result.numerator == result.denominator)
        {
            result.setNumerator(1);
            result.setDenominator(1);
        }
        return result;
    }
    public Fraction subtraction(Fraction fraction){
        Fraction result = new Fraction();
        if(this.denominator != fraction.denominator){
            int resultDenominator = this.denominator * fraction.denominator;
            result.setNumerator(resultDenominator / this.denominator - resultDenominator / fraction.denominator);
            result.setDenominator(resultDenominator);
        }
        else{
            result.setNumerator(this.numerator - fraction.numerator);
            result.setDenominator(this.denominator);
        }
        if(result.numerator == result.denominator)
        {
            result.setNumerator(1);
            result.setDenominator(1);
        }
        return result;
    }
    public Fraction multiplication(Fraction fraction){

        return new Fraction(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
    }
    public Fraction division(Fraction fraction){
        Fraction result = new Fraction(this.numerator * fraction.denominator, this.denominator * fraction.numerator);
        if(result.numerator > result.denominator && result.numerator % result.denominator == 0){
            result.setNumerator(result.numerator / result.denominator);
            result.setDenominator(result.denominator / result.denominator);
            return result;
        }
        else if(result.numerator > result.denominator && result.numerator % result.denominator != 0){
            for(int i = 2; i < result.numerator; i++){
                if(result.numerator % i == 0 && result.denominator % i == 0){
                    result.setNumerator(result.numerator / i);
                    result.setDenominator(result.denominator / i);
                    return result;
                }
            }
        }
        return result;
    }
}
