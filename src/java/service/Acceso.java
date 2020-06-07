/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.UsuarioDao;
import modelo.Usuario;

/**
 *
 * @author USUARIO
 */
public class Acceso {
      public Boolean autentificar(String usuario, String password){
        Boolean respuesta;
        UsuarioDao dao = new UsuarioDao();
          System.out.println("LLegado al metodo ACCeso");
        Usuario miUsuario = dao.getUsuarioByUsername(usuario);
        
        if(password.equals(miUsuario.getPassword())){
            respuesta = true;            
        }else{
            respuesta = false;
        }
        return respuesta;
    }
}
