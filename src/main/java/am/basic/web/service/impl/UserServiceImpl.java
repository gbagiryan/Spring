package am.basic.web.service.impl;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepositoryImplHibernate;

    public void begin(){
        System.out.println("initialize");
    }


    @Override
    public User getByUser(String username) {

        try {
            return userRepositoryImplHibernate.getByName(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
