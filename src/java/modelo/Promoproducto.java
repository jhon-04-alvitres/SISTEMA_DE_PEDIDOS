package modelo;
// Generated 06/06/2020 11:48:05 PM by Hibernate Tools 4.3.1



/**
 * Promoproducto generated by hbm2java
 */
public class Promoproducto  implements java.io.Serializable {


     private Integer id;
     private Producto producto;
     private Promocion promocion;

    public Promoproducto() {
    }

    public Promoproducto(Producto producto, Promocion promocion) {
       this.producto = producto;
       this.promocion = promocion;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Promocion getPromocion() {
        return this.promocion;
    }
    
    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }


}


