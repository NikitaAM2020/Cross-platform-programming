public class PowerSeries {
    public static double powerSeriesArcctg(double x, double eps) {
        if (x > 1) {
            return Math.atan(1 / x);
        }
        if (x < -1) {
            return Math.PI - Math.atan(1 / x);
        }

        double result = 0.0;
        double term = x;

        int i = 1;
        while (Math.abs(term) > eps) {
            result += term;
            term = -1 * term * x * x * (2 * i - 1) / (2 * i + 1);
            i++;
        }
        return Math.PI / 2 - result;
    }
}
