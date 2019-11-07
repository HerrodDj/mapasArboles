/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.view;

import java.awt.Dimension;
import java.util.Observable;

/**
 *
 * @author Juan Carlos
 */
public class Modelo extends Observable{
     public Modelo(){
        
    }

    public Dimension obtenerArea() {
        return new Dimension(800, 640);
    }
}
