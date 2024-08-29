/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.entidades;

import java.util.List;

import javax.swing.plaf.BorderUIResource.CompoundBorderUIResource;

/**
 *
 * @author florh
 */
public class Vendedor {
    private String id;
    private String nombre;
    private String direccion;
    private List<Coordenada> coordenadas;

    public Vendedor() {
    }

    public Vendedor(String id, String nombre, String direccion, List<Coordenada> coordenadas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenadas = coordenadas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Coordenada> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }
 
    public int distancia(Cliente cliente) {
        Coordenada coordVend = this.coordenadas.get(0);
        Coordenada coordCli = cliente.getCoordenadas().get(0);

        // TODO
        return 0;
    }
}
