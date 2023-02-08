package controller;

import bean.Contato;
import bean.Login;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.ContatoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "RelatorioServlet", urlPatterns = {"/RelatorioServlet"})
public class RelatorioServlet extends HttpServlet {
    /**
     * 
     * matodo para fazer o relatório de contatos
     * 
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
        Document document = new Document();
        HttpSession session = request.getSession();
        Login l = (Login) session.getAttribute("usuarioLogado");
        try {
            response.setContentType("Apllication/pdf");
            response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            document.add(new Paragraph("Relatório de contatos:"));
            document.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(3);
            table.addCell(new PdfPCell(new Paragraph("Nome")));
            table.addCell(new PdfPCell(new Paragraph("Telefone")));
            table.addCell(new PdfPCell(new Paragraph("E-mail")));
            ArrayList<Contato> c = ContatoDAO.buscarContatosPorIdLogin(l.getId());
            for (Contato contato : c) {
                table.addCell(contato.getNome());
                table.addCell(contato.getTelefone());
                table.addCell(contato.getEmail());
            }
            document.add(table);
            document.close();
        } catch (DocumentException | IOException e) {
            System.out.println("Erro de relatório ==>> " + e.getMessage());
            document.close();
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
