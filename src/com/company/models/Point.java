package com.company.models;

import com.company.math.Vector3;
import com.company.third.IModel;
import com.company.third.PolyLine3D;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Point implements IModel {
    private Vector3 CP;

    /**
     * Создаёт экземпляр однопиксельного параллелипипеда
     *
     * @param CP Левая Верхняя Дальняя точка (Central Point)
     */
    public Point(Vector3 CP) {
        this.CP = CP;
    }


    @Override
    public List<PolyLine3D> getLines() throws IOException {
        LinkedList<PolyLine3D> lines = new LinkedList<>();
        /*Дальняя сторона (Z фиксирован и вязт у LTF)*/
        lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
                new Vector3(CP.getX() - 0.01f, CP.getY() + 0.01f, CP.getZ() + 0.01f),
                new Vector3(CP.getX() - 0.01f, CP.getY() + 0.01f, CP.getZ() - 0.01f),
                new Vector3(CP.getX() + 0.01f, CP.getY() + 0.01f, CP.getZ() - 0.01f),
                new Vector3(CP.getX() + 0.01f, CP.getY() + 0.01f, CP.getZ() + 0.01f)
        }), true));
        /*Ближняя сторона  (Z фиксирован и вязт у RBN)*/
        lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
                new Vector3(CP.getX() + 0.01f, CP.getY() + 0.01f, CP.getZ() + 0.01f),
                new Vector3(CP.getX() + 0.01f, CP.getY() + 0.01f, CP.getZ() - 0.01f),
                new Vector3(CP.getX() + 0.01f, CP.getY() - 0.01f, CP.getZ() - 0.01f),
                new Vector3(CP.getX() + 0.01f, CP.getY() - 0.01f, CP.getZ() + 0.01f)
        }), true));

        /*Верхняя сторона (Y фиксирован и вязт у LTF)*/
        lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
                new Vector3(CP.getX() - 0.01f, CP.getY() + 0.01f, CP.getZ() + 0.01f),
                new Vector3(CP.getX() + 0.01f, CP.getY() + 0.01f, CP.getZ() + 0.01f),
                new Vector3(CP.getX() + 0.01f, CP.getY() - 0.01f, CP.getZ() + 0.01f),
                new Vector3(CP.getX() - 0.01f, CP.getY() - 0.01f, CP.getZ() + 0.01f)
        }), true));
        /*Нижняя сторона (Y фиксирован и вязт у RBN)*/
        lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
                new Vector3(CP.getX() - 0.01f, CP.getY() + 0.01f, CP.getZ() + 0.01f),
                new Vector3(CP.getX() - 0.01f, CP.getY() + 0.01f, CP.getZ() - 0.01f),
                new Vector3(CP.getX() - 0.01f, CP.getY() - 0.01f, CP.getZ() - 0.01f),
                new Vector3(CP.getX() - 0.01f, CP.getY() - 0.01f, CP.getZ() + 0.01f)
        }), true));

        /*Левая сторона (X фиксирован и вязт у LTF)*/
        lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
                new Vector3(CP.getX() - 0.01f, CP.getY() + 0.01f, CP.getZ() - 0.01f),
                new Vector3(CP.getX() + 0.01f, CP.getY() + 0.01f, CP.getZ() - 0.01f),
                new Vector3(CP.getX() + 0.01f, CP.getY() - 0.01f, CP.getZ() - 0.01f),
                new Vector3(CP.getX() - 0.01f, CP.getY() - 0.01f, CP.getZ() - 0.01f)
        }), true));
        /*Правая сторона (X фиксирован и вязт у RBN)*/
        lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
                new Vector3(CP.getX() - 0.01f, CP.getY() - 0.01f, CP.getZ() + 0.01f),
                new Vector3(CP.getX() - 0.01f, CP.getY() - 0.01f, CP.getZ() - 0.01f),
                new Vector3(CP.getX() + 0.01f, CP.getY() - 0.01f, CP.getZ() - 0.01f),
                new Vector3(CP.getX() + 0.01f, CP.getY() - 0.01f, CP.getZ() + 0.01f)
        }), true));

        return lines;
    }
}
