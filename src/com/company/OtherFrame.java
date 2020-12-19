package com.company;

import com.company.math.Vector3;
import com.company.models.Plane;
import com.company.third.PolyLine3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Double.MAX_VALUE;

public class OtherFrame extends JFrame {


    OtherFrame() throws HeadlessException {
        this.setTitle("Плоскость для тени");
        this.setLocation(500, 400);
        JLabel A = new JLabel("A");
        A.setBounds(10, 0, 100, 40);
        this.add(A);
        JSpinner spinnerA = new JSpinner(new SpinnerNumberModel(0.1f, 0.0f, MAX_VALUE, 0.1f));
        spinnerA.setBounds(50, 0, 100, 30);
        this.add(spinnerA);

        JLabel B = new JLabel("B");
        B.setBounds(10, 35, 100, 30);
        this.add(B);
        JSpinner spinnerB = new JSpinner(new SpinnerNumberModel(0.1f, 0.0f, MAX_VALUE, 0.1f));
        spinnerB.setBounds(50, 35, 100, 30);
        this.add(spinnerB);

        JLabel C = new JLabel("C");
        C.setBounds(10, 70, 100, 30);
        this.add(C);
        JSpinner spinnerC = new JSpinner(new SpinnerNumberModel(0.1f, 0.0f, MAX_VALUE, 0.1f));
        spinnerC.setBounds(50, 70, 100, 30);
        this.add(spinnerC);

        JLabel D = new JLabel("D");
        D.setBounds(10, 105, 100, 40);
        this.add(D);
        JSpinner spinnerD = new JSpinner(new SpinnerNumberModel(0.5f, 0.0f, MAX_VALUE, 0.1f));
        spinnerD.setBounds(50, 105, 100, 40);
        this.add(spinnerD);

        JButton b = new JButton();
        b.setText("Отрисовать плоскость");
        b.setBounds(0, 150, 300, 50);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                float parA = Float.parseFloat(spinnerA.getValue().toString());
                float parB = Float.parseFloat(spinnerB.getValue().toString());
                float parC = Float.parseFloat(spinnerC.getValue().toString());
                float parD = Float.parseFloat(spinnerD.getValue().toString());
//                if (parD != 0) {
//                    parA /= parD;
//                    parB /= parD;
//                    parC /= parD;
//                }
                //класс плоскость
                Plane plane = new Plane(parA, parB, parC, parD);
                onReady(plane);
                OtherFrame.this.dispose();
            }
        });
        this.add(b);
        this.setLayout(null);
        this.setSize(250, 250);
    }

    public LinkedList<PolyLine3D> getList() {
        return new LinkedList<>();
    }

    public interface PlaneReadyListener {
        void created(Plane plane);
    }


    private PlaneReadyListener listener = null;


    public void setReadyListener(PlaneReadyListener plane) {
        listener = plane;
    }

    protected void onReady(Plane plane) {
        if (listener != null) {
            listener.created(plane);
        }
    }

//    public void onClick() {
//        if (listener != null) {
//            listener.created(getPolyLine3D());
//        }
//        dispose();
//    }
}

