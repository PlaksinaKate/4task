/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import com.company.DrawPanel;
import com.company.models.Vertex;
import com.company.utils.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * @author Alexey
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFileChooser fileChooserOpen;
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLocation(0, 0);
        panel.setSize(frame.getWidth(), 70);
        fileChooserOpen = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("Координаты точек платоновых тел.txt"));
        FileFilter filter = new FileNameExtensionFilter("Координаты точек платоновых тел.txt", "Координаты точек платоновых тел.txt");
        fileChooserOpen.addChoosableFileFilter(filter);

        JButton buttonReaderFile = new JButton();
        buttonReaderFile.setBounds(0, 0, 100, 30);
        buttonReaderFile.setText("Загрузить из файла координаты");
        try {
            Vertex.reader("Координаты точек платоновых тел.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonReaderFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
                        Vertex.reader(fileChooserOpen.getSelectedFile().getPath());
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        panel.add(buttonReaderFile);

        DrawPanel dp = new DrawPanel();
        JButton buttonTetrahedron = new JButton();
        buttonTetrahedron.setBounds(100, 0, 100, 30);
        buttonTetrahedron.setText("Тетраэдр");
        buttonTetrahedron.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    dp.setTetrahedron();
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        panel.add(buttonTetrahedron);

        JButton buttonParallelepiped = new JButton();
        buttonParallelepiped.setBounds(200, 0, 100, 30);
        buttonParallelepiped.setText("Куб");
        buttonParallelepiped.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    dp.setParallelepiped();
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        panel.add(buttonParallelepiped);

        JButton buttonOctahedron = new JButton();
        buttonOctahedron.setBounds(200, 0, 100, 30);
        buttonOctahedron.setText("Октаэдр");
        buttonOctahedron.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    dp.setOctahedron();
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        panel.add(buttonOctahedron);

        JButton buttonIcosahedron = new JButton();
        buttonIcosahedron.setBounds(200, 0, 100, 30);
        buttonIcosahedron.setText("Икосаэдр");
        buttonIcosahedron.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    dp.setIcosahedron();
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        panel.add(buttonIcosahedron);

        JButton buttonDodecahedron = new JButton();
        buttonDodecahedron.setBounds(200, 0, 100, 30);
        buttonDodecahedron.setText("Додекаэдр");
        buttonDodecahedron.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    dp.setDodecahedron();
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        panel.add(buttonDodecahedron);
        frame.add(panel);
        frame.add(dp);
        frame.setVisible(true);
    }
}
