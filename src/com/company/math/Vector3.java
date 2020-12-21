/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.math;

import static java.lang.Math.sqrt;

/**
 * Класс, хранящий трёхмерный вектор / точку в трёхмерном пространстве.
 * @author Alexey
 */
public class Vector3 {
    private float[] values; /*Значения хранятся в виде массива из трёх элементов*/
    
    /**
     * Создаёт экземпляр вектора на основе значений трёх составляющих
     * @param x первая составляющая, описывающая X-координату
     * @param y вторая составляющая, описывающая Y-координату
     * @param z третья составляющая, описывающая Z-координату
     */
    public Vector3(float x, float y, float z) {
        values = new float[]{x, y, z};
    }

    /**
     * X-составляющая вектора
     * @return X-составляющая вектора
     */
    public float getX() {
        return values[0];
    }

    /**
     * Y-составляющая вектора
     * @return Y-составляющая вектора
     */
    public float getY() {
        return values[1];
    }

    /**
     * Z-составляющая вектора
     * @return Z-составляющая вектора
     */
    public float getZ() {
        return values[2];
    }
    
    /**
     * Метод, возвращающий составляющую вектора по порядковому номеру
     * @param idx порядковый номер
     * @return значение составляющей вектора
     */
    public float at(int idx) {
        return values[idx];
    }
    
    private static final float EPSILON = 1e-10f;
    /**
     * Метод, возвращающий длину вектора
     * @return длина вектора
     */
    public float length() {
        float lenSqr = values[0] * values[0] + values[1] * values[1] + values[2] * values[2];
        if (lenSqr < EPSILON)
            return 0;
        return (float) sqrt(lenSqr);
    }

    public float distanceFromPoint(Vector3 point) {
        return (float) sqrt((getX() - point.getX()) * (getX() - point.getX()) + (getY() - point.getY()) * (getY() - point.getY()) +
                (getZ() - point.getZ()) * (getZ() - point.getZ()));
    }

}
