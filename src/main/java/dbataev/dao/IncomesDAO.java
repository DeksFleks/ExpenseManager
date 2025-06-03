package dbataev.dao;

import dbataev.db.DataBase;

import java.sql.Connection;

public class IncomesDAO {
    Connection connect = DataBase.getConnection();
}
