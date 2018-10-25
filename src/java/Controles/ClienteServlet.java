/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOCliente;
import Entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cássio
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/clienteLista"})
public class ClienteServlet extends HttpServlet {

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
        String cpfCliente = "";
        String nomeCliente = "";
        String nascCliente = "";
        String loginCliente = "";
        String senhaCliente = "";
        String telefoneCliente = "";
        String enderecoCliente = "";
        DAOCliente daoCliente = new DAOCliente();
        Cliente cliente = new Cliente();
        try (PrintWriter out = response.getWriter()) {
            cpfCliente = request.getParameter("cpfCliente");
            cliente.setCpf(cpfCliente);

            nomeCliente = request.getParameter("nomeCliente");
            cliente.setNome(nomeCliente);
            
            nascCliente = request.getParameter("nascCliente");
            try {
                cliente.setDataNascimento(sdf.parse(nascCliente));
            } catch (ParseException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            loginCliente = request.getParameter("loginCliente");
            cliente.setLogin(loginCliente);
            
            senhaCliente = request.getParameter("senhaCliente");
            cliente.setSenha(senhaCliente);
            
            telefoneCliente = request.getParameter("telefoneCliente");
            cliente.setNumeroTelefone(telefoneCliente);
            
            enderecoCliente = request.getParameter("enderecoCliente");
            cliente.setEndereco(enderecoCliente);
            
            daoCliente.inserir(cliente);
            String resultadoCliente = "";

            resultadoCliente = listaClientesCadastrados();

            request.getSession().setAttribute("resultadoCliente", resultadoCliente);
            response.sendRedirect(request.getContextPath() + "/paginas/clienteLista.jsp");
        }
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    protected String listaClienteId(String idCliente) {
        DAOCliente daoCliente = new DAOCliente();
        String tabela = "";
        List<Cliente> lista = daoCliente.listById(0);
        for (Cliente c : lista) {
            tabela += "<tr>"
                    + "<td> " + c.getCpf() + "</td>"
                    + "<td> " + c.getNome() + "</td>"
                    + "<td> " + sdf.format(c.getDataNascimento()) + "</td>"
                    + "<td> " + c.getLogin() + "</td>"
                    + "<td> " + c.getSenha() + "</td>"
                    + "<td> " + c.getNumeroTelefone() + "</td>"
                    + "<td> " + c.getEndereco() + "</td>"
                    + "</tr>";
        }
        return tabela;
    }

    protected String listaClientesCadastrados() {
        DAOCliente daoCliente = new DAOCliente();
        String tabela = "";
        List<Cliente> lista = daoCliente.listInOrderNome();
        for (Cliente c : lista) {
            tabela += "<tr>"
                    + "<td> " + c.getCpf() + "</td>"
                    + "<td> " + c.getNome() + "</td>"
                    + "<td> " + sdf.format(c.getDataNascimento()) + "</td>"
                    + "<td> " + c.getLogin() + "</td>"
                    + "<td> " + c.getSenha() + "</td>"
                    + "<td> " + c.getNumeroTelefone() + "</td>"
                    + "<td> " + c.getEndereco() + "</td>"
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
        System.out.println("teste doget");
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
        System.out.println("teste dopost");
    }

    /**
     * Returns a short deion of the servlet.
     *
     * @return a String containing servlet deion
     */
    @Override
    public String getServletInfo() {
        return "Short deion";
    }// </editor-fold>

}
