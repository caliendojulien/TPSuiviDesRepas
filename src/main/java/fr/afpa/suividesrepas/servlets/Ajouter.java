package fr.afpa.suividesrepas.servlets;

import fr.afpa.suividesrepas.bo.Aliment;
import fr.afpa.suividesrepas.bo.Repas;
import fr.afpa.suividesrepas.dal.AlimentsSQL;
import fr.afpa.suividesrepas.dal.RepasSQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@WebServlet("/ajouter")
public class Ajouter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/ajouter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        String heure = request.getParameter("heure");
        Date laDateAInserer = Date.valueOf(date);
        Time lHeureAInserer = Time.valueOf(LocalTime.parse(heure));
        RepasSQL repasSQL = new RepasSQL();
        repasSQL.insert(laDateAInserer, lHeureAInserer);
        Repas dernierRepas = repasSQL.selectDernierRepas();

        AlimentsSQL alimentsSQL = new AlimentsSQL();
        String aliments = request.getParameter("aliments");
        String[] tabAliments = aliments.split(",");
        for (String aliment : tabAliments) {
            alimentsSQL.insert(aliment, dernierRepas.getId());
        }

        request.getRequestDispatcher("WEB-INF/ajouter.jsp").forward(request, response);
    }
}
