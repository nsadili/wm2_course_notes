package az.edu.ada.wm2.thymeleafdemo.controller;
import az.edu.ada.wm2.thymeleafdemo.model.Person;
import az.edu.ada.wm2.thymeleafdemo.service.PersonService;
/*import javax.naming.directory.AttributeInUseException;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

}

