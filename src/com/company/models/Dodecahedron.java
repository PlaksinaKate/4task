package com.company.models;

import com.company.math.Vector3;
import com.company.third.IModel;
import com.company.third.PolyLine3D;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Dodecahedron implements IModel {
    private final Vector3 center;
    private final float radius;

    public Dodecahedron(Vector3 center, float radius) {
        this.center = center;
        this.radius = radius;
    }


    @Override
    public List<PolyLine3D> getLines() {
        LinkedList<PolyLine3D> lines = new LinkedList<>();

        float indent = 2 * radius / ((float) sqrt(10 - 2 * sqrt(5)));

        lines.add(new PolyLine3D(Arrays.asList(
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ())
                ).getCentre()

        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ())
                ).getCentre()

        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent)
                ).getCentre()
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent)
                ).getCentre()
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius)
                ).getCentre()
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius)
                ).getCentre()
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius)
                ).getCentre()
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent),
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius)
                ).getCentre()
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent)
                ).getCentre()
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() - indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() + indent, center.getY() + radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent)
                ).getCentre()
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent)
                ).getCentre()
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                        new Vector3(center.getX() - indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ())
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent)
                ).getCentre(),
                new TriangleForDodecahedron(
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent),
                        new Vector3(center.getX() + indent, center.getY() - radius, center.getZ()),
                        new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent)
                ).getCentre()
        ), true));
        return lines;
    }
}
