package Repository;

import Config.DatabaseConfiguration;
import Domain.Vehicule.Camion;
import Service.AuditService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CamionRepository {

    private final AuditService auditService = AuditService.getInstance();

    public void createCamion(String marca, String numarInmatriculare, int an, int km, String culoare, int capacitateMotor) {
        String insertSql = "INSERT INTO Camion (marca, numar_inmatriculare, an, km, culoare, capacitate_motor) VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, marca);
            preparedStatement.setString(2, numarInmatriculare);
            preparedStatement.setInt(3, an);
            preparedStatement.setInt(4, km);
            preparedStatement.setString(5, culoare);
            preparedStatement.setInt(6, capacitateMotor);

            preparedStatement.executeUpdate();
            auditService.logAction("Creare Camion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCamionObject(Camion camion) {
        if (camion == null) {
            System.out.println("Null Camion object provided.");
            return;
        }

        String marca = camion.getMarca();
        String numarInmatriculare = camion.getNumarInmatriculare();
        int an = camion.getAn();
        int km = camion.getKm();
        String culoare = camion.getCuloare();
        int capacitateMotor = camion.getCapacitate_motor();

        createCamion(marca, numarInmatriculare, an, km, culoare, capacitateMotor);

        auditService.logAction("Creare Camion: " + camion.getMarca());
    }

    public ResultSet readCamion(int id) {
        String selectSql = "SELECT * FROM Camion WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            auditService.logAction("Citire Camion cu id-ul " + id);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCamion(int id, String marca, String numarInmatriculare, int an, int km, String culoare, int capacitateMotor) {
        String updateSql = "UPDATE Camion SET marca = ?, numar_inmatriculare = ?, an = ?, km = ?, culoare = ?, capacitate_motor = ? WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, marca);
            preparedStatement.setString(2, numarInmatriculare);
            preparedStatement.setInt(3, an);
            preparedStatement.setInt(4, km);
            preparedStatement.setString(5, culoare);
            preparedStatement.setInt(6, capacitateMotor);
            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();

            auditService.logAction("Update Camion cu id-ul " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCamion(int id) {
        String deleteSql = "DELETE FROM Camion WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            auditService.logAction("Delete Camion cu id-ul " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllCamion() {
        String selectSql = "SELECT * FROM Camion";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Marca: " + resultSet.getString("marca"));
                System.out.println("Numar Inmatriculare: " + resultSet.getString("numar_inmatriculare"));
                System.out.println("An: " + resultSet.getInt("an"));
                System.out.println("KM: " + resultSet.getInt("km"));
                System.out.println("Culoare: " + resultSet.getString("culoare"));
                System.out.println("Capacitate Motor: " + resultSet.getInt("capacitate_motor"));
                System.out.println("----------------------------");
            }
            auditService.logAction("Informatii Camioane");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

