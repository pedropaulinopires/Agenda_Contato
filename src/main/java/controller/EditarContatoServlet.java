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
@WebServlet(name = "EditarContatoServlet", urlPatterns = {"/EditarContatoServlet"})
public class EditarContatoServlet extends HttpServlet {

    /**
     *
     *
     * metodo para editar contato
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
            Login l = (Login) session.getAttribute("usuarioLogado");
            Contato c = new Contato();
            c.setId(Long.parseLong(request.getParameter("id")));
            c.setNome(request.getParameter("nome"));
            String email = request.getParameter("email");
            if ("".equals(email) || " ".equals(email)) {
                email = "Não possui email!";
            }
            c.setEmail(email);
            c.setTelefone(request.getParameter("telefone"));
            c.setLogin(l);
            ContatoDAO.atualizarContato(c);
            session.setAttribute("acao", "Contato editado com sucesso!");

        } catch (Exception e) {
            System.out.println(e);
            session.setAttribute("erro", "Erro ao editar contato !");
        } finally {
            response.sendRedirect("RedirecionarHomeServlet");
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
