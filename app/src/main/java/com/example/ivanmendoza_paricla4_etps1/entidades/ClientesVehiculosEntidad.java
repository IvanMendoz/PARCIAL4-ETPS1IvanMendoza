package com.example.ivanmendoza_paricla4_etps1.entidades;

public class ClientesVehiculosEntidad {
    private int id_cliente;
    private int id_vehiculo;
    private String sMatricula;
    private int iKilometraje;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getMatricula() {
        return sMatricula;
    }

    public void setMatricula(String matricula) {
        this.sMatricula = matricula;
    }

    public int getKilometraje() {
        return iKilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.iKilometraje = kilometraje;
    }
}
