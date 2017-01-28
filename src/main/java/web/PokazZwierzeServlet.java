package web;

import dao.RepositoryCatalogue;
import dao.ZwierzetaRepository;
import dao.model.Zwierze;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TKK on 2017-01-27.
 */
@WebServlet("/pokazZwierzeServlet")
public class PokazZwierzeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idZwierze = (String) request.getParameter("id");

        try {

            RepositoryCatalogue rp = new RepositoryCatalogue();
            ZwierzetaRepository zwr = rp.zwierzetaRepository();
            Zwierze pobraneZwierze = zwr.get(Integer.parseInt(idZwierze));

            request.getSession().setAttribute("zwierze", pobraneZwierze);
            rp.close();

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("blad_dodawania_zwierzaka.html");
        } catch(Exception ex){
            ex.printStackTrace();
            response.sendRedirect("blad_dodawania_zwierzaka.html");
        }

        response.sendRedirect("pokazZwierze.jsp");
    }

}