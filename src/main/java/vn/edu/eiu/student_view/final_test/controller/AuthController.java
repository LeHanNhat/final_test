package vn.edu.eiu.student_view.final_test.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.student_view.final_test.model.User;
import vn.edu.eiu.student_view.final_test.service.UserService;

@Controller
public class AuthController {
    @Autowired
    private UserService userSer;

    @PostMapping("/auth")
    public String login(@ModelAttribute User user, HttpSession ses,  RedirectAttributes redAttributes){
        User loginUser = userSer.findByUsername(user.getUsername());
        if (loginUser == null ) {
            redAttributes.addFlashAttribute("error","Invalid username or password");
            redAttributes.addFlashAttribute("username",user.getUsername());
            return "redirect:/login";
        }
        if (!loginUser.getPassword().equals(user.getPassword())){
            redAttributes.addFlashAttribute("error","Invalid username or password");
            redAttributes.addFlashAttribute("username",user.getUsername());
            return "redirect:/login";
        }
        ses.setAttribute("user",loginUser);

        return "redirect:/equipments";
    }
    @GetMapping("/logout")
    public String doLogout(HttpSession ses) {
        ses.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }
}
