package Config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupData {

    public void createCamionTable() {
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS Camion (
                id INT PRIMARY KEY AUTO_INCREMENT,
                marca VARCHAR(50),
                numar_inmatriculare VARCHAR(10) UNIQUE,
                an INT,
                km INT,
                culoare VARCHAR(20),
                capacitate_motor INT
            )
            """;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSoferTable() {
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS Sofer (
                id INT PRIMARY KEY AUTO_INCREMENT,
                nume VARCHAR(50),
                prenume VARCHAR(50),
                ani_experienta INT,
                km INT,
                camion_id INT,
                FOREIGN KEY (camion_id) REFERENCES Camion(id)
            )
            """;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCisternaTable() {
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS Cisterna (
                id INT PRIMARY KEY AUTO_INCREMENT,
                volumLitri INT,
                numar_inmatriculare VARCHAR(10) UNIQUE,
                an INT,
                km INT,
                marca VARCHAR(50)
            )
            """;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTahografTable() {
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS Tahograf (
                id INT PRIMARY KEY AUTO_INCREMENT,
                camion_id INT UNIQUE,
                dataInregistrare DATE,
                kilometri_parcursi INT,
                ore_conduse INT,
                FOREIGN KEY (camion_id) REFERENCES Camion(id)
            )
            """;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
