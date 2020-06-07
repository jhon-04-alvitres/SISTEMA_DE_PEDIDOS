/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;
import modelo.Promocion;
import modelo.Promoproducto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author USUARIO
 */
public class ProductoDao {

    // listamos las promociones
    public static List<Promocion> listaPromociones() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Promocion";
        Query query = session.createQuery(hql);
        List<Promocion> miLista = query.list();
        return miLista;
    }

    // listarProdcutos
    public static List<Producto> listaProductos() {

        List<Producto> listaProductos = new ArrayList<>();

        for (Promocion listaPromocion : listaPromociones()) {

        }
        return listaProductos;

    }

    public static List<Promoproducto> listarPromoproducto() {

        List<Promoproducto> lista = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Promoproducto as pp inner join fetch pp.producto inner join fetch pp.promocion";
        Query query = session.createQuery(hql);
        lista = (List<Promoproducto>) query.list();
        return lista;
    }

    //insertar Producto con Promocion
    public static String InsertarProductoConPromocion(Producto idProducto, Promocion idPromocion) {
        Promoproducto promoproducto = new Promoproducto(idProducto, idPromocion);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(promoproducto);
        transaction.commit();
        session.close();
        return "Se inserto una nueva registro de producto";
    }

    //vamos a sacar el total, aqui lo descontamos al mismo tiempo
    public static double montoTotal(Producto producto, int cantidad, int idCodigo, int porcentaje) {
        double total = 0, descuento = 0;
        if (cantidad > 0) {
            total = producto.getPrecio() * cantidad;
        }
        if (idCodigo == 1) {

            descuento = (total * porcentaje) / 100;

        } else if (idCodigo == 2) {

            descuento = (total * porcentaje) / 100;

        } else if (idCodigo == 3) {

            descuento = (total * porcentaje) / 100;
        }

        return total - descuento;
    }

    // aqui obtenemos al productos
    public static Producto obtenerProducto(String productoNombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Producto where producto = '" + productoNombre + "'";
        Query query = session.createQuery(hql);
        List<Producto> lista = query.list();

        for (Producto producto : lista) {
            return producto;
        }

        return null;

    }

    public static Promocion obtenerPromocion(int idCodigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Promocion where idPromocion = '" + idCodigo + "'";
        Query query = session.createQuery(hql);
        List<Promocion> lista = query.list();

        for (Promocion promocion : lista) {
            return promocion;
        }
        return null;
    }

    public static boolean validarProductoPromocion(int idProducto, int idPromocion) {
        List<Promoproducto> lista = listarPromoproducto();
        for (Promoproducto promoproducto : lista) {
            if (promoproducto.getProducto().getIdProducto() == idProducto && promoproducto.getPromocion().getIdPromocion() == idPromocion) {
                return true;
            }
        }
        return false;

    }

    // listar el combox
    public static List<Promocion> comboPromociones() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Promocion";
        Query query = session.createQuery(hql);
        List<Promocion> lista = query.list();
        return lista;
    }
}
