package Model;

import java.util.ArrayList;
import java.util.List;

public class Taller {

    private String nombreTaller;
    private List<Vehiculo> inventarioVehiculos;
    private List<Vehiculo> vehiculosEnReparacion;
    private List<Vehiculo> VehiculosFueraDeServicio;

    public Taller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
        this.inventarioVehiculos = new ArrayList<>();
        this.vehiculosEnReparacion = new ArrayList<>();
        this.VehiculosFueraDeServicio = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) throws Exception {

        for (Vehiculo v : inventarioVehiculos) {
            if (v.getCodVehiculo().equals(vehiculo.getCodVehiculo())) {
                throw new Exception("El vehiculo ya esta en el inventario");
            }
        }
        inventarioVehiculos.add(vehiculo);
    }

    public double calcularCostoReparacion(String codVehiculo, int horas) throws Exception {
        double retorno = 0.0;
        for (Vehiculo v : inventarioVehiculos) {
            if (v.getCodVehiculo().equals(codVehiculo)) {
                if (v.getEstado() != EstadoVehiculo.EstadoV.EN_REPARACION) {
                    throw new Exception("El vehiculo no esta en reparacion");
                } else {
                    if (v instanceof VehiculoSUV) {
                        retorno = v.CalcularCostoReparacion(horas);
                    } else if (v instanceof VehiculoCompacto) {
                        retorno = v.CalcularCostoReparacion(horas);
                    }

                }
            } else {
                throw new Exception("El vehiculo no esta en inventario");
            }
        }
        return retorno;
    }

    public void iniciarReparacion(String codigoVehiculo, String descripcion) throws Exception {
        for (Vehiculo v : inventarioVehiculos) {
            if (v.getCodVehiculo().equals(codigoVehiculo)) {
                if (v.getEstado() != EstadoVehiculo.EstadoV.EN_REPARACION) {
                    v.IniciarReparacion(nombreTaller, descripcion);
                    vehiculosEnReparacion.add(v);
                } else {
                    throw new Exception("El vehiculo no esta en reparacion");
                }
            }
        }
    }

    public void finalizarReparacion(String codigoVehiculo) {
        for (Vehiculo v : vehiculosEnReparacion) {
            if (v.getCodVehiculo() == codigoVehiculo) {
                v.finalizarReparacion();
                vehiculosEnReparacion.remove(v);
            }
        }
    }

    public List<Vehiculo> traerVehiculosDisponibles() {
        List disponibles = new ArrayList<>();

        for (Vehiculo v : inventarioVehiculos) {
            if (v.getEstado() == EstadoVehiculo.EstadoV.DISPONIBLE) {
                disponibles.add(v);

            }
        }
        return disponibles;
    }

    public List<Vehiculo> traerVehiculos(EstadoVehiculo.EstadoV estado) {
        List vehiculos = new ArrayList<>();

        for (Vehiculo v : inventarioVehiculos) {
            if (v.getEstado() == estado) {
                vehiculos.add(v);
            }
        }
        return vehiculos;
    }

    public List<String> obtenerHistorialReparaciones(String codigoVehiculo) throws Exception {
        for (Vehiculo v : inventarioVehiculos) {
            if (v.getCodVehiculo().equals(codigoVehiculo)) {
                return v.obtenerHistorialDeReparaciones();
            }
        }
        throw new IllegalArgumentException("El vehículo con el código proporcionado no existe.");
    }
}
