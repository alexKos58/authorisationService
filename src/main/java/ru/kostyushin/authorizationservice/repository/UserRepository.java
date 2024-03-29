package ru.kostyushin.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.kostyushin.authorizationservice.enums.Authorities;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("admin") && password.equals("12345")){
            authorities.add(Authorities.READ);
            authorities.add(Authorities.WRITE);
            authorities.add(Authorities.DELETE);
        } else if (user.equals("user") && password.equals("00000")){
            authorities.add(Authorities.READ);
        }
        return authorities;
    }
}