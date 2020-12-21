package com.company;

import com.company.models.Plane;
import com.company.utils.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class MainWindow extends JFrame {
    private JPanel contentPane;
    private DrawPanel dp;
    private JPanel panel2;
    private JButton openButton;
    private JButton tetrahedronButton;
    private JButton cubeButton;
    private JButton octahedronButton;
    private JButton icosahedronButton;
    private JButton dodecahedronButton;
    private JSpinner spinnerA;
    private JSpinner spinnerB;
    private JSpinner spinnerC;
    private JSpinner spinnerD;
    private JButton buttonPlane;


    public MainWindow() {
        setContentPane(contentPane);
        JFileChooser fileChooserOpen;
        fileChooserOpen = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("Координаты точек платоновых тел.txt"));
        FileFilter filter = new FileNameExtensionFilter("Координаты точек платоновых тел.txt", "Координаты точек платоновых тел.txt");
        fileChooserOpen.addChoosableFileFilter(filter);


        spinnerA.setModel(new SpinnerNumberModel(0.5f, -100f, 300, 0.1f));
        spinnerB.setModel(new SpinnerNumberModel(0.5f, -100f, 300, 0.1f));
        spinnerC.setModel(new SpinnerNumberModel(-1f, -100f, 300, 0.1f));
        spinnerD.setModel(new SpinnerNumberModel(10f, -100f, 300, 0.1f));


        try {
            Vertex.reader("Координаты точек платоновых тел.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panel2) == JFileChooser.APPROVE_OPTION) {
                        Vertex.reader(fileChooserOpen.getSelectedFile().getPath());
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        tetrahedronButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    dp.setTetrahedron();
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        cubeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    dp.setParallelepiped();
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        octahedronButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    dp.setOctahedron();
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        icosahedronButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    dp.setIcosahedron();
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });


        dodecahedronButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    dp.setDodecahedron();
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });


        buttonPlane.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dp.setPlane(new Plane(Float.parseFloat(spinnerA.getValue().toString()),
                        Float.parseFloat(spinnerB.getValue().toString()),
                        Float.parseFloat(spinnerC.getValue().toString()),
                        Float.parseFloat(spinnerD.getValue().toString())));
            }
        });
    }

}
