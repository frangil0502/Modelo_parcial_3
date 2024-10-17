/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class VehiculoSUV extends Vehiculo {
    private boolean traccionIntegral;

    public VehiculoSUV(boolean traccionIntegral, String codVehiculo, String Modelo, double precioBase) throws IllegalArgumentException {
        super(codVehiculo, Modelo, precioBase);
        this.traccionIntegral = traccionIntegral;
    }

    @Override
    public double CalcularCostoReparacion(int horas) {
      double retorno = this.precioBase * horas;
        if (esTraccionIntegral()) {
            retorno = retorno * 1.10;
        }
        return retorno;
      
    }
    
     public boolean esTraccionIntegral() {
        boolean retorno = false;
        if (this.traccionIntegral) {
            retorno = true;
        }
        return retorno;
    }

    @Override
    public String toString() {
        return "VehiculoSUV{" + "traccionIntegral=" + traccionIntegral + super.toString() + '}';
    }

    
}
