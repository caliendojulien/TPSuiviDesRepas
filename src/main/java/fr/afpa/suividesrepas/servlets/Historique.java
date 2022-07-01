package fr.afpa.suividesrepas.servlets;

import fr.afpa.suividesrepas.bo.Aliment;
import fr.afpa.suividesrepas.bo.Repas;
import fr.afpa.suividesrepas.dal.AlimentsSQL;
import fr.afpa.suividesrepas.dal.RepasSQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/historique")
public class Historique extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RepasSQL repasSQL = new RepasSQL();
        ArrayList<Repas> lesRepas = repasSQL.selectAll();

        for (Repas repas : lesRepas) {
            AlimentsSQL alimentsSQL = new AlimentsSQL();
            ArrayList<Aliment>  alimentsDuRepas = alimentsSQL.select(repas.getId());
            repas.setAliments(alimentsDuRepas);
        }

        request.setAttribute("lesRepas", lesRepas);
        request.getRequestDispatcher("WEB-INF/historique.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
