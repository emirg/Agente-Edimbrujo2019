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
 * @author emiliano
 */
public class main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Agente ia = new Agente();
            //Agente1 ia1 = new Agente1();

            while (true) {
                //ia.jugar();
                
                ia.jugar();
            }

        } catch (IOException ex) {
            Logger.getLogger(Edimbrujo2019_Agente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}