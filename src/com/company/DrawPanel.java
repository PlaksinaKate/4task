/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

import com.company.draw.IDrawer;
import com.company.draw.Shadow;
import com.company.draw.SimpleEdgeDrawer;
import com.company.math.Vector3;
import com.company.models.*;
import com.company.models.Point;
import com.company.screen.ScreenConverter;
import com.company.screen.ScreenPoint;
import com.company.third.Camera;
import com.company.third.Scene;

import static java.lang.Math.sqrt;

/**
 * @author Alexey
 */
public class DrawPanel extends JPanel
        implements CameraController.RepaintListener {
    private Scene scene;
    private ScreenConverter sc;
    private Camera cam;
    private CameraController camController;
    private Plane plane = new Plane(0.5f, 0.6f, 0.7f, 0.1f);
    private LinkedList<ScreenPoint> lightSource = new LinkedList<>();

    public DrawPanel() {
        sc = new ScreenConverter(-1, 1, 2, 2, 1, 1);
        cam = new Camera();
        camController = new CameraController(cam, sc);
        scene = new Scene(Color.BLACK.getRGB());
        scene.showAxes();
        camController.addRepaintListener(this);
        addMouseListener(camController);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    ScreenPoint screenPoint = new ScreenPoint(e.getX(), e.getY());
                    Vector3 vector3 = sc.s2r(screenPoint);
                    BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D graphics = (Graphics2D) bi.getGraphics();
                    if (!lightSource.isEmpty()) {
                        lightSource.remove(0);
                    }
                    lightSource.add(screenPoint);
                    shouldRepaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        addMouseMotionListener(camController);
        addMouseWheelListener(camController);
    }

    public void setTetrahedron() {
        if (!scene.getModelsList().isEmpty())
            scene.getModelsList().remove(0);
        scene.getModelsList().add(new Tetrahedron(new Vector3(0, 1, 0), (float) sqrt(1.5)));
        repaint();
    }

    public void setParallelepiped() {
        if (!scene.getModelsList().isEmpty())
            scene.getModelsList().remove(0);
        scene.getModelsList().add(new Parallelepiped(new Vector3(-0.4f, 0.4f, -0.4f),
                new Vector3(0.4f, -0.4f, 0.4f)));
        repaint();
    }

    public void setOctahedron() {
        if (!scene.getModelsList().isEmpty())
            scene.getModelsList().remove(0);
        scene.getModelsList().add(new Octahedron(new Vector3(0, 0, 0), 0.8f));
        repaint();
    }

    public void setIcosahedron() {
        if (!scene.getModelsList().isEmpty())
            scene.getModelsList().remove(0);
        scene.getModelsList().add(new Icosahedron(new Vector3(0, 0, 0), 0.4f));
        repaint();
    }

    public void setDodecahedron() {
        if (!scene.getModelsList().isEmpty())
            scene.getModelsList().remove(0);
        scene.getModelsList().add(new Dodecahedron(new Vector3(0, 0, 0), 0.4f));
        repaint();
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
        shouldRepaint();
    }


    @Override
    public void paint(Graphics g) {
        sc.setScreenSize(getWidth(), getHeight());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) bi.getGraphics();
        IDrawer dr = new SimpleEdgeDrawer(sc, graphics);
        Shadow shadowDrawer = new Shadow(sc, graphics);
        try {
            scene.drawScene(dr, cam);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!lightSource.isEmpty()) {
            Vector3 light = sc.s2r(lightSource.get(0));
            scene.drawScene(cam, plane, light, shadowDrawer);
        }

        g.drawImage(bi, 0, 0, null);
        graphics.dispose();
    }

    @Override
    public void shouldRepaint() {
        repaint();
    }
}
