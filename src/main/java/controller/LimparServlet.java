package controller;

import bean.Login;
import dao.ContatoDAO;
import jakarta.servlet.RequestDispatcher;
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
@WebServlet(name = "LimparServlet", urlPatterns = {"/LimparServlet"})
public class LimparServlet extends HttpServlet {

    /**
     *
     * metodo para limpar a lista de contatos
     *
     *
     *
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            Login l = (Login) session.getAttribute("usuarioLogado");

            if ("M".equals(l.getSexo().toString())) {
                request.setAttribute("msg", "Olá, seja bem vindo " + l.getNome());
            } else {
                request.setAttribute("msg", "Olá, seja bem vinda " + l.getNome());
            }
            ContatoDAO.limparContatosPorIdLogin(l.getId());
            session.setAttribute("acao", "Lista limpada com sucesso!");
            //tratar a lista de contatos
            request.setAttribute("lista", ContatoDAO.buscarContatosPorIdLogin(l.getId()));
        } catch (Exception e) {
            System.out.println(e);
            session.setAttribute("erro", "Erro ao limpar lista!");
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
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
