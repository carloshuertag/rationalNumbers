import java.util.Random;

/**
 * The Rational class to the rational numbers.
 * @version 1, 29/10/20
 * @author Carlos Huerta García
 */
public class Rational {

    public int numerator, denominator;

    /** 
     * Constructs a new rational number with numerator and denominator 1.
     */
    public Rational() {
        numerator = denominator = 1;
    }

    /** 
     * Constructs a new rational number with random numerator and denominator.
     * @param random Instance of java.util.Random class.
     */
    public Rational(Random random) {
        numerator = random.nextInt(9 - 1 + 1) + 1;
        denominator = random.nextInt(9 - 1 + 1) + 1;
    }

    /** 
     * Constructs a new rational number with given integers numerator and denominator.
     * @param numerator Integer numerator.
     * @param denominator Integer denominator diffrent from zero.
     */
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if(denominator == 0)
            denominator = 1;
        this.denominator = denominator;
    }

    /** 
     * Sets this rational number attributes with given integers numerator and denominator.
     * @param numerator Integer numerator.
     * @param denominator Integer denominator diffrent from zero.
     */
    public void setRational(int numerator, int denominator) {
        this.numerator = numerator;
        if(denominator == 0)
            denominator = 1;
        this.denominator = denominator;
    }

    /** 
     * Returns lcm of two given integers a and b.
     * @param numerator Integer a.
     * @param denominator Integer b.
     * @return the lcm of a and b.
     */
    private int lcm(int n1, int n2) {
        int mcm = n1 > n2 ? n1 : n2;
        while(mcm % n1 != 0 || mcm % n2 != 0)
            mcm++;
        return mcm;
    }

    /** 
     * Recursive method to return gcd of two given integers a and b.
     * @param numerator Integer a.
     * @param denominator Integer b.
     * @return the gcd of a and b.
     */
    private int gcd(int a, int b) {
        if (b == 0 || a == 0)
            return a;
        return gcd(b, a % b); 
    }

    /** 
     * Reduces this rational number to the minimum rational number.
     */
    public void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    /** 
     * Reduces this rational number to the minimum rational number.
     * @return this rational numbber reduced to the minimum rational number.
     */
    public Rational reduced() {
        reduce();
        return this;
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
