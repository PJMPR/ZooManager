
/**
 * Created by TKK on 2017-01-28.
 */

package web;

import dao.RepositoryCatalogue;
import dao.ZwierzetaRepository;
import dao.model.Zwierze;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    @WebServlet("/UsunZwierzeServlet")
    public class UsunZwierzeServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String IdZwierze = (String) request.getParameter("idZwierze");

            try {

                RepositoryCatalogue rp = new RepositoryCatalogue();
                ZwierzetaRepository zwr = rp.zwierzetaRepository();
                Zwierze pobraneZwierze = zwr.get(Integer.parseInt(IdZwierze));
                zwr.delete(pobraneZwierze);
                request.getSession().setAttribute("zwierze",null);
                rp.close();

            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("blad_usuwania_zwierzaka.html");
            } catch(Exception ex){
                ex.printStackTrace();
                response.sendRedirect("blad_usuwania_zwierzaka.html");
            }

            response.sendRedirect("pokazZwierzeta.jsp");
        }



    }
