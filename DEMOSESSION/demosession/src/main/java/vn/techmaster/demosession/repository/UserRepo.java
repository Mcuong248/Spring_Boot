package vn.techmaster.demosession.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import vn.techmaster.demosession.model.State;
import vn.techmaster.demosession.model.User;

@Repository
public class UserRepo {
    private ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>(); 

    public User addUser(String fullName, String email, String hashed_pass) {
        return addUser(fullName, email, hashed_pass, State.PENDING);
    }

    public User addUser(String fullName, String email, String hashed_pass, State state) {
        String id = UUID.randomUUID().toString();
        User user = User.builder()
        .id(id)
        .fullname(fullName)
        .email(email)
        .hashed_password(hashed_pass)
        .state(state)
        .build();
        users.put(id, user);
        return user;
    }

        public boolean isEmailExist(String email) {
           return users.values().stream()
           .filter(user -> user.getEmail().equalsIgnoreCase(email)).count() > 0;
    }

    public Optional<User> findByEmail(String email) {
        return users.values().stream()
        .filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
    }
}
