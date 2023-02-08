package controller;

import bean.Contato;
import dao.ContatoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "ExcluirContatoServlet", urlPatterns = {"/ExcluirContatoServlet"})
public class ExcluirContatoServlet extends HttpServlet {
    /**
     * 
     * metodo para excluir contato
     * 
     * 
     * 
     *
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       //excluir o contato
        Contato c = new Contato();
        c.setId(Long.parseLong(request.getParameter("id")));
        System.out.println("Contato id"+request.getParameter("id"));
        ContatoDAO.removerContato(c);
        HttpSession session = request.getSession();
        session.setAttribute("acao", "Contato removido com sucesso!");
        response.sendRedirect("RedirecionarHomeServlet");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
