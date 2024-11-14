
package desarrollo.tpentrega1.Memory;

import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.dao.ItemsMenuDAO;
import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;


public class ItemsMenuMemory implements ItemsMenuDAO {

    private static List<ItemMenu> itemsMenu = new ArrayList<ItemMenu>();
//    private List<ItemMenu> itemsMenu;

    public ItemsMenuMemory() {
//        itemsMenu = new ArrayList<ItemMenu>();
    }

    @Override
    public void crearItemMenu(ItemMenu itemMenu) throws DAOException {
        itemsMenu.add(itemMenu);
        System.out.println("Item de menú creado: " + itemMenu.getNombre());
    }

    @Override
    public void actualizarItemMenu(ItemMenu itemMenu) throws DAOException {
        for (int i = 0; i < itemsMenu.size(); i++) {
            if (itemsMenu.get(i).getId().equals(itemMenu.getId())) {
                itemsMenu.set(i, itemMenu);
                System.out.println("Item de menú actualizado: " + itemMenu.getNombre());
                return;
            }
        }
        System.out.println("Item de menú no encontrado para actualizar.");
        throw new DAOException("Item de menú no encontrado para actualizar.");
    }

    @Override
    public void eliminarItemMenu(ItemMenu itemMenu) throws DAOException {
        boolean existe= itemsMenu.stream().anyMatch(c -> c.getId().equals(String.valueOf(itemMenu.getId())));
        if(existe){
        itemsMenu.removeIf(item -> item.getId().equals(itemMenu.getId()));
        System.out.println("Item de menú eliminado con ID: " + itemMenu.getId());
       }
    }

    @Override
    public ItemMenu buscarItemMenu(String id, VendedorDAO vdao) throws DAOException {
        for (ItemMenu item : itemsMenu) {
            if (item.getId().equals(id)) {
                
                return item;
            }
        }
        
        return null;
    }

    @Override
    public List<ItemMenu> obtenerItemMenus(VendedorDAO vdao) throws DAOException {
        return itemsMenu;
    }

    
}
