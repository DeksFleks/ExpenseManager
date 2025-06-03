package dbataev.dao;

import dbataev.db.DataBase;

import java.sql.Connection;

public class CategoryDAO {
    Connection connect = DataBase.getConnection();
}
