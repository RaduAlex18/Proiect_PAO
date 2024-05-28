package Repository;

import Config.DatabaseConfiguration;
import Domain.Tahograf.Tahograf;
import Service.AuditService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class TahografRepository {

    private final AuditService auditService = AuditService.getInstance();

    public void createTahograf(int camionId, Date dataInregistrare, int kilometriParcursi, int oreConduse) {
        String insertSql = "INSERT INTO Tahograf (camion_id, dataInregistrare, kilometri_parcursi, ore_conduse) VALUES (?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, camionId);
            preparedStatement.setDate(2, dataInregistrare);
            preparedStatement.setInt(3, kilometriParcursi);
            preparedStatement.setInt(4, oreConduse);

            preparedStatement.executeUpdate();
            auditService.logAction("Creare Tahograf");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTahografObject(Tahograf tahograf) {
        if (tahograf == null) {
            System.out.println("Null Tahograf object provided.");
            return;
        }

        int camionId = getAvailableCamionId();
        if (camionId == -1) {
            System.out.println("No available camionId found.");
            return;
        }

        Date dataInregistrare = (Date) tahograf.getDataInregistrare();
        int kilometriParcursi = tahograf.getKilometriParcursi();
        int oreConduse = tahograf.getOreConduse();

        createTahograf(camionId, dataInregistrare, kilometriParcursi, oreConduse);

        auditService.logAction("Creare Tahograf de tip obiect");
    }

    private int getAvailableCamionId() {
        Set<Integer> usedCamionIds = new HashSet<>();
        String usedCamionIdsSql = "SELECT camion_id FROM Tahograf";
        String availableCamionIdSql = "SELECT id FROM Camion WHERE id NOT IN (SELECT camion_id FROM Tahograf) ORDER BY RAND() LIMIT 1";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(usedCamionIdsSql);

            while (resultSet.next()) {
                usedCamionIds.add(resultSet.getInt("camion_id"));
            }

            resultSet = statement.executeQuery(availableCamionIdSql);

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public ResultSet readTahograf(int id) {
        String selectSql = "SELECT * FROM Tahograf WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            auditService.logAction("Citire Tahograf cu id-ul " + id);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateTahograf(int id, int camionId, Date dataInregistrare, int kilometriParcursi, int oreConduse) {
        String updateSql = "UPDATE Tahograf SET camion_id = ?, dataInregistrare = ?, kilometri_parcursi = ?, ore_conduse = ? WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setInt(1, camionId);
            preparedStatement.setDate(2, dataInregistrare);
            preparedStatement.setInt(3, kilometriParcursi);
            preparedStatement.setInt(4, oreConduse);
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
            auditService.logAction("Update Tahograf cu id-ul " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTahograf(int id) {
        String deleteSql = "DELETE FROM Tahograf WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            auditService.logAction("Delete Tahograf cu id-ul " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllTahograf() {
        String selectSql = "SELECT * FROM Tahograf";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Camion ID: " + resultSet.getInt("camion_id"));
                System.out.println("Data Inregistrare: " + resultSet.getDate("dataInregistrare"));
                System.out.println("Kilometri Parcursi: " + resultSet.getInt("kilometri_parcursi"));
                System.out.println("Ore Conduse: " + resultSet.getInt("ore_conduse"));
                System.out.println("----------------------------");
            }
            auditService.logAction("Informatii Tahografe");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

