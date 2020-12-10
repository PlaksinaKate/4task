package com.company.models;

import com.company.math.Vector3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vertex {

    public static Vector3[] tetrahedron;
    public static Vector3[] octahedron;
    public static Vector3[] dodecahedron;
    public static Vector3[] icosahedron;


    public static void reader(String readFile) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(readFile));

        try {
            ArrayList list = new ArrayList();
            ArrayList<ArrayList<String>> checkList = new ArrayList<>();
            String line;

            //populating the first list
            while ((line = br.readLine()) != null) {

                if (!line.trim().isEmpty()) {
                    list.add(line.trim());
                } else {
                    checkList.add(list);
                    list = new ArrayList();
                }

            }

            for (int i = 0; i < checkList.size(); i++) {
                checkList.get(i).remove(checkList.get(i).get(0));
            }

            for (int i = 0; i < checkList.size(); i++) {
                int temp = 0;
                Vector3[] vector3s = new Vector3[checkList.get(i).size()];
                while (temp != checkList.get(i).size()) {
                    String[] point = checkList.get(i).get(temp).split(" ");
                    Float[] points = Arrays.stream(point).map(Float::valueOf).toArray(Float[]::new);
                    vector3s[temp] = new Vector3(points[0], points[1], points[2]);
                    temp++;
                }
                if (i == 0) {
                    tetrahedron = vector3s;
                } else if (i == 1) {
                    octahedron = vector3s;
                } else if (i == 2) {
                    icosahedron = vector3s;
                } else if (i == 3) {
                    dodecahedron = vector3s;
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }


    }

    public static Vector3[] getTetrahedron() {
        return tetrahedron;
    }

    public static Vector3[] getOctahedron() {
        return octahedron;
    }

    public static Vector3[] getDodecahedron() {
        return dodecahedron;
    }

    public static Vector3[] getIcosahedron() {
        return icosahedron;
    }
}
