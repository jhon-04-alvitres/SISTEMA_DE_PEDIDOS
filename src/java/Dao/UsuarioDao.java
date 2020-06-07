/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import utils.HibernateUtil;
import modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 
 */
public class UsuarioDao {

     public Usuario getUsuarioByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Usuario where usuario='"+username+"'";
        Query query = session.createQuery(hql);
        Usuario usuario = (Usuario)query.uniqueResult();
         System.out.println("Vista"+ usuario);
        return usuario;
    }

}
