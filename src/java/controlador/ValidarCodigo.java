/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Dao.ProductoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;
import modelo.Promocion;

/**
 *
 * @author USUARIO
 */
public class ValidarCodigo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String productoNombre = request.getParameter("producto");
        Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));
        Integer idPromocion = Integer.parseInt(request.getParameter("promocion"));

        Producto producto = ProductoDao.obtenerProducto(productoNombre);
        Promocion promocion = ProductoDao.obtenerPromocion(idPromocion);

        double montoTotal = 0;
        RequestDispatcher rd;
        String mensaje = "";

        if (producto != null && promocion != null) {
            if (ProductoDao.validarProductoPromocion(producto.getIdProducto(), promocion.getIdPromocion())) {
                
                montoTotal = ProductoDao.montoTotal(producto, cantidad, producto.getIdProducto(), promocion.getPorciento());

//                System.out.println("Codigo: " + promocion);
//                System.out.println("MontoTotal: " + montoTotal);
//                System.out.println(producto);
//               
                request.setAttribute("codigo", promocion.getPromocion());
                request.setAttribute("promodio", producto);

                request.setAttribute("producto", producto);
                request.setAttribute("respuesta", montoTotal);
               ///  System.out.println("-------------------------------------------------");
                rd = request.getRequestDispatcher("/vista.jsp");
            } else {
                mensaje = "No tiene asignado la promocion";
                rd = request.getRequestDispatcher("/producto.jsp");
            }
        } else {
            mensaje = "No se encontro el producto o promocion";
            rd = request.getRequestDispatcher("/producto.jsp");
        }
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
