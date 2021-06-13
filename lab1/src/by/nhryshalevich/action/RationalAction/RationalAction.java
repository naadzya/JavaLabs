package by.nhryshalevich.action.RationalAction;

import by.nhryshalevich.main.Rational.Rational;

public class RationalAction {
    public static Rational add(Rational ratio1, Rational ratio2) {
        int numerator = ratio1.getNum()*ratio2.getDen()
                        + ratio2.getNum()*ratio2.getDen();
        int denominator = ratio1.getDen() * ratio2.getDen();

        return new Rational(numerator, denominator);
    }

    public static Rational subtract(Rational ratio1, Rational ratio2) {
        int numerator = ratio1.getNum()*ratio2.getDen()
                        - ratio2.getNum()*ratio1.getDen();
        int denominator = ratio1.getDen() * ratio2.getDen();

        return new Rational(numerator, denominator);
    }

    public static Rational mult(Rational ratio1, Rational ratio2) {
        return new Rational(ratio1.getNum()*ratio2.getNum(),
                            ratio1.getDen()*ratio2.getDen());
    }

    public static Rational divide(Rational ratio1, Rational ratio2) {
        return new Rational(ratio1.getNum()*ratio2.getDen(),
                            ratio1.getDen()*ratio2.getNum());
    }

}
