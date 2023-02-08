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
@WebServlet(name = "ContatosServlet", urlPatterns = {"/ContatosServlet"})
public class ContatosServlet extends HttpServlet {
    /**
     * metodo para carregar a lista de contatos do usuario
     * 
     * 
     *
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException */
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
            //tratar a lista de contatos
            request.setAttribute("lista", ContatoDAO.buscarContatosPorIdLogin(l.getId()));

        } catch (Exception e) {
            session.setAttribute("erro", "Erro ao carregar lista !");
            System.out.println(e);
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
