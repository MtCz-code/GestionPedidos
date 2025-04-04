
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;

public interface ClienteDAO {

    public void crearCliente(Cliente cliente) throws DAOException;

    public void actualizarCliente(Cliente cliente) throws DAOException;

    public void eliminarCliente(int id) throws DAOException;

    public Cliente buscarCliente(int id) throws DAOException;
    
    public List<Cliente> obtenerClientes() throws DAOException;
}
