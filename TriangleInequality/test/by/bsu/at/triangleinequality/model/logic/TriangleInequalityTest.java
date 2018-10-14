package by.bsu.at.triangleinequality.model.logic;

import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class TriangleInequalityTest {

    @Test
    public void isTriangleTest() {
        double a = 3, b = 4, c = 5;
        assertTrue(TriangleInequality.isTriangle(a, b, c));
    }

    @Test
    public void isTriangleTestFail() {
        double a = 3, b = 4, c = 1;
        assertFalse(TriangleInequality.isTriangle(a, b, c));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void isTriangleTestNegativeSide() {
        double a = -3, b = 4, c = 5;
        TriangleInequality.isTriangle(a, b, c);
    }

    @Test
    public void isTriangleTest0() {
        double a = 12, b = 23, c = 12;
        assertTrue(TriangleInequality.isTriangle(a, b, c));
    }

    @Test
    public void isTriangleTest1() {
        double a = 5, b = 12, c = 13;
        assertTrue(TriangleInequality.isTriangle(a, b, c));
    }

    @Test
    public void isTriangleTest2() {
        double a = 6, b = 6, c = 6;
        assertTrue(TriangleInequality.isTriangle(a, b, c));
    }

    @Test
    public void isTriangleTestFail0() {
        double a = 1, b = 1, c = 20;
        assertFalse(TriangleInequality.isTriangle(a, b, c));
    }

    @Test
    public void isTriangleTestFail1() {
        double a = 3, b = 8, c = 3;
        assertFalse(TriangleInequality.isTriangle(a, b, c));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void isTriangleTestNegativeSide0() {
        double a = 3, b = 4, c = -5;
        TriangleInequality.isTriangle(a, b, c);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void isTriangleTestNegativeSide1() {
        double a = 3, b = -4, c = 5;
        TriangleInequality.isTriangle(a, b, c);
    }
}
