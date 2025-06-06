package dbataev.dao;

import dbataev.db.DataBase;
import dbataev.model.Users;
import dbataev.service.Menu;
import dbataev.service.UserService;
import dbataev.util.PasswordHasher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {
    Connection connect = DataBase.getConnection();

    public boolean checkUserByLogin(String login){
        String sql = "SELECT 1 FROM users WHERE login = ? LIMIT 1";

        try (PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, login);

            try(ResultSet rs = ps.executeQuery();) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при попытке найти пользователя в системе!");
            throw new RuntimeException(e);
        }
    }
    public boolean createUser(String login, String pwd){
        String sql = "INSERT INTO users (login, pwd) VALUES (?, ?)";

        String hash = PasswordHasher.hashPassword(pwd);

        try(PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.setString(2, hash);
            ps.executeUpdate();
            System.out.println("Пользователь успешно создан!");
            return true;

        } catch (SQLException e) {
            System.out.println("Произошла ошибка при регистрации пользователя");
            throw new RuntimeException(e);
        }

    }
    public Users loginUser(String login, String pwd){
        String sql = "SELECT * FROM users WHERE login = ?";

        if(!checkUserByLogin(login)){
            System.out.println("Пользователь с таким логином не найден!");
            return null;

        }
        else {
            try(PreparedStatement pr = connect.prepareStatement(sql)){
                pr.setString(1, login);
                try(ResultSet rs = pr.executeQuery()) {
                    rs.next();
                    if (PasswordHasher.checkPassword(pwd, rs.getString("pwd"))){
                            Users user = new Users();
                            user.setId(rs.getInt("id"));
                            user.setLogin(rs.getString("login"));
                            user.setPwd(rs.getString("pwd"));

                            return user;
                    }
                    else {
                        System.out.println("Пароль не верный!");
                        Menu.start();
                    }
                }
            } catch (SQLException e) {
                System.out.println("Ошибка при входе в аккаует");
                throw new RuntimeException(e);
            }
        };
        return null;
    }
}
