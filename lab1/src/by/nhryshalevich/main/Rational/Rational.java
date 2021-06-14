package by.nhryshalevich.main.Rational;

public class Rational {
/*
 * A class that represents mathematical rational number as ratio
 *
 * Attributes
 * ------
 *  num: int
 *      the numerator
 *  den: int
 *      demonicator
 *
 * Methods
 * -------
 *
 */
    private int num;
    private int den;

    public Rational() {
        num = 0; 
        den = 1;
    }

    private static int greatCommonDivisor(int a, int b) {
        return b == 0 ? a : greatCommonDivisor(b, a % b);
    }

    public Rational(int num, int den) {
        if (den == 0) {
            throw new ArithmeticException("Division by zero");
        }

        if (den < 0) {
            num *= -1;
            den *= -1;
        }

        int d = greatCommonDivisor(num, den);
        num /= d;
        den /= d;

        this.num = num;
        this.den = den;
    }

    public int getNum() {
        return num;
    }

    public int getDen() {
        return den;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setDen(int den) {
        this.den = den;
    }

    public void reduce() {
        int greatComDiv = greatCommonDivisor(Math.abs(num), Math.abs(den));
        num /= greatComDiv;
        den /= greatComDiv;
    }

    public Rational square() {
        return new Rational(num*num, den*den);
    }

    public float rationalToFloat() {
        return (float) num/den;
    }

    @Override
    public String toString() {
        if (den == 1) {
            return Integer.toString(num);
        }
        return String.format("%d/%d", num, den);
    }

    public boolean equals(Rational ratio) {
        ratio.reduce();
        return num == ratio.num && den == ratio.den;
    }
}

