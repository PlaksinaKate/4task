/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

import com.company.CameraController;
import com.company.draw.IDrawer;
import com.company.draw.SimpleEdgeDrawer;
import com.company.math.Vector3;
import com.company.models.*;
import com.company.screen.ScreenConverter;
import com.company.third.Camera;
import com.company.third.Scene;

/**
 * @author Alexey
 */
public class DrawPanel extends JPanel
        implements CameraController.RepaintListener {
    private Scene scene;
    private ScreenConverter sc;
    private Camera cam;
    private CameraController camController;


    public DrawPanel() {
        JFrame frame = new JFrame();
        sc = new ScreenConverter(-1, 1, 2, 2, 1, 1);
        cam = new Camera();
        camController = new CameraController(cam, sc);
        scene = new Scene(Color.BLACK.getRGB());
        scene.showAxes();


//        scene.getModelsList().add(new Parallelepiped(
//                new Vector3(-0.4f, -0.4f, -0.4f),
//                new Vector3(0.4f, 0.4f, 0.4f)
//        ));
        // scene.getModelsList().add(new Tetrahedron());
        // scene.getModelsList().add(new Octahedron());
        //scene.getModelsList().add(new Icosahedron());

        //scene.getModelsList().add(new Dodecahedron());


//        scene.getModelsList().add(new Tetrahedron(
//                new Vector3(0.0f, 0.7f, 0.0f),
//                new Vector3(-0.4f, 0.0f, 0.4f)));

//        scene.getModelsList().add(new Octahedron(
//                new Vector3(0.0f, 0.7f, 0.0f),
//                new Vector3(-0.7f, 0.0f, 0.7f)));
//        scene.getModelsList().add(new Dodecahedron(
//                new Vector3(-0.4f, 0.8f, 0.4f),
//                new Vector3(-0.6f, 0.2f, 0.4f),
//                new Vector3(0.0f, -0.2f, 0.4f)));


        camController.addRepaintListener(this);
        addMouseListener(camController);
        addMouseMotionListener(camController);
        addMouseWheelListener(camController);
    }

    public void setTetrahedron() {
        if (!scene.getModelsList().isEmpty())
            scene.getModelsList().remove(0);
        scene.getModelsList().add(new Tetrahedron());
    }

    public void setParallelepiped() {
        if (!scene.getModelsList().isEmpty())
            scene.getModelsList().remove(0);
        scene.getModelsList().add(new Parallelepiped(
                new Vector3(-0.4f, -0.4f, -0.4f),
                new Vector3(0.4f, 0.4f, 0.4f)
        ));
        shouldRepaint();
    }

    public void setOctahedron() {
        if (!scene.getModelsList().isEmpty())
            scene.getModelsList().remove(0);
        scene.getModelsList().add(new Octahedron());
        shouldRepaint();
    }

    public void setIcosahedron() {
        if (!scene.getModelsList().isEmpty())
            scene.getModelsList().remove(0);
        scene.getModelsList().add(new Icosahedron());
        shouldRepaint();
    }

    public void setDodecahedron() {
        if (!scene.getModelsList().isEmpty())
            scene.getModelsList().remove(0);
        scene.getModelsList().add(new Dodecahedron());
        shouldRepaint();
    }


    @Override
    public void paint(Graphics g) {
        sc.setScreenSize(getWidth(), getHeight());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) bi.getGraphics();
        IDrawer dr = new SimpleEdgeDrawer(sc, graphics);

        try {
            scene.drawScene(dr, cam);
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(bi, 0, 0, null);
        graphics.dispose();
    }

    @Override
    public void shouldRepaint() {
        repaint();
    }
}
