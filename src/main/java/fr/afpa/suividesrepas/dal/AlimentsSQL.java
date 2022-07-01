package fr.afpa.suividesrepas.dal;

import fr.afpa.suividesrepas.bo.Aliment;

import java.sql.*;
import java.util.ArrayList;

public class AlimentsSQL {
    private final String SELECT = "SELECT id, nom, id_repas FROM aliments;";
    private final String SELECT_BY_REPAS_ID = "SELECT id, nom, id_repas FROM aliments WHERE id_repas=?;";
    private final String INSERT = "INSERT INTO aliments (nom, id_repas) VALUES(?, ?);";

    public ArrayList<Aliment> selectAll() {
        ArrayList<Aliment> lesAliments = new ArrayList<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Aliment aliment = new Aliment(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getInt("id_repas")
                );
                lesAliments.add(aliment);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lesAliments;
    }

    public void insert(String nom, int id_repas) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, nom);
            preparedStatement.setInt(2, id_repas);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Aliment> select(int id) {
        ArrayList<Aliment> lesAliments = new ArrayList<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_REPAS_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Aliment aliment = new Aliment(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getInt("id_repas")
                );
                lesAliments.add(aliment);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lesAliments;
    }
}
