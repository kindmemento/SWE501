import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class FunctionPlotter {
    public static void plotFunction(double xMin, double xMax, double stepSize, Function<Double, Double> function) {
        ArrayList<Double> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();

        double x = xMin;
        while (x <= xMax) {
            xValues.add(x);
            double y = function.apply(x);
            yValues.add(y);
            x += stepSize;
        }

        double yMin = Collections.min(yValues);
        double yMax = Collections.max(yValues);

        int canvas_width = 800;
        int canvas_height = (int) ((canvas_width * (yMax - yMin)) / (xMax - xMin));

        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setCanvasSize(canvas_width, canvas_height);
        StdDraw.setXscale(xMin, xMax);
        StdDraw.setYscale(yMin, yMax);
        StdDraw.enableDoubleBuffering();

        StdDraw.line(xMin, 0, xMax, 0);
        StdDraw.line(0, yMin, 0, yMax);

        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        for (int i = 0; i < xValues.size(); i++) {
            StdDraw.filledCircle(xValues.get(i), yValues.get(i), 0.03);
        }

        System.out.println("Program Finished");
        StdDraw.show();
    }
}