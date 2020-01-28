package am.basic.web.repository;

import am.basic.web.model.User;
import am.basic.web.util.Datasource;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepositoryImplJdbc implements UserRepository {


    public void begin(){
    System.out.println("initialize UserRepositoryImplJdbc");


}
    @Override
    public User getByName(String username) throws SQLException {
        Connection con = Datasource.getConnection();
        PreparedStatement stat = con.prepareStatement("select * from user where username = ?");
        stat.setString(1, username);
        ResultSet rst = stat.executeQuery();
        User user = null;
        if (rst.next()) {
            user = new User();

            user.setId(rst.getLong("id"));
            user.setName(rst.getString("name"));
            user.setSurname(rst.getString("surname"));
            user.setUsername(rst.getString("username"));
            user.setPassword(rst.getString("password"));
            user.setAge(rst.getInt("age"));
            user.setCode(rst.getInt("code"));
        }

        return user;
    }

    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    public void addUser(User user) throws SQLException {
        Connection con = Datasource.getConnection();
        PreparedStatement stat = con.prepareStatement("insert into user(id, name, surname, username, password, age, code) values (?,?,?,?,?,?,?)");

        stat.setLong(1, user.getId());
        stat.setString(2, user.getName());
        stat.setString(3, user.getSurname());
        stat.setString(4, user.getUsername());
        stat.setString(5, user.getPassword());
        stat.setInt(6, user.getAge());
        stat.setInt(7, user.getCode());


        stat.execute();
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
