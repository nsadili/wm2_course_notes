package az.edu.az.wm2.mongo_db_demo.controller;

import az.edu.az.wm2.mongo_db_demo.dto.UserData;
import az.edu.az.wm2.mongo_db_demo.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/external")
public class ExternalController {

    @Autowired
    private ExternalService externalService;

    @GetMapping("/users/")
    public List<UserData> getAllUserData() {
        return externalService.getAllUserDateFromApi();
    }

    @GetMapping("/users/{id}")
    public UserData getUserData(@PathVariable Long id) {
        return externalService.getUserById(id);
    }
}
