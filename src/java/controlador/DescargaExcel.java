/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont; //es parte de esa libreria
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import modelo.Producto;
import Dao.ProductoDao;

public class DescargaExcel extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, WriteException {
        response.setContentType("text/html;charset=UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        String productoNombre = request.getParameter("producto");
        String promocion = request.getParameter("promocion");
        Double montoTotal = Double.parseDouble(request.getParameter("montoTotal"));

        /* Formato negrita */
        WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
        cellFont.setBoldStyle(WritableFont.BOLD);
        WritableCellFormat cellFormat = new WritableCellFormat(cellFont);

        /* Creamos nuestra primera hoja de cálculo que en este caso se escribirá por un portlet */
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachement;filename=venta.xls");

        WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());
        WritableSheet wsheet = workbook.createSheet("First Sheet", 0);
        //WritableSheet wsheet1 = workbook.createSheet("First Sheet", 1);

        /* Escribimos un título en negrita en la casilla A2(Columna 0 fila 1) */
        Label titulo = new Label(0, 1, "PRODUCTO ADQUERIDO", cellFormat);
        wsheet.addCell(titulo);

        /* Escribimos un contenido en la casilla A3(Columna 0 fila 2) */
        Label productoDescripcion = new Label(0, 2, "Producto:");
        wsheet.addCell(productoDescripcion);
        Label nombre = new Label(1, 2, productoNombre);
        wsheet.addCell(nombre);

        Label promocionDescripcion = new Label(0, 3, "Promcion:");
        wsheet.addCell(promocionDescripcion);
        Label promo = new Label(1, 3, promocion);
        wsheet.addCell(promo);

        Label montoDescripcion = new Label(0, 4, "Monto:");
        wsheet.addCell(montoDescripcion);
        Label monto = new Label(1, 4, montoTotal.toString());
        wsheet.addCell(monto);

        /* Cerramos todo */
        workbook.write();
        workbook.close();

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
        try {
            processRequest(request, response);
        } catch (WriteException ex) {
            Logger.getLogger(DescargaExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (WriteException ex) {
            Logger.getLogger(DescargaExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
