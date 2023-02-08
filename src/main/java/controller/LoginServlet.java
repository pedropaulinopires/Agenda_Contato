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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    /**
     * 
     * metodo para fazer login
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
        //fazer o procedimento de login
        Login l = LoginDAO.buscarLoginEmail(request.getParameter("email"));
        if (l != null && l.getSenha().equals(request.getParameter("senha"))) {
            //usuário logado
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", l);
            response.sendRedirect("RedirecionarHomeServlet");
        } else {
            //usuário errado
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("erroLogin", "Erro de login");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
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
