/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladpr;

import Modelo.Auto;
import Modelo.Bahia;
import Queue.LinkedQueue;
import Vista.VistaP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *@since 15-04-2017
 * @author Daniel Rojas - danielroj
 */
public class Controlador implements ActionListener {

 VistaP vista;
DefaultTableModel model;
DefaultTableModel model2;
    public Controlador(VistaP vista) {
        this.vista = vista;
        this.vista.entrada=vista.entrada;
        this.vista.meter.addActionListener(this);
        this.vista.sacar.addActionListener(this);
        this.vista.mostrar.addActionListener(this);
        this.model=(DefaultTableModel) this.vista.jTable1.getModel();
        this.model2=(DefaultTableModel) this.vista.jTable2.getModel();
        this.vista.setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource().equals(vista.mostrar)){
              int p=Bahia.getPuestos();
                LinkedQueue cola1=Bahia.getCola1();
                LinkedQueue cola2=Bahia.getCola2();
           
            while(model.getRowCount()!=0){
               model.removeRow(0);     
            }
             
            while(model2.getRowCount()!=0){
               model2.removeRow(0);     
            }
            
            int v=Bahia.getEspera();
          
            for (int i = 0; i <v; i++) {
             Auto a=(Auto) cola2.getFrontElement();
            
                Object[] fila={a.getPlaca()};
                
                model2.addRow(fila);
                
               cola2.put(cola2.remove());
            
               }
            
  
            for (int i = 0; i <p ; i++) {
             Auto a=(Auto) cola1.getFrontElement();
            
                Object[] fila={a.getPlaca(),null};
                
                model.addRow(fila);
                
               cola1.put(cola1.remove());
            
               }

        
    }
            
        
    
        
        if(ae.getSource().equals(vista.meter)){
         String placa =vista.entrada.getText();
         
         Auto x=new Auto(placa);
            
         Bahia.Meter(x);
         
       if(Bahia.getPuestos()<10){
           JOptionPane.showMessageDialog(null,"Un nuevo Auto Ingreso A la Bahia");
       } else{
           JOptionPane.showMessageDialog(null, "Un nuevo Auto ingreso  Espera");
       } 
         
      }
        
        
      if(ae.getSource().equals(vista.sacar)){
       String placa=vista.entrada.getText();
       Auto v=Bahia.sacar(placa);
       if(v==null){
           JOptionPane.showMessageDialog(null, "El auto No se encuentra en Bahia");
       }else{
           JOptionPane.showMessageDialog(null, "el auto con placa= "+v.getPlaca()+" con movimientos= "+v.getnMovimiento());
       }
       
       }  
        
        
        
        
    }
    
}
