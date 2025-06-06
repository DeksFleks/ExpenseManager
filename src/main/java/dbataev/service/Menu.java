package dbataev.service;

import dbataev.dao.UsersDAO;
import dbataev.model.Users;

import java.util.Scanner;

public class Menu {
    public static void start(){
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        UsersDAO userDAO = new UsersDAO();

        System.out.print("=========== Expense Manger ===========\n" +
                "1. Регистрация\n" +
                "2. Вход\n" +
                "0. Выход\n" +
                "===============\n" +
                "Введите число: ");
        int menu = scanner.nextInt();
        scanner.nextLine();

        if(menu == 1){
            userService.registerUser();
        } else if(menu == 2){
            Users user = userService.login();
            System.out.println(user.toString());
        } else {
            return;
        }
    }
}
