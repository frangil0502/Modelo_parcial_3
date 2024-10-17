/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Model.EstadoVehiculo;
import Model.VehiculoCompacto;
import Model.VehiculoSUV;
import Model.Taller;

/**
 *
 * @author Usuario
 */
public class main {

    public static void main(String[] args) {
        System.out.println("1");
        Taller tallerCentral = new Taller("Taller central");
        ///////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("1-1");
        try {
            //VehiculoCompacto vehiculo1 = new VehiculoCompacto(2024, "ABC123", "Toyota Corolla", 2000.0);
            System.out.println("1-2");
            VehiculoCompacto vehiculo2 = new VehiculoCompacto(2023, "XYZ5678", "Honda Civic", 2200.0);
            System.out.println(vehiculo2.toString());
            System.out.println("1-3");
            VehiculoSUV vehiculo3 = new VehiculoSUV(false, "QRS7890", "Chevrolet Tahoe", 4000.0);
            System.out.println(vehiculo3.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ///////////////////////////////////////////////////////////////////////////////////////
        System.out.println("2-1");
        try {
            VehiculoCompacto vehiculo4 = new VehiculoCompacto(2023, "XYZ5678", "Honda Civic", 2200.0);
            System.out.println(vehiculo4.CalcularCostoReparacion(5));
            System.out.println("2-2");
            VehiculoSUV vehiculo5 = new VehiculoSUV(false, "QRS7890", "Chevrolet Tahoe", 4000.0);
            System.out.println(vehiculo5.CalcularCostoReparacion(3));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("3-1");
        try {
            VehiculoCompacto vehiculo6 = new VehiculoCompacto(2024, "LMN1111", "Volkswagen Polo", 1800.0);
            VehiculoSUV vehiculo7 = new VehiculoSUV(true, "OPQ2222", "Toyota RAV4", 3000.0);
            VehiculoSUV vehiculo8 = new VehiculoSUV(true, "LMN1111", "Ford Explorer", 3500.0);
            VehiculoSUV vehiculo9 = new VehiculoSUV(true, "LMN1111", "Ford Explorer", 3500.0);
            tallerCentral.agregarVehiculo(vehiculo6);
            tallerCentral.agregarVehiculo(vehiculo7);
            System.out.println("3-2");
            System.out.println(tallerCentral.traerVehiculosDisponibles());
            tallerCentral.agregarVehiculo(vehiculo9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            VehiculoSUV vehiculo11 = new VehiculoSUV(true, "LOLO123", "Chevrolet camaro", 3000.0);
            tallerCentral.agregarVehiculo(vehiculo11);
            System.out.println(tallerCentral.traerVehiculos(EstadoVehiculo.EstadoV.DISPONIBLE));
            tallerCentral.iniciarReparacion("LOLO123", "2024/17/10");
            System.out.println(tallerCentral.traerVehiculos(EstadoVehiculo.EstadoV.EN_REPARACION));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        
        
    }

    
    
}
