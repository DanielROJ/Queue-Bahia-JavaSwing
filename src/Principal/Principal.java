/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Controladpr.Controlador;
import Vista.VistaP;

/**
 *
 * @author danie
 */
public class Principal {
    public static void main(String[] args) {
        VistaP vista=new VistaP();
        Controlador c=new Controlador(vista);
    }
}
