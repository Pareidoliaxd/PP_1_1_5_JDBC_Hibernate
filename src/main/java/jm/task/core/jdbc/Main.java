package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static UserServiceImpl userService = new UserServiceImpl();

        public static void main(String[] args) {
            userService.createUsersTable();
            createUserPack();
            userService.getAllUsers().forEach(System.out::println);
            userService.cleanUsersTable();
            userService.dropUsersTable();
        }

    public static void createUserPack() {
        userService.saveUser("Vasya", "Pupkin", (byte)50);
        System.out.println("User с именем Vasya– name добавлен в базу данных");
        userService.saveUser("Leonid", "Pavlov", (byte)24);
        System.out.println("User с именем Leonid – name добавлен в базу данных");
        userService.saveUser("Sergey", "Olegovich", (byte)35);
        System.out.println("User с именем Sergey – name добавлен в базу данных");
        userService.saveUser("Dead", "Pool", (byte)32);
        System.out.println("User с именем Dead – name добавлен в базу данных");
    }
}
