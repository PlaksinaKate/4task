package com.company.models;

import com.company.math.Vector3;
import com.company.third.IModel;
import com.company.third.PolyLine3D;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Dodecahedron implements IModel {

    public Dodecahedron() {
    }

    @Override
    public List<PolyLine3D> getLines() {
        LinkedList<PolyLine3D> lines = new LinkedList<>();
        Vector3[] vector3s = Vertex.getDodecahedron();
        for (int i = 4; i < vector3s.length; i += 5) {
            lines.add(new PolyLine3D(Arrays.asList(
                    new Vector3[]{vector3s[i - 4], vector3s[i - 3], vector3s[i - 2], vector3s[i - 1], vector3s[i]}),
                    true));
        }
        return lines;
    }
}
