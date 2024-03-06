package web;

import web.config.AppConfig;
import web.model.User;
import web.service.UserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        userService.addUser(context.getBean(User.class,"User1", "Lastname1", "user1@mail.ru"));
        userService.addUser(context.getBean(User.class,"User2", "Lastname2", "user2@mail.ru"));



        context.close();
    }
}