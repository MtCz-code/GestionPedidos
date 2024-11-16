package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.dao.sql.VendedorDAOSql;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VendedorControllerTest {
    @Mock
    VendedorDAO vendedorDAO = VendedorDAOSql.getInstance();
    @InjectMocks
    VendedorController vendedorController = new VendedorController(vendedorDAO);
        
    public VendedorControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
        for(Vendedor v: vendedorController.obtenerListaVendedores()){
            vendedorController.eliminarVendedor(v);
        }
    }

    @Test
    public void testGetVendedorDAO() {
        VendedorDAO expResult = null;
        VendedorDAO result = vendedorController.getVendedorDAO();
        assertEquals(expResult, result);
    }

    @Test
    public void testCrearNuevoVendedor() throws DAOException {
        String id = "";
        String nombre = "";
        String direccion = "";
        Coordenada coordenada = null;
        Vendedor expResult = null;
        Vendedor result = vendedorController.crearNuevoVendedor(id, nombre, direccion, coordenada);
        assertEquals(expResult, result);
        Mockito.verify(vendedorDAO).crearVendedor(expResult);
    }

    @Test
    public void testModificarVendedor_4args() throws DAOException {
        String id = "";
        String nombre = "";
        String direccion = "";
        Coordenada coordenada = null;
        Vendedor vendedor = new Vendedor(id, nombre, direccion, coordenada);
        vendedorController.modificarVendedor(id, nombre, direccion, coordenada);
        Mockito.verify(vendedorDAO).buscarVendedor(id);
        Mockito.verify(vendedorDAO).actualizarVendedor(vendedor);
    }

    @Test
    public void testModificarVendedor_Vendedor() throws DAOException {
        Vendedor vendedor = null;
        vendedorController.modificarVendedor(vendedor);
        Mockito.verify(vendedorDAO).actualizarVendedor(vendedor);
    }

    @Test
    public void testEliminarVendedor() throws DAOException {
        Vendedor vendedor = null;
        vendedorController.eliminarVendedor(vendedor);
        Mockito.verify(vendedorDAO).eliminarVendedor(vendedor);
    }

    @Test
    public void testBuscarVendedor() throws DAOException {
        String id = "";
        Vendedor expResult = null;
        Vendedor result = vendedorController.buscarVendedor(id);
        assertEquals(expResult, result);
        Mockito.verify(vendedorDAO).buscarVendedor(id);
    }

    @Test
    public void testObtenerListaVendedores() throws DAOException {
        List<Vendedor> expResult = null;
        List<Vendedor> result = vendedorController.obtenerListaVendedores();
        assertEquals(expResult, result);
        Mockito.verify(vendedorDAO).obtenerVendedores();
    }
    
}
