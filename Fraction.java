
package funjavaprojects;

/**
 * An instance of this class represents a fraction. 
 * 
 * @author Alberto Fernandez Saucedo
 */
public class Fraction {
    
    /** the numerator of this fraction */
    private int numerator;
    
    /** the denominator of this fraction */
    private int denominator;
    
    /**
     * Creates a 0/1 fraction
     */
    public Fraction(){
        setNumerator(0);
        setDenominator(1);
    }
    
    /**
     * Creates a number/1 fraction
     * 
     * @param number the numerator
     */
    public Fraction(int number){ 
        setNumerator(number);
        setDenominator(1);
    }
    
    /**
     * Create a copy of frac
     * 
     * @param frac a copy of this parameter is created
     */
    public Fraction(Fraction frac){ // copy constructor
        setNumerator(frac.getNumerator());
        setDenominator(frac.getDenominator());
    }
    
    /**
     * Creates a fraction num/denom. Create a negative
     * fraction as -num and denom. Zero is represented as 0/1
     * such as when num is zero, denom is set to 1. 
     * 
     * @param num the numerator
     * @param denom the denominator
     */
    public Fraction(int num, int denom){
        if (denom < 0){
            num = -num;
            denom = -denom;
        }
        if(num == 0){
            denom = 1;
        }
        setNumerator(num);
        setDenominator(denom);
        
    }
    
    /**
     * Returns the greatest common divisor of the paraments m and n
     * 
     * @param m the first number
     * @param n the second number
     * @return the greatest common divisor of m and n
     */
    public static int gcd(int m, int n){
        int r = n % m;
        
        while (r != 0){
            n = m;
            m = r;
            r = n % m;
        }
        return m;
    }
    
    /**
     * Returns the smallest of the two parameters f1 and f2
     * 
     * @param f1 the first fraction 
     * @param f2 the second fraction 
     * @return the smaller of the two parameters
     */
    public static Fraction min(Fraction f1, Fraction f2){
        
        // convert to decimals and compare 
        double f1_dec = f1.decimal();
        double f2_dec = f1.decimal();
        
        if (f1_dec <= f2_dec){
            return f1;
        }else{
            return f2;
        }
    }
    
    private double decimal(){
        return (double) getNumerator() / getDenominator();
    }
    
    public int getDenominator(){
        return denominator;
    }
    
    public int getNumerator(){
        return numerator;
    }
    
    public void setDenominator(int denom){
        if (denom == 0){
            System.err.println("Fatal Error");
            System.exit(1);
        }
        denominator = denom;
    }
    
    public void setNumerator(int num){
        numerator = num;
    }
    
    @Override
    public String toString(){
        return getNumerator() + "/" + getDenominator();
    }
    
    public Fraction add(Fraction frac){
        
        int a, b, c, d;
        Fraction sum;
        
        a = this.getNumerator();
        b = this.getDenominator();
        
        c = frac.getNumerator();
        d = frac.getDenominator();
        
        sum = new Fraction(a*b + b*c, b*d);
        
        return sum;
        
    }
    
    public Fraction add(int number){
        
        Fraction frac = new Fraction (number, 1);
        Fraction sum = add(frac);
        return sum;
    }
    
    public Fraction divide(Fraction frac){
        
        int a, b, c, d;
        Fraction quotient;
        
        a = this.getNumerator();
        b = this.getDenominator();
        c = frac.getNumerator();
        d = frac.getDenominator();
        
        quotient = new Fraction (a*d, b*c);
        
        return quotient;
        
    }
    
    public Fraction divide(int number){
        Fraction frac = new Fraction(number, 1);
        Fraction quotient = divide(frac);
        return quotient;
    }
    
    public Fraction subtract(Fraction frac){
        
        int a, b, c, d;
        Fraction sub;
        
        a = this.getNumerator();
        b = this.getDenominator();
        c = frac.getNumerator();
        d = frac.getDenominator();
        
        sub = new Fraction(a*d - b*c, b*d);
        
        return sub;
    }
    
    public Fraction subtract(int number){
        Fraction frac = new Fraction(number, 1);
        Fraction sub = subtract(frac);
        return sub;
    }
    
    public Fraction multiply(Fraction frac){
        
        int a, b, c, d;
        Fraction mult;
        
        a = this.getNumerator();
        b = this.getDenominator();
        c = frac.getNumerator();
        d = frac.getDenominator();
        
        mult = new Fraction(a*c, b*d);
        
        return mult;
        
    }
    
    public Fraction multiply(int number){
        Fraction frac = new Fraction(number, 1);
        Fraction mult = multiply(frac);
        return mult;
    }
    
    public Fraction simplify(){
        int num = getNumerator();
        int denom = getDenominator();
        
        int divisor = 1;
        
        if (num != 0){
            divisor = gcd(Math.abs(num), denom);
        }
        return new Fraction(num/divisor, denom/divisor);
    }
}
