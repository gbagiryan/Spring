package am.basic.web.util;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepositoryImplHibernate;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryImplJdbc;
import am.basic.web.service.UserService;
import am.basic.web.service.impl.UserServiceImpl;
import com.mysql.cj.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        //THIS IS DEV BRANCH


//        UserRepositoryImplHibernate uri = new UserRepositoryImplHibernate();
//
//        Card card = new Card();
//        card.setName("Bank");
//        card.setNumber("654456");
//
//        User user = new User();
//        user.setName("Testing");
//        user.setUsername("test");
//        user.setPassword("12345");
//        user.setCard(card);
//
//        Action action = new Action();
//        Action action2 = new Action();
//        action.setName("someAction");
//        action2.setName("2someAction2");
//
//        List <Action> actions = new ArrayList<>();
//        actions.add(action);
//        actions.add(action2);
//        user.setAction(actions);
//
//        uri.addUser(user);
//        User userDB = uri.getById(9);
//        System.out.println(userDB);

        System.out.println(0);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        System.out.println(1);

        UserService userService = applicationContext.getBean(UserService.class);
        System.out.println(2);

        UserService userService2 = applicationContext.getBean(UserService.class);


//        User user = userService.getByUser("snow");
//        System.out.println(userService);
//        System.out.println(userService.getUserRepository());
//
//
//        System.out.println(userService2);
//        System.out.println(userService2.getUserRepository());

    }
}
