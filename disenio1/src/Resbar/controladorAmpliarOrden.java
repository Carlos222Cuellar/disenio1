
package Resbar;

import conexion.Conexionn;
import java.sql.ResultSet;

public class controladorAmpliarOrden {
    
    
    
    
    
    
    Conexionn cn = new Conexionn();

     
     
    public ResultSet llenarProductos() {
        return (cn.getValores("SELECT * FROM Productos"));
    }

      
    //me devuelve productos segun id categoria  

    /**
     *
     * @param categoria
     * @return un producto segun el id de categoria que se le pase como parametro
     */
    public ResultSet llenarProductos( String orden) {
        return (cn.getValores("SELECT p.nombre,dt.cantidad, dt.precio,  from DetalleOrden dt inner join Productos p"+
                " on dt.IdProductos=p.IdProductos where IdOrden="+orden+"" ));
    }
    
    public void agregarDetalleOrden(int idOrden,int idProducto,double precio,int catidad)
    {
      
         //insertar en la tabla detalle orden con cn.UUI(insert detalleorden(id,id,precio,catidad) values())
        
   
    }
    
    /**
     * @param producto
     *  @return devuelve producto segun su id ingressado
     */     
    public ResultSet productobyid( String producto) {
        return (cn.getValores("SELECT nombre,precio FROM Productos where IdCategoria= '"+producto+"'"));
    }
    
   public void modificarproducto (String IdProducto,String nombre,String precio)
   {
  cn.UID("UPDATE productos SET nombre='" + nombre + "', precio='" + precio + "' WHERE IdProductos='" + IdProducto + "'");
   
   }
    public void eliminar (String IdProducto)
   {
  cn.UID("DELETE FROM productos WHERE IdProductos='" + IdProducto + "'");
   
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
