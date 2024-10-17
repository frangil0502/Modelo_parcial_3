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
public class VehiculoCompacto extends Vehiculo {

    private int anio;

    public VehiculoCompacto(int anio, String codVehiculo, String Modelo, double precioBase) throws IllegalArgumentException {
        super(codVehiculo, Modelo, precioBase);
        this.anio = anio;
    }

    @Override
    public double CalcularCostoReparacion(int horas) {
        double retorno = this.precioBase * horas;
        if (esVehiculoNuevo()) {
            retorno = retorno * 0.95;
        }
        return retorno;
    }

    public boolean esVehiculoNuevo() {
        boolean retorno = false;
        if (this.anio == LocalDate.now().getYear()) {
            retorno = true;
        }
        return retorno;
    }

    @Override
    public String toString() {
        return "VehiculoCompacto{" + "anio=" + anio + super.toString() + '}';
    }

    

}
