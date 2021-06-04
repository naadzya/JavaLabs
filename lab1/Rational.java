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

    private static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }

    public Rational(int num, int den) {
        if (den == 0) {
            throw new ArithmeticException("Division by zero");
        }

        if (den < 0) {
            num *= -1;
            den *= -1;
        }

        int d = GCD(num, den);
        num /= d;
        den /= d;

        this.num = num;
        this.den = den;
    }

    public int getnum() {
        return num;
    }

    public int getden() {
        return den;
    }

    public void setnum(int num) {
        this.num = num;
    }

    public void setden(int den) {
        this.den = den;
    }

    public void reduce() {
        int greatComDiv = GCD(Math.abs(num), Math.abs(den));
        num /= greatComDiv;
        den /= greatComDiv;
    }

    public Rational add(Rational ratio) {
        int numerator = num*ratio.den + ratio.num*den;
        int denominator = den * ratio.den;

        return new Rational(numerator, denominator);
    }

    public Rational subtract(Rational ratio) {
        int numerator = num*ratio.den - ratio.num*den;
        int denominator = den * ratio.den;

        return new Rational(numerator, denominator);
    }

    public Rational mult(Rational ratio) {
        return new Rational(num*ratio.num, den*ratio.den);
    }

    public Rational divide(Rational ratio) {
        return new Rational(num*ratio.getden(), den*ratio.getnum());
    }

    public Rational square() {
        return new Rational(num*num, den*den);
    }

    public float rationalToFloat() {
        return (float) num/den;
    }

    public String toString() {
        if (den == 1) {
            return Integer.toString(num);
        }
        return String.format("%d/%d", num, den);
    }
}

