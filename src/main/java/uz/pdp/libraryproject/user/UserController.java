package uz.pdp.libraryproject.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserDao userDao;


    //admin uchun
    @GetMapping
    public String showUsers(Model model){
        List<User> allLUsers = userDao.getAllLUsers();
        model.addAttribute("userList",allLUsers);
        return "view-user-form";
    }

    //user uchun
    @GetMapping("/view-user")
    public String viewUsers(Model model){
        List<User> allLUsers = userDao.getAllLUsers();
        model.addAttribute("userList",allLUsers);
        return "view-userr-form";
    }

    @GetMapping("/add-user-form")
    public String addUserForm(){
        return "add-user-form";
    }

    @PostMapping("/add-user")
    public String saveUser(User user){
        userDao.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model){
        User user = userDao.getUser(id);
        model.addAttribute("user",user);
        return "update-user-form";
    }

    @PostMapping("/update-user")
    public String updateUser(User user){
        userDao.updateuser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        userDao.delete(id);
        return "redirect:/users";
    }

}
