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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "EditarLoginServlet", urlPatterns = {"/EditarLoginServlet"})
public class EditarLoginServlet extends HttpServlet {

    //criado o objeto login para utilizar no doGet e doPost
    Login l;

    /**
     *
     * metodo para redirecionar para a pagina de editar login
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
        //redirecionar para a pagina de editar
        HttpSession session = request.getSession();
        l = (Login) session.getAttribute("usuarioLogado");
        request.setAttribute("nome", l.getNome());
        request.setAttribute("sobrenome", l.getSobrenome());
        request.setAttribute("email", l.getEmail());
        request.setAttribute("senha", l.getSenha());
        request.setAttribute("sexo", l.getSexo().toString());
        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
        rd.forward(request, response);
    }

    /**
     *
     * metodo para editar o login
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
        //processar a edição do login
        //pegar os dados do usuario
        HttpSession session = request.getSession();
        l = (Login) session.getAttribute("usuarioLogado");
        //pegar o email
        String email = request.getParameter("email");
        Login l1;
        //procurar se existe se o email for diferente
        if (!l.getEmail().equals(email)) {
            l1 = LoginDAO.buscarLoginEmail(email);
            if (l1 == null) {
                l.setNome(request.getParameter("nome"));
                request.setAttribute("nome", request.getParameter("nome"));

                l.setSobrenome(request.getParameter("sobrenome"));
                request.setAttribute("sobrenome", request.getParameter("sobrenome"));

                l.setEmail(email);
                request.setAttribute("email", email);

                l.setSenha(request.getParameter("senha"));
                request.setAttribute("senha", request.getParameter("senha"));

                String sexo = request.getParameter("sexo");
                if (sexo.equals("M")) {
                    l.setSexo(Sexo.M);
                    request.setAttribute("sexo", "M");
                } else {
                    l.setSexo(Sexo.F);
                    request.setAttribute("sexo", "F");
                }
                LoginDAO.atualizarLogin(l);
                request.setAttribute("exitoEditar", "Edição feita com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);

            } else {
                //redirecionar para o erro
                request.setAttribute("nome", request.getParameter("nome"));
                request.setAttribute("sobrenome", request.getParameter("sobrenome"));
                request.setAttribute("email", email);
                request.setAttribute("senha", request.getParameter("senha"));
                String sexo = request.getParameter("sexo");
                if (sexo.equals("M")) {
                    request.setAttribute("sexo", "M");
                } else {
                    request.setAttribute("sexo", "F");
                }

                request.setAttribute("erroEditar", "erro ao editar!");
                RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
                rd.forward(request, response);
            }
        } else {
            l.setNome(request.getParameter("nome"));
            request.setAttribute("nome", request.getParameter("nome"));

            l.setSobrenome(request.getParameter("sobrenome"));
            request.setAttribute("sobrenome", request.getParameter("sobrenome"));

            l.setEmail(email);
            request.setAttribute("email", email);

            l.setSenha(request.getParameter("senha"));
            request.setAttribute("senha", request.getParameter("senha"));

            String sexo = request.getParameter("sexo");
            if (sexo.equals("M")) {
                l.setSexo(Sexo.M);
                request.setAttribute("sexo", "M");
            } else {
                l.setSexo(Sexo.F);
                request.setAttribute("sexo", "F");
            }
            LoginDAO.atualizarLogin(l);
            request.setAttribute("exitoEditar", "Edição feita com sucesso!");
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
