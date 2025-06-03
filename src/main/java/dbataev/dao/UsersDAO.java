package dbataev.dao;

import dbataev.db.DataBase;

import java.sql.Connection;

public class UsersDAO {
    Connection connect = DataBase.getConnection();
}
