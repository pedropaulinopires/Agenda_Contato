package controller;

import bean.Login;
import dao.LoginDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "RecuperarLoginServlet", urlPatterns = {"/RecuperarLoginServlet"})
public class RecuperarLoginServlet extends HttpServlet {

    /**
     * metodo para recuperar login
     *
     *
     *
     *
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperar a senha
        Login l = LoginDAO.buscarLoginEmail(request.getParameter("email"));
        if (l != null) {
            request.setAttribute("exito", "senha encontrada");
            request.setAttribute("senha", l.getSenha());
            RequestDispatcher rd = request.getRequestDispatcher("esqueceu.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("erro", "email errado");
            request.setAttribute("email", request.getParameter("email"));
            RequestDispatcher rd = request.getRequestDispatcher("esqueceu.jsp");
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
