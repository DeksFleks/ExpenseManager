package dbataev.service;

import dbataev.dao.UsersDAO;
import dbataev.model.Users;

import java.util.Scanner;

public class UserService {
    UsersDAO usersDAO = new UsersDAO();
    Menu menuApp = new Menu();
    Scanner scanner = new Scanner(System.in);

    public void registerUser(){
        System.out.print("Веддите логин: ");
        String login = scanner.nextLine();

        if (usersDAO.checkUserByLogin(login)){
            System.out.println("Логин уже занят!\n" +
                    "1. Вход\n" +
                    "2. Регистрация\n" +
                    "0. Выход");
            int menu = scanner.nextInt();
            scanner.nextLine();

            if(menu == 1){
                login();
            } else if(menu == 2){
                registerUser();
            } else {
                menuApp.start();
            }
        }

        System.out.print("Введите пароль: ");
        String pwd = scanner.nextLine();

        usersDAO.createUser(login, pwd);
    }
    public Users login(){
        System.out.print("Веддите логин: ");
        String login = scanner.nextLine();

        if (!usersDAO.checkUserByLogin(login)){
            System.out.println("Пользователя с таким логином не существет!");
            System.out.println("Хотите зарегистрироваться?\n" +
                    "1. Да\n" +
                    "2. Попробовать еще раз\n" +
                    "0. Выход");
            int menu = scanner.nextInt();
            scanner.nextLine();

            if(menu == 1){
                registerUser();
            } else if(menu == 2){
                login();
            }
            else {
                menuApp.start();
            }
        }

        System.out.print("Введите пароль: ");
        String pwd = scanner.nextLine();

        return usersDAO.loginUser(login, pwd);
    }
}
