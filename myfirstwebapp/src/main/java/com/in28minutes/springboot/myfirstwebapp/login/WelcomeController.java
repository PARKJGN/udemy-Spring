package com.in28minutes.springboot.myfirstwebapp.login;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class WelcomeController {

  /*  private Logger logger = LoggerFactory.getLogger(getClass());*/

    //Model
    /*@RequestMapping("login")
    public void login(@RequestParam(value = "name") String name, ModelMap model){
        model.put("name",name);
        logger.debug("Request param is {}",name);
        logger.info("info level");
        logger.warn("warn level");
        System.out.println(name);

    }*/
    /*private final loginAuthenticationService authenticationService;

    public LoginController(loginAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(HttpSession session){
        session.setAttribute("name",getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    /*@RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, Model model, HttpSession session){

        if(!authenticationService.authenticate(name, password)) {
            model.addAttribute("error","Invalid Credentials! Please try again");
            return "login";
        }
        model.addAttribute("name",name);
        session.setAttribute("name", name);

        //Authentication
        //name - in28minutes
        //password - dummy

        return "welcome";
    }*/
}
