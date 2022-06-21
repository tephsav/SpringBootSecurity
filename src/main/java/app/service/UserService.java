package app.service;

import app.model.User;

public interface UserService {

    Iterable<User> getAllUsers();

    User getUser(Long id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User findUserByName(String name);

    String getCurrentUsername();

}
