/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOMarca;
import DAOs.DAOProduto;
import DAOs.DAOTipo;
import Entidades.Marca;
import Entidades.Produto;
import Entidades.Tipo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/produtoLista"})
public class ProdutoServlet extends HttpServlet {

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
        String idProduto = "";
        String nomeProduto = "";
        String especProduto = "";
        String precoProduto = "";
        String tipoProduto = "";
        String marcaProduto = "";
        DAOProduto daoProduto = new DAOProduto();
        Produto produto = new Produto();
        try (PrintWriter out = response.getWriter()) {
            idProduto = request.getParameter("idProduto");
            produto.setIdProduto(daoProduto.autoIdProduto());

            nomeProduto = request.getParameter("nomeProduto");
            produto.setNome(nomeProduto);

            especProduto = request.getParameter("especProduto");
            produto.setEspecificacoes(especProduto);

            precoProduto = request.getParameter("precoProduto");
            produto.setPreco(Double.valueOf(precoProduto));

            DAOMarca daoMarca = new DAOMarca();
            Integer marcaId = Integer.valueOf(request.getParameter("marcaProduto"));
            Marca marca = daoMarca.listById(marcaId).get(0);
            produto.setIdMarca(daoMarca.obter(marcaId));

            DAOTipo daoTipo = new DAOTipo();
            Integer tipoId = Integer.valueOf(request.getParameter("tipoProduto"));
            Tipo tipo = daoTipo.listById(tipoId).get(0);
            produto.setIdTipo(daoTipo.obter(tipoId));

            daoProduto.inserir(produto);
            String resultadoProduto = "";

            resultadoProduto = listaProdutosCadastrados();

            request.getSession().setAttribute("resultadoProduto", resultadoProduto);
            response.sendRedirect(request.getContextPath() + "/paginas/produtoLista.jsp");
        }
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    protected String listaProdutoId(String idProduto) {
        DAOProduto daoProduto = new DAOProduto();
        String tabela = "";
        List<Produto> lista = daoProduto.listById(0);
        for (Produto c : lista) {
            tabela += "<tr>"
                    + "<td> " + c.getIdProduto() + "</td>"
                    + "<td> " + c.getNome() + "</td>"
                    + "<td> " + c.getEspecificacoes() + "</td>"
                    + "<td> " + c.getPreco() + "</td>"
                    + "<td> " + c.getIdTipo() + "</td>"
                    + "<td> " + c.getIdMarca() + "</td>"
                    + "</tr>";
        }
        return tabela;
    }

    protected String listaProdutosCadastrados() {
        DAOProduto daoProduto = new DAOProduto();
        String tabela = "";
        List<Produto> lista = daoProduto.listInOrderNome();
        for (Produto c : lista) {
            tabela += "<tr>"
                    + "<td> " + c.getIdProduto() + "</td>"
                    + "<td> " + c.getNome() + "</td>"
                    + "<td> " + c.getEspecificacoes() + "</td>"
                    + "<td> " + c.getPreco() + "</td>"
                    + "<td> " + c.getIdTipo() + "</td>"
                    + "<td> " + c.getIdMarca() + "</td>"
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
