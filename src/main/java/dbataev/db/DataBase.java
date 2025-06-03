package dbataev.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    final private static String URL = "jdbc:postgresql://dpg-d0pkslre5dus73duoetg-a.oregon-postgres.render.com/expensemanager_0c41";
    final private static String NAME = "expensemanager_0c41_user";
    final private static String PWD = "yLsdHpScN7UTgACGGKl81Bh4ghDE1b4C";

    public static Connection getConnection(){
        try {
            System.out.println("Начало...");
            Connection connect = DriverManager.getConnection(URL, NAME, PWD);
            return connect;
        } catch (SQLException e) {
            System.out.println("Ошибка подключения базы данных!");
            System.out.println("Not Good :(");
            throw new RuntimeException(e);
        }
    }
}
