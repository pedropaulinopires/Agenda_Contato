package controller;

import bean.Contato;
import bean.Login;
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
@WebServlet(name = "AdicionarContatoServlet", urlPatterns = {"/AdicionarContatoServlet"})
public class AdicionarContatoServlet extends HttpServlet {

    /**
     *
     * metodo para adicionar contato
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
        HttpSession session = request.getSession();
        try {
            Contato c = new Contato();
            //setando os atributos do Contato
            c.setNome(request.getParameter("nome"));
            String email = request.getParameter("email");
            if ("".equals(email) || " ".equals(email)) {
                email = "Não possui email!";
            }
            c.setEmail(email);
            c.setTelefone(request.getParameter("telefone"));
            //acessando o usuario logado
            Login l = (Login) session.getAttribute("usuarioLogado");
            session.setAttribute("acao", "Contato adicionado com sucesso!");
            c.setLogin(l);
            //contato adicionado
            ContatoDAO.adicionarContato(c);
        } catch (Exception e) {
            session.setAttribute("erro", "Erro ao adicionar contato !");
            System.out.println(e);
        } finally {
            response.sendRedirect("ContatosServlet");
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
