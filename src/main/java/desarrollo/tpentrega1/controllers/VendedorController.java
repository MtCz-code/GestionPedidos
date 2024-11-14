package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.dao.sql.VendedorDAOSql;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedorController {

    private VendedorDAOSql vendedorDAOSql;

    public VendedorDAOSql getVendedorDAO() {
        return vendedorDAOSql;
    }
    
    

    public VendedorController() {
        try {


            this.vendedorDAOSql = new VendedorDAOSql();
        } catch (Exception ex) {
            throw new RuntimeException("cant open db");
        }
    }

    public Vendedor crearNuevoVendedor(String id, String nombre, String direccion, Coordenada coordenada) {
        Vendedor nuevoVendedor = new Vendedor(id, nombre, direccion, coordenada);
        try {
            vendedorDAOSql.crearVendedor(nuevoVendedor);
        } catch (DAOException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoVendedor;
    }

    // Modificar un vendedor existente (asumiendo que se identifica por nombre, dirección, coordenada)
    public void modificarVendedor(String id, String nombre, String direccion, Coordenada coordenada) {
        Vendedor vendedorExistente;
        try {
            vendedorExistente = vendedorDAOSql.buscarVendedor(id);
            if (vendedorExistente != null) {
                vendedorExistente.setNombre(nombre);
                vendedorExistente.setDireccion(direccion);
                vendedorExistente.setCoordenada(coordenada);
                vendedorDAOSql.actualizarVendedor(vendedorExistente);
                System.out.println("Vendedor modificado: " + nombre);
            } else {
                System.out.println("Vendedor no encontrado para modificar.");
            }
        } catch (DAOException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarVendedor(Vendedor vendedor) {
        try {
            vendedorDAOSql.actualizarVendedor(vendedor);
        } catch (DAOException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar un vendedor por ID
    public void eliminarVendedor(Vendedor vendedor) {
        try {
            vendedorDAOSql.eliminarVendedor(vendedor);
        } catch (DAOException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Buscar un vendedor por ID
    public Vendedor buscarVendedor(String id) {
        try {
        Vendedor vendedor = vendedorDAOSql.buscarVendedor(id);
        if (vendedor != null) {
            System.out.println("Vendedor encontrado: " + vendedor.getNombre());
            return vendedor;
        } else {
            System.out.println("Vendedor no encontrado con ID " + id);
            return null;
        }
        } catch(Exception e){
            System.out.println("" + e.getMessage());
        }
        return null;
    }

    public List<Vendedor> obtenerListaVendedores() {
        try {
            return vendedorDAOSql.obtenerVendedores();
        } catch (DAOException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
