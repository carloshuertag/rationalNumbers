import java.util.Random;

public class Rational {

    private int numerator, denominator;

    public Rational() {
    }

    public Rational(Random random) {
        numerator = random.nextInt(9);
        denominator = random.nextInt(9 - 1 + 1) + 1;
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if(denominator == 0)
            denominator = 1;
        this.denominator = denominator;
    }

    public void setRational(int numerator, int denominator) {
        this.numerator = numerator;
        if(denominator == 0)
            denominator = 1;
        this.denominator = denominator;
    }

    private int lcm(int n1, int n2) {
        int mcm = n1 > n2 ? n1 : n2;
        while(mcm % n1 != 0 || mcm % n2 != 0)
            mcm++;
        return mcm;
    }

    private int gcd(int a, int b) {
        if (a == 0)
          return b;
        if (b == 0)
          return a;
        if (a == b)
            return a;
        return a > b ? gcd(a - b, b) : gcd(a, b - a);
    }

    public void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public void add(Rational r) {
        numerator = (lcm(denominator, r.denominator) / denominator) * numerator + (lcm(denominator, r.denominator) / r.denominator) * r.numerator;
        denominator = lcm(denominator, r.denominator);
    }

    public Rational addition(Rational r) {
        return new Rational((lcm(denominator, r.denominator) / denominator) * numerator + (lcm(denominator, r.denominator) / r.denominator) * r.numerator, lcm(denominator, r.denominator));
    }

    public Rational addition(Rational r1, Rational r2) {
        return new Rational((lcm(r1.denominator, r2.denominator) / r1.denominator) * r1.numerator + (lcm(r1.denominator, r2.denominator) / r2.denominator) * r2.numerator, lcm(r1.denominator, r2.denominator));
    }

    public void sub(Rational r) {
        numerator = (lcm(denominator, r.denominator) / denominator) * numerator - (lcm(denominator, r.denominator) / r.denominator) * r.numerator;
        denominator = lcm(denominator, r.denominator);
    }

    public Rational subtraction(Rational r){
        return new Rational((lcm(denominator, r.denominator) / denominator) * numerator - (lcm(denominator, r.denominator) / r.denominator) * r.numerator, lcm(denominator, r.denominator));
    }

    public Rational subtraction(Rational r1, Rational r2){
        return new Rational((lcm(r1.denominator, r2.denominator) / r1.denominator) * r1.numerator - (lcm(r1.denominator, r2.denominator) / r2.denominator) * r2.numerator, lcm(r1.denominator, r2.denominator));
    }

    public void mult(Rational r){
        numerator *= r.numerator;
        denominator *= r.denominator;
    }

    public Rational multiplication(Rational r){
        return new Rational(numerator * r.numerator, denominator * r.denominator);
    }

    public Rational multiplication(Rational r1, Rational r2){
        return new Rational(r1.numerator * r2.numerator, r1.denominator * r2.denominator);
    }

    public void div(Rational r){
        numerator *= r.denominator;
        denominator *= r.numerator;
    }

    public Rational division(Rational r){
        return new Rational(numerator * r.denominator, denominator * r.numerator);
    }

    public Rational division(Rational r1, Rational r2){
        return new Rational(r1.numerator * r2.denominator, r1.denominator * r2.numerator);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Rational){
            Rational r = (Rational) obj;
            if(r.numerator == this.numerator && r.denominator == this.denominator)
                return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return numerator + "/" + denominator;
    }

    public void print(){
        System.out.print("{" + this + "}\n");
    }

}
