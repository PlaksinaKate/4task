package com.company.models;

import com.company.math.Vector3;
import com.company.third.IModel;
import com.company.third.PolyLine3D;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Octahedron implements IModel {
//    /**
//     * Создаёт экземпляр тетраэдра
//     *
//     * @param TF  Верхняя точка (Top Far)
//     * @param LBN Левая Нижняя Ближняя точка (Right Bottom Near)
//     */
    public Octahedron() {

    }

    @Override
    public List<PolyLine3D> getLines() throws IOException {
        LinkedList<PolyLine3D> lines = new LinkedList<>();
        Vector3[] vector3s = Vertex.getOctahedron();
        for (int i = 2; i < vector3s.length; i += 3) {
            lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
                    vector3s[i - 2], vector3s[i - 1], vector3s[i]
            }), true));
        }

        return lines;
    }
}
