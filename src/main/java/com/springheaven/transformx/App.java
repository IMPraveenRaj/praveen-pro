package com.springheaven.transformx;

import java.util.Objects;
import java.util.Optional;

/**
 * Hello world!
 */
public class App {

    User user;

    public User testObjects() {
        //user= new User();

        Optional<User> mayBeUser = Optional.of(user);
        if (mayBeUser.isPresent()) {
            mayBeUser.map(user -> {
                user.name = "praveenraj";
                return user;

            });
        } else if (mayBeUser.isEmpty()) {
            System.out.println("The user Object is non null :" + user);
            return null;
        }

        return mayBeUser.get();
    }
    public static void main(String[] args) {
        System.out.println("hello world");
        App app = new App();
        User user1 = app.testObjects();
        System.out.println(user1);

    }

}
