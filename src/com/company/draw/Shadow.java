package com.company.draw;

import com.company.exceptions.ParallelPlaneLine;
import com.company.math.Vector3;
import com.company.models.Line3D;
import com.company.models.Plane;
import com.company.screen.ScreenConverter;
import com.company.screen.ScreenCoordinates;
import com.company.screen.ScreenPoint;
import com.company.third.IModel;
import com.company.third.PolyLine3D;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import static java.lang.Math.abs;

public class Shadow extends ScreenGraphicsDrawer {

    /**
     * Создаёт экземпляр рисвальщика
     *
     * @param sc преобразователь координат
     * @param gr графикс
     */
    public Shadow(ScreenConverter sc, Graphics2D gr) {
        super(sc, gr);
    }

    public LinkedList<PolyLine3D> shadows(IModel model, Plane plane, Vector3 lightSource) {
        LinkedList<PolyLine3D> lines = null;
        try {
            lines = (LinkedList<PolyLine3D>) model.getLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinkedList<PolyLine3D> shadowLines = new LinkedList<>();

        for (PolyLine3D line : lines) {
            LinkedList<Vector3> shadowPoints = new LinkedList<>();
            for (Vector3 point : line.getPoints()) {
                try {
                    Vector3 projection = new Line3D(point, lightSource).getIntersectionWithPlane(plane);
                    if (projection.distanceFromPoint(lightSource) < projection.distanceFromPoint(point) ||
                            lightSource.distanceFromPoint(projection) < lightSource.distanceFromPoint(point)) {
                        continue;
                    }
                    shadowPoints.add(projection);
                    shadowLines.addFirst(new PolyLine3D(Arrays.asList(lightSource, projection), false));
                } catch (ParallelPlaneLine e) {
                    continue;
                }
            }
            shadowLines.add(new PolyLine3D(shadowPoints, true));
        }
        return shadowLines;
    }

    @Override
    protected void oneDraw(PolyLine3D polyline) {
        LinkedList<ScreenPoint> points = new LinkedList<>();
        /*переводим все точки в экранные*/
        for (Vector3 v : polyline.getPoints())
            points.add(getScreenConverter().r2s(v));
        getGraphics().setColor(new Color(255, 212, 87));
        /*если точек меньше двух, то рисуем отдельными алгоритмами*/
        if (points.size() < 2) {
            if (points.size() > 0)
                getGraphics().fillRect(points.get(0).getI(), points.get(0).getJ(), 1, 1);
            return;
        }
        /*создаём хранилище этих точек в виде двух массивов*/
        ScreenCoordinates crds = new ScreenCoordinates(points);
        /*если линия замкнута - рисем полиго, иначе - полилинию*/
        if (polyline.isClosed()) {
            getGraphics().fillPolygon(crds.getXx(), crds.getYy(), crds.size());
        } else {
            getGraphics().setColor(Color.YELLOW);
            getGraphics().drawPolyline(crds.getXx(), crds.getYy(), crds.size());
        }
    }

    @Override
    protected IFilter<PolyLine3D> getFilter() {
        return new IFilter<PolyLine3D>() {
            @Override
            public boolean permit(PolyLine3D value) {
                return true;
            }
        };
    }

    @Override
    protected Comparator<PolyLine3D> getComparator() {
        return new Comparator<PolyLine3D>() {
            @Override
            public int compare(PolyLine3D polyLine3D, PolyLine3D t1) {
                return 0;
            }
        };
    }
}
