package Repository;

import Config.DatabaseConfiguration;
import Domain.Vehicule.Cisterna;
import Service.AuditService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CisternaRepository {

    private final AuditService auditService = AuditService.getInstance();
    public void createCisterna(int volumLitri, String numarInmatriculare, int an, int km, String marca) {
        String insertSql = "INSERT INTO Cisterna (volumLitri, numar_inmatriculare, an, km, marca) VALUES (?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, volumLitri);
            preparedStatement.setString(2, numarInmatriculare);
            preparedStatement.setInt(3, an);
            preparedStatement.setInt(4, km);
            preparedStatement.setString(5, marca);

            preparedStatement.executeUpdate();
            auditService.logAction("Creare Cisterna");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCisternaObject(Cisterna cisterna) {
        if (cisterna == null) {
            System.out.println("Null Cisterna object provided.");
            return;
        }

        int volumLitri = cisterna.getVolumLitri();
        String numarInmatriculare = cisterna.getNumarInmatriculare();
        int an = cisterna.getAn();
        int km = cisterna.getKm();
        String marca = cisterna.getMarca();

        createCisterna(volumLitri, numarInmatriculare, an, km, marca);

        auditService.logAction("Creare Cisterna: " + cisterna.getMarca());
    }

    public ResultSet readCisterna(int id) {
        String selectSql = "SELECT * FROM Cisterna WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            auditService.logAction("Citire Cisterna cu id-ul " + id);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCisterna(int id, int volumLitri, String numarInmatriculare, int an, int km, String marca) {
        String updateSql = "UPDATE Cisterna SET volumLitri = ?, numar_inmatriculare = ?, an = ?, km = ?, marca = ? WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setInt(1, volumLitri);
            preparedStatement.setString(2, numarInmatriculare);
            preparedStatement.setInt(3, an);
            preparedStatement.setInt(4, km);
            preparedStatement.setString(5, marca);
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
            auditService.logAction("Update Cisterna cu id-ul " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCisterna(int id) {
        String deleteSql = "DELETE FROM Cisterna WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            auditService.logAction("Delete Cisterna cu id-ul " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllCisterna() {
        String selectSql = "SELECT * FROM Cisterna";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Volum Litri: " + resultSet.getInt("volumLitri"));
                System.out.println("Numar Inmatriculare: " + resultSet.getString("numar_inmatriculare"));
                System.out.println("An: " + resultSet.getInt("an"));
                System.out.println("KM: " + resultSet.getInt("km"));
                System.out.println("Marca: " + resultSet.getString("marca"));
                System.out.println("----------------------------");
            }
            auditService.logAction("Informatii Cisterne");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

