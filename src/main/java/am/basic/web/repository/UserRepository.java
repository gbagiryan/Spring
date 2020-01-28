package am.basic.web.repository;

import am.basic.web.model.User;

import java.sql.SQLException;

public interface UserRepository {
    User getByName(String username) throws SQLException;

    public User getById(long id);

    void addUser(User user) throws SQLException;

    public void updateUser(User user);

    public void deleteUser(User user);
}
