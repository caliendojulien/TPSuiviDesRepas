package fr.afpa.suividesrepas.dal;

import fr.afpa.suividesrepas.bo.Repas;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class RepasSQL {
    private final String SELECT = "SELECT id, date_repas, heure_repas FROM repas;";
    private final String INSERT = "INSERT INTO repas (date_repas, heure_repas) VALUES(?, ?);";
    private final String SELECT_DERNIER_REPAS =
            "SELECT id, date_repas, heure_repas FROM repas ORDER BY id DESC LIMIT 1";

    public ArrayList<Repas> selectAll() {
        ArrayList<Repas> lesRepas= new ArrayList<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Repas repas = new Repas(
                        resultSet.getInt("id"),
                        resultSet.getDate("date_repas"),
                        resultSet.getTime("heure_repas")
                );
                lesRepas.add(repas);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lesRepas;
    }

    public void insert(Date date, Time heure) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setDate(1, date);
            preparedStatement.setTime(2, heure);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Repas selectDernierRepas() {
        Repas repas = null;
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DERNIER_REPAS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                repas = new Repas(
                        resultSet.getInt("id"),
                        resultSet.getDate("date_repas"),
                        resultSet.getTime("heure_repas")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return repas;
    }
}
