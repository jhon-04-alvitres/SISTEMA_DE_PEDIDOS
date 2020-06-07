package modelo;
// Generated 06/06/2020 11:48:05 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Promocion generated by hbm2java
 */
public class Promocion  implements java.io.Serializable {


     private Integer idPromocion;
     private String promocion;
     private Integer porciento;
     private Set promoproductos = new HashSet(0);

    public Promocion() {
    }

    public Promocion(String promocion, Integer porciento, Set promoproductos) {
       this.promocion = promocion;
       this.porciento = porciento;
       this.promoproductos = promoproductos;
    }
   
    public Integer getIdPromocion() {
        return this.idPromocion;
    }
    
    public void setIdPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }
    public String getPromocion() {
        return this.promocion;
    }
    
    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }
    public Integer getPorciento() {
        return this.porciento;
    }
    
    public void setPorciento(Integer porciento) {
        this.porciento = porciento;
    }
    public Set getPromoproductos() {
        return this.promoproductos;
    }
    
    public void setPromoproductos(Set promoproductos) {
        this.promoproductos = promoproductos;
    }

    @Override
    public String toString() {
        return "Promocion{" + "idPromocion=" + idPromocion + ", promocion=" + promocion + ", porciento=" + porciento + ", promoproductos=" + promoproductos + '}';
    }




}

