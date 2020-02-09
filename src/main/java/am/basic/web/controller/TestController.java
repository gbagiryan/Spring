package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class TestController {


    @Autowired
    private UserRepository userRepository;


    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String test() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpSession session) throws SQLException {
        User user = userRepository.getByName(username);
        if (user==null){
            return new ModelAndView("index", "wrongLogin", "username doesn't exist");
        }
        if (user!=null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return new ModelAndView("profile");
        }

        return new ModelAndView("index", "wrongLogin", "wrong password");
    }


}
