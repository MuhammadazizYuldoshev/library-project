package uz.pdp.libraryproject;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String homePage(){

        return "home-page";
    }

    @GetMapping("/login")
    public String login(){

        return "login.jsp";
    }

    @GetMapping("/user")
    public String userPage(){

        return "user-page";
    }


    @GetMapping("/admin")
    public String adminPage(){

        return "admin-page";
    }


}
