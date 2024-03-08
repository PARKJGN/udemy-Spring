package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService{

    private static List<User> users = new ArrayList<>();

    private static int usercount = 0;

    static{
        users.add(new User(++usercount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usercount,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usercount,"Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(++usercount);
        users.add(user);
        return user;
    }
}
