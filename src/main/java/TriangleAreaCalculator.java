public class TriangleAreaCalculator {
    public static double calculateArea(int a, int b, int c) throws TriangleAreaCalculationException {
        if (!isPositive(a, b, c)) {
            throw new IncorrectSideSizeException();
        }
        if (!isTriangleExists(a, b, c)) {
            throw new NotExistsException();
        }
        double sum = a + b + c;
        double semiPerimeter = sum / 2.0;
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    private static boolean isPositive(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0;
    }

    private static boolean isTriangleExists(int a, int b, int c) {
        if (a + b <= c) {
            return false;
        } else if (a + c <= b) {
            return false;
        } else return b + c > a;
    }
}
