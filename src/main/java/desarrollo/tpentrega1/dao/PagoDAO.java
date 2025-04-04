
package desarrollo.tpentrega1.dao;

import desarrollo.tpentrega1.entidades.Pago;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;

public interface PagoDAO {
        public void crearPago(Pago pago) throws DAOException,Exception;

    public void eliminarPago(String id) throws DAOException;

    public Pago buscarPago(String id) throws DAOException;
    
    public List<Pago> obtenerPagos() throws DAOException;

    public Pago buscarPagoPorIdPedido(String id)throws DAOException;
}
