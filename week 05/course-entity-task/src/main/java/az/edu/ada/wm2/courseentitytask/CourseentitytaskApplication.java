package az.edu.ada.wm2.courseentitytask;
import az.edu.ada.wm2.courseentitytask.model.Course;
import az.edu.ada.wm2.courseentitytask.service.CourseService;
import az.edu.ada.wm2.courseentitytask.service.CourseServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseentitytaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseentitytaskApplication.class, args);
	}

	private void init() {

		CourseService service = new CourseServiceImpl();

		System.out.println(service.list());

		Course c = new Course();
		c.setName("Rafael");
		c.setDepartmentname("site");
		c.setCredits("50");
		System.out.println(service.save(c));

		c = new Course();
		c.setName("Jale");
		c.setDepartmentname("sb");
		c.setCredits("70");
		System.out.println(service.save(c));

		System.out.println(service.list());
	}

}