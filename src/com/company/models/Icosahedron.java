package com.company.models;

import com.company.math.Vector3;
import com.company.third.IModel;
import com.company.third.PolyLine3D;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Icosahedron implements IModel {
    private final Vector3 c;
    private final float r;

    public Icosahedron(Vector3 c, float r) {
        this.c = c;
        this.r = r;
    }

    @Override
    public List<PolyLine3D> getLines(){
        LinkedList<PolyLine3D> lines = new LinkedList<>();
        float indent = 2 * r / ( (float) sqrt(10 - 2 * sqrt(5)));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(c.getX(), c.getY() + indent, c.getZ() + r),
                new Vector3(c.getX() - indent, c.getY() + r, c.getZ() ),
                new Vector3(c.getX() + indent, c.getY() + r, c.getZ() )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(c.getX(), c.getY() + indent, c.getZ() + r),
                new Vector3(c.getX(), c.getY() - indent, c.getZ() + r),
                new Vector3(c.getX() + r, c.getY(), c.getZ()  + indent)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(c.getX(), c.getY() - indent, c.getZ() + r),
                new Vector3(c.getX() - r, c.getY(), c.getZ()  + indent),
                new Vector3(c.getX(), c.getY() + indent, c.getZ() + r)
        ), false));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(c.getX(), c.getY() - indent, c.getZ() + r),
                new Vector3(c.getX() - indent, c.getY() - r, c.getZ() ),
                new Vector3(c.getX() + indent, c.getY() - r, c.getZ() )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(c.getX() - indent, c.getY() + r, c.getZ() ),
                new Vector3(c.getX(), c.getY() + indent, c.getZ() - r),
                new Vector3(c.getX() + indent, c.getY() + r, c.getZ() )
        ), false));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(c.getX() - indent, c.getY() - r, c.getZ() ),
                new Vector3(c.getX(), c.getY() - indent, c.getZ() - r),
                new Vector3(c.getX() + indent, c.getY() - r, c.getZ() )
        ), false));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(c.getX(), c.getY() + indent, c.getZ() - r),
                new Vector3(c.getX(), c.getY() - indent, c.getZ() - r),
                new Vector3(c.getX() + r, c.getY(), c.getZ()  - indent)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(c.getX(), c.getY() - indent, c.getZ() - r),
                new Vector3(c.getX() - r, c.getY(), c.getZ()  - indent),
                new Vector3(c.getX(), c.getY() + indent, c.getZ() - r)
        ), false));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(c.getX() + r, c.getY(), c.getZ() + indent),
                new Vector3(c.getX() + r, c.getY(), c.getZ()  - indent),
                new Vector3(c.getX() + indent, c.getY() + r, c.getZ())
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(c.getX() - r, c.getY(), c.getZ() + indent),
                new Vector3(c.getX() - r, c.getY(), c.getZ()  - indent),
                new Vector3(c.getX() - indent, c.getY() + r, c.getZ())
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(c.getX() + r, c.getY(), c.getZ() + indent),
                new Vector3(c.getX() + indent, c.getY() - r, c.getZ()),
                new Vector3(c.getX() + r, c.getY(), c.getZ()  - indent)
        ), false));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(c.getX() - r, c.getY(), c.getZ() + indent),
                new Vector3(c.getX() - indent, c.getY() - r, c.getZ()),
                new Vector3(c.getX() - r, c.getY(), c.getZ()  - indent)
        ), false));

        return lines;
    }
}
