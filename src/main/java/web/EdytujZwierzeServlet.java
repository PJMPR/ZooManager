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

/**
 * Created by TKK on 2017-01-27.
 */

@WebServlet("/EdytujZwierzeServlet")
public class EdytujZwierzeServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            Zwierze zwierzeZSesji=(Zwierze) request.getSession().getAttribute("zwierze");

            //String idZwierze = (String) request.getParameter("id");

            String nazwa = (String) request.getParameter("nazwa");
            Integer poziomNajedzenia = Integer.parseInt((String) request.getParameter("poziomnajedzenia"));
            Integer tempoJedzenia = Integer.parseInt((String) request.getParameter("tempojedzenia"));

            zwierzeZSesji.setNazwa(nazwa);
            zwierzeZSesji.setPoziomNajedzenia(poziomNajedzenia);
            zwierzeZSesji.setTempoJedzenia(tempoJedzenia);

            request.getSession().setAttribute("zwierze", zwierzeZSesji);

            try {

                RepositoryCatalogue rp = new RepositoryCatalogue();
                ZwierzetaRepository zwr = rp.zwierzetaRepository();

                zwr.update(zwierzeZSesji);
                rp.close();

            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("blad_edycji_zwierzaka.html");
            } catch(Exception ex){
                ex.printStackTrace();
                response.sendRedirect("blad_edycji_zwierzaka.html");
            }

            response.sendRedirect("pokazZwierzeta.jsp");
        }

    }
