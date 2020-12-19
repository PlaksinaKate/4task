/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.models;

import java.util.Arrays;
import java.util.List;

import com.company.exceptions.Matrix3Exceptions;
import com.company.exceptions.ParallelPlaneLine;
import com.company.math.Matrix3;
import com.company.math.Vector3;
import com.company.third.IModel;
import com.company.third.PolyLine3D;

import static java.lang.Math.abs;

/**
 * Описывает трёхмерный отрезок
 *
 * @author Alexey
 */
public class Line3D implements IModel {
    private Vector3 p1, p2;
    private static final float EPSILON = 1e-10f;

    public Line3D(Vector3 p1, Vector3 p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public List<PolyLine3D> getLines() {
        return Arrays.asList(new PolyLine3D(
                Arrays.asList(p1, p2)
                , false));
    }

    public Vector3 getIntersectionWithPlane(Plane plane) throws ParallelPlaneLine {
        float x0 = p1.getX();
        float n = p2.getX() - p1.getX();
        float y0 = p1.getY();
        float m = p2.getY() - p1.getY();
        float z0 = p1.getZ();
        float l = p2.getZ() - p1.getZ();

        Matrix3 matrix;
        Vector3 vector;
        if (abs(m) > EPSILON) {
            matrix = new Matrix3(new float[][]{
                    {m, -n, 0},
                    {0, l, -m},
                    {plane.getA(), plane.getB(), plane.getC()}});
            vector = new Vector3(m * x0 - n * y0, l * y0 - m * z0, -plane.getD());
        } else if (abs(n) > EPSILON) {
            matrix = new Matrix3(new float[][]{
                    {m, -n, 0},
                    {l, 0, -n},
                    {plane.getA(), plane.getB(), plane.getC()}});
            vector = new Vector3(m * x0 - n * y0, l * x0 - n * z0, -plane.getD());
        } else {
            matrix = new Matrix3(new float[][]{
                    {l, -n, 0},
                    {0, l, -m},
                    {plane.getA(), plane.getB(), plane.getC()}});
            vector = new Vector3(l * x0 - n * z0, l * y0 - m * z0, -plane.getD());
        }
        try {
            return matrix.systemSolution(vector);
        } catch (Matrix3Exceptions e) {
            throw new ParallelPlaneLine("Линия параллельна плоскости!");
        }

    }

}
