package by.bsu.at.triangleinequality.model.logic;

public class TriangleInequality {
    public static boolean isTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new IllegalArgumentException();
        double p = (a + b + c) / 2D;
        return p * (p - a) * (p - b) * (p - c) > 0;
    }
}
