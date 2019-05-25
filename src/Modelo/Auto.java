/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *@since 15-04-2017
 * @author Daniel Rojas - danielroj
 */
public class Auto {
    String placa;
    int nMovimiento=0;

    public Auto(String placa) {
        this.placa = placa;
       
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getnMovimiento() {
        return nMovimiento;
    }

    public void setnMovimiento(int nMovimiento) {
       this.nMovimiento= this.nMovimiento + nMovimiento;
    }
    
    
    
}
