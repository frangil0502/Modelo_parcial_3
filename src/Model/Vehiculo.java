/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.EstadoVehiculo.EstadoV;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public abstract class Vehiculo {
    protected String codVehiculo;
    protected String Modelo;
    protected double precioBase;
    protected EstadoVehiculo.EstadoV estado;
    protected List<String> HistorialReparaciones;


    public Vehiculo(String codVehiculo, String Modelo, double precioBase) throws IllegalArgumentException{
        if(codVehiculo.length() != 7){
        throw new IllegalArgumentException("el codigo del vehiculo no tiene justo 7 caracteres");
        }
        
        this.codVehiculo = codVehiculo;
        this.Modelo = Modelo;
        this.precioBase = precioBase;
        this.estado = EstadoVehiculo.EstadoV.DISPONIBLE;
        this.HistorialReparaciones = new ArrayList<>();
    }

    
public abstract double CalcularCostoReparacion(int horas);

public void IniciarReparacion(String nombreTaller, String descripcion) throws IllegalStateException{
if(this.estado == EstadoVehiculo.EstadoV.EN_REPARACION){
throw new IllegalStateException("El vehiculo esta ya se encuentra em reparacion");
}
this.estado = EstadoVehiculo.EstadoV.EN_REPARACION;

String entradaHistorial = LocalDate.now() + ": [" + nombreTaller + "] " + descripcion;
HistorialReparaciones.add(entradaHistorial);
}

public void finalizarReparacion() throws IllegalStateException{
if(this.estado != EstadoVehiculo.EstadoV.EN_REPARACION){
throw new IllegalStateException("El vehiculo no se encuentra en reparcion");
}
this.estado = EstadoVehiculo.EstadoV.DISPONIBLE;
HistorialReparaciones.add(LocalDate.now() + ": Reparación finalizada.");
}

public List obtenerHistorialDeReparaciones() throws Exception{
    if(HistorialReparaciones.isEmpty()){
    throw new Exception ("No hay ninguna reparacion hecha");
    }
    return HistorialReparaciones;
}

    public String getCodVehiculo() {
        return codVehiculo;
    }

    public EstadoV getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "codVehiculo=" + codVehiculo + ", Modelo=" + Modelo + ", precioBase=" + precioBase + ", estado=" + estado + ", HistorialReparaciones=" + HistorialReparaciones + '}';
    }

}
