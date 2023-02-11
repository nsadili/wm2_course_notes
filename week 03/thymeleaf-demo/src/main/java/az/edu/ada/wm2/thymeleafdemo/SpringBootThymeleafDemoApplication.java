package az.edu.ada.wm2.thymeleafdemo;

import az.edu.ada.wm2.thymeleafdemo.model.Person;
import az.edu.ada.wm2.thymeleafdemo.service.PersonService;
import az.edu.ada.wm2.thymeleafdemo.service.PersonServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootThymeleafDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThymeleafDemoApplication.class, args);
    }

    private void init() {

        PersonService service = new PersonServiceImpl();

        System.out.println(service.list());

        Person p = new Person();
        p.setFirstName("Nuraddin");
        p.setLastName("Sadili");
        System.out.println(service.save(p));

        p = new Person();
        p.setFirstName("Jamal");
        p.setLastName("Ismayilzada");
        System.out.println(service.save(p));

        System.out.println(service.list());
    }

}
