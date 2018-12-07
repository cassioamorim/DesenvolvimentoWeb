/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOTipo;
import Entidades.Tipo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cássio
 */
@WebServlet(name = "TipoServlet", urlPatterns = {"/tipoLista"})
public class TipoServlet extends HttpServlet {

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
        String nomeTipo = "";
        DAOTipo daoTipo = new DAOTipo();
        Tipo tipo = new Tipo();
        String resultadoTipo = "";
        try (PrintWriter out = response.getWriter()) {
            if (!request.getParameter("idTipo").equals("null")) {
                String idTipo = request.getParameter("idTipo");
                tipo.setIdTipo(Integer.valueOf(idTipo));
                
                nomeTipo = request.getParameter("nome");
                tipo.setNome(nomeTipo);

                daoTipo.atualizar(tipo);
                resultadoTipo = "";

                resultadoTipo = listaTiposCadastrados();
            } else {
                nomeTipo = request.getParameter("nome");
                tipo.setNome(nomeTipo);

                daoTipo.inserir(tipo);
                resultadoTipo = "";

                resultadoTipo = listaTiposCadastrados();
            }
            request.getSession().setAttribute("resultadoTipo", resultadoTipo);
            response.sendRedirect(request.getContextPath() + "/paginas/tipoLista.jsp");
        }
    }

    protected String listaTipoId(String idTipo) {
        DAOTipo daoTipo = new DAOTipo();
        String tabela = "";
        List<Tipo> lista = daoTipo.listById(0);
        for (Tipo t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getIdTipo() + "</td>"
                    + "<td> " + t.getNome() + "</td>"
                    + "</tr>";
        }
        return tabela;
    }

    protected String listaTiposCadastrados() {
        DAOTipo daoTipo = new DAOTipo();
        String tabela = "";
        List<Tipo> lista = daoTipo.listInOrderNome();
        for (Tipo t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getIdTipo() + "</td>"
                    + "<td> " + t.getNome() + "</td>"
                    + "</tr>";
        }
        return tabela;
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
