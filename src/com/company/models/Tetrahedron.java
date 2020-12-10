package com.company.models;

import com.company.math.Vector3;
import com.company.third.IModel;
import com.company.third.PolyLine3D;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tetrahedron implements IModel {
    private Vector3 TF, LBN;

//    /**
//     * Создаёт экземпляр тетраэдра
//     *
//     * @param TF  Верхняя точка (Top Far)
//     * @param LBN Левая Нижняя Ближняя точка (Left Bottom Near)
//     */
//    public Tetrahedron(Vector3 TF, Vector3 LBN) {
//        this.TF = TF;
//        this.LBN = LBN;
//    }


    public Tetrahedron() {
    }

    @Override
    public List<PolyLine3D> getLines() throws IOException {
        LinkedList<PolyLine3D> lines = new LinkedList<>();
        Vector3[] vector3s = Vertex.getTetrahedron();
        for (int i = 2; i < vector3s.length; i += 3) {
            lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
                    vector3s[i - 2], vector3s[i - 1], vector3s[i]
            }), true));
        }
//
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
//                new Vector3(TF.getX(), TF.getY(), TF.getZ()),
//                new Vector3(LBN.getX(), LBN.getY(), LBN.getZ()),
//                new Vector3(-LBN.getX(), LBN.getY(), LBN.getZ()),
//        }), true));
//
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
//                new Vector3(TF.getX(), TF.getY(), TF.getZ()),
//                new Vector3(-LBN.getX(), LBN.getY(), LBN.getZ()),
//                new Vector3(-LBN.getX() * 2 / 3, LBN.getY(), -LBN.getZ()),
//        }), true));
//
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
//                new Vector3(TF.getX(), TF.getY(), TF.getZ()),
//                new Vector3(LBN.getX(), LBN.getY(), LBN.getZ()),
//                new Vector3(-LBN.getX() * 2 / 3, LBN.getY(), -LBN.getZ()),
//        }), true));
//
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
//                new Vector3(LBN.getX(), LBN.getY(), LBN.getZ()),
//                new Vector3(-LBN.getX(), LBN.getY(), LBN.getZ()),
//                new Vector3(-LBN.getX() * 2 / 3, LBN.getY(), -LBN.getZ()),
//        }), true));
//

        return lines;
    }
}
