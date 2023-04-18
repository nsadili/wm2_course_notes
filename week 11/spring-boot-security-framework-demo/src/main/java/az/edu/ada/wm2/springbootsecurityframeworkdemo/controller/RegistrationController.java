package az.edu.ada.wm2.springbootsecurityframeworkdemo.controller;

import az.edu.ada.wm2.springbootsecurityframeworkdemo.model.dto.SignupDto;
import az.edu.ada.wm2.springbootsecurityframeworkdemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("signup")
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public String showSignup(Model model){
        model.addAttribute("signupDto", new SignupDto());
        return "registration";
    }

    @PostMapping
    public String signUp(@ModelAttribute SignupDto signupDto,
                         PasswordEncoder passwordEncoder){
        userRepository.save(signupDto.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
