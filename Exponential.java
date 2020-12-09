public class Exponential {

    public double exp(double number, int exp) {
        if(number == 0 && exp < 0) throw new ArithmeticException();

        if(exp == 0) return 1;

        if(exp > 0) {
            return number * exp(number, --exp);
        }else {
            return 1/number * exp(number, ++exp);
        }
    }
}
