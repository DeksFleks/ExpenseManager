package dbataev.dao;

import dbataev.db.DataBase;

import java.sql.Connection;

public class ExpenseDAO {
    Connection connect = DataBase.getConnection();
}
