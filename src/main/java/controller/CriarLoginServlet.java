package controller;

import bean.Login;
import bean.Sexo;
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
@WebServlet(name = "CriarLoginServlet", urlPatterns = {"/CriarLoginServlet"})
public class CriarLoginServlet extends HttpServlet {
    /**
     * 
     * 
     * metodo para criar conta de login
     * 
     *
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processar a criação da conta
        Login l = LoginDAO.buscarLoginEmail(request.getParameter("email"));
        if (l == null) {
            //criar a conta
            l = new Login();
            l.setEmail(request.getParameter("email"));
            l.setNome(request.getParameter("nome"));
            l.setSobrenome(request.getParameter("sobrenome"));
            l.setSenha(request.getParameter("senha"));
            if (request.getParameter("sexo").equals("M")) {
                l.setSexo(Sexo.M);
            } else {
                l.setSexo(Sexo.F);
            }
            request.setAttribute("exitoConta", "Conta criada com sucesso!");
            LoginDAO.adicionarLogin(l);
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } else {
            //informar que a conta ja existe
            request.setAttribute("nome", request.getParameter("nome"));
            request.setAttribute("sobrenome", request.getParameter("sobrenome"));
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("senha", request.getParameter("senha"));
            request.setAttribute("sexo", request.getParameter("sexo"));
            request.setAttribute("erroCriar", "erro");
            RequestDispatcher rd = request.getRequestDispatcher("criar.jsp");
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
