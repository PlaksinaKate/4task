/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.third;

import java.io.IOException;
import java.util.List;

/**
 * Описывает в общем виде любую модель
 * @author Alexey
 */
public interface IModel {
    /**
     * Любая модель - это набор полилиний.
     * @return Списко полилиний модели.
     */
    List<PolyLine3D> getLines() throws IOException;
}
