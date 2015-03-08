public class Solution {
//solution1
    public double pow(double x, int n) {
        if (n == 0)
            return 1.0;
        
        double res = 1.0;
        if (n < 0) {
            if (x <= 1 / Double.MIN_VALUE || x >= 1 / Double.MAX_VALUE) {
                x = 1.0 / x;
            }
            else {
                return Double.MAX_VALUE;
            }
            
            if (n == Double.MIN_VALUE) {
                res *= x;
                n += 1;
            }
        }
        boolean isNeg = x < 0 && n % 2 == 1 ? true : false;
        
        x = Math.abs(x);
        n = Math.abs(n);
        
        while (n > 0) {
            if ((n & 1) == 1) {
                if (res > Double.MAX_VALUE / x)
                    return isNeg ? Double.MIN_VALUE : Double.MAX_VALUE;
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return isNeg ? (-1) * res : res;
    }
  //solution2:
    public double pow_binary(double x, int n) {
        if (n == 0)
            return 1.0;
        double half = pow_binary(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        else if (n > 0) {
            return half * half * x;
        }
        else {
            return (half * half) / x;
        }
    }
}
