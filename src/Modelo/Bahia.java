/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Queue.LinkedQueue;
import javax.swing.JOptionPane;

/**
 *@since 15-04-2017
 * @author Daniel Rojas - danielroj
 */
public class Bahia {
    
   static int puestos = 0;
   static int espera=0;
   static  LinkedQueue cola1=new LinkedQueue();
    
    static LinkedQueue cola2=new LinkedQueue();
    
    public static  Auto sacar(String placa) {
        Auto c = null;
        int i;
        int contador=0;
        Auto x=null;
        for ( i = 0; i < puestos; i++) {
            
            c = (Auto) cola1.getFrontElement();
            c.setnMovimiento(1);
            if (c.getPlaca().equals(placa)) {
                cola1.remove(); 
                puestos--;
           
                 if (!cola2.isEmpty()) {
                     espera--;
                    cola1.put(cola2.remove());
                    puestos++;
                    JOptionPane.showMessageDialog(null, "Ingreso un auto de espera a Bahia");
                }
  
               if(i==0){
             return c;
           }   
               
              x=c;  
        
            }
            cola1.put(cola1.remove());
            
           
        }
       
        return x;
    }
    
    public static void Meter(Auto c) {
        
        if (puestos >= 10) {
            c.setnMovimiento(0);
            cola2.put(c);
            espera++;
        } else {
            cola1.put(c);
            puestos++;
        }
        
    }

    public static LinkedQueue getCola1() {
        return cola1;
    }

    public static LinkedQueue getCola2() {
        return cola2;
    }

    public static int getPuestos() {
        return puestos;
    }

    public static int getEspera() {
        return espera;
    }
    
    
    
    
    
    
    
}
