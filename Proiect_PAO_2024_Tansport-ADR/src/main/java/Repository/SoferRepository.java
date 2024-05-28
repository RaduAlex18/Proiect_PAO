package Repository;

import Config.DatabaseConfiguration;
import Domain.Angajati.Sofer;
import Service.AuditService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SoferRepository {

    private final AuditService auditService = AuditService.getInstance();

    public void createSofer(String nume, String prenume, int aniExperienta, int km, int camionId) {
        String insertSql = "INSERT INTO Sofer (nume, prenume, ani_experienta, km, camion_id) VALUES (?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2, prenume);
            preparedStatement.setInt(3, aniExperienta);
            preparedStatement.setInt(4, km);
            preparedStatement.setInt(5, camionId);

            preparedStatement.executeUpdate();
            auditService.logAction("Creare Sofer");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSoferObject(Sofer sofer) {
        if (sofer == null) {
            System.out.println("Null Sofer object provided.");
            return;
        }

        String nume = sofer.getNume();
        String prenume = sofer.getPrenume();
        int aniExperienta = sofer.getAni_experienta();
        int km = sofer.getKm();
        int camionId = getRandomCamionId();

        createSofer(nume, prenume, aniExperienta, km, camionId);

        auditService.logAction("Creare Sofer: " + sofer.getNume() + " " + sofer.getPrenume());
    }

    private int getRandomCamionId() {
        String selectSql = "SELECT id FROM Camion ORDER BY RAND() LIMIT 1";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public ResultSet readSofer(int id) {
        String selectSql = "SELECT * FROM Sofer WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            auditService.logAction("Citire Sofer cu id-ul " + id);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateSofer(int id, String nume, String prenume, int aniExperienta, int km, int camionId) {
        String updateSql = "UPDATE Sofer SET nume = ?, prenume = ?, ani_experienta = ?, km = ?, camion_id = ? WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2, prenume);
            preparedStatement.setInt(3, aniExperienta);
            preparedStatement.setInt(4, km);
            preparedStatement.setInt(5, camionId);
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
            auditService.logAction("Update Sofer cu id-ul " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSofer(int id) {
        String deleteSql = "DELETE FROM Sofer WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            auditService.logAction("Delete Sofer cu id-ul " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllSofer() {
        String selectSql = "SELECT * FROM Sofer";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nume: " + resultSet.getString("nume"));
                System.out.println("Prenume: " + resultSet.getString("prenume"));
                System.out.println("Ani Experienta: " + resultSet.getInt("ani_experienta"));
                System.out.println("KM: " + resultSet.getInt("km"));
                System.out.println("Camion ID: " + resultSet.getInt("camion_id"));
                System.out.println("----------------------------");
            }
            auditService.logAction("Informatii Soferi");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

