import java.util.Scanner; // Scanner class is imported to read input from the user through the Standard Input

public class RootFinder {
    private static final double EPSILON = 1e-6; // Tolerance for root approximation

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter double numbers a and b:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        double root = findRoot(a, b);
        if (root == Double.MAX_VALUE) {
            System.out.println("Root cannot be found by the Bisection Method. Trying the Secant Method.");
            root = secantMethod(a, b);
        }

        if (root != Double.MAX_VALUE) {
            System.out.printf("Root: %.3f ", root);
            System.out.println((root == findRoot(a, b)) ? "(Bisection Method)" : "(Secant Method)");
        } else {
            System.out.println("Root cannot be found by either method.");
        }
    }

    private static double findRoot(double a, double b) {
        double c = a;
        while ((b - a) >= EPSILON) {
            c = (a + b) / 2;
            if (computeFunction(c) == 0.0) {
                return c;
            } else if (computeFunction(c) * computeFunction(a) < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        return Double.MAX_VALUE; // Root cannot be found inside the while loop, therefore the function return Double.MAX_VALUE to indicate failure.
    }

    private static double secantMethod(double x0, double x1) {
        double x2;
        do {
            x2 = (x0 * computeFunction(x1) - x1 * computeFunction(x0)) / (computeFunction(x1) - computeFunction(x0));
            x0 = x1;
            x1 = x2;
        } while (Math.abs(computeFunction(x2)) > EPSILON);
        return x2;
    }

    private static double computeFunction(double x) {
        return 0.1 * Math.pow(x, 3) + Math.pow(x, 2) - 6;
    }
}
