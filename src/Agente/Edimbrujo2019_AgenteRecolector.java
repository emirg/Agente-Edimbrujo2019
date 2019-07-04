/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agente;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author german
 */
public class Edimbrujo2019_AgenteRecolector {
    
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            AgenteRecolector ia=new AgenteRecolector();
            while (true) {
                ia.jugar();
            }

        } catch (IOException ex) {
            Logger.getLogger(Edimbrujo2019_AgenteRecolector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
