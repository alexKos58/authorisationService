package ru.kostyushin.authorizationservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kostyushin.authorizationservice.enums.Authorities;
import ru.kostyushin.authorizationservice.exception.InvalidCredentials;
import ru.kostyushin.authorizationservice.exception.UnauthorizedUser;
import ru.kostyushin.authorizationservice.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorizationService {
    private final UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
