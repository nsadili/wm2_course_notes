package az.edu.ada.wm2.CRUDapp.CRUD;

import az.edu.ada.wm2.CRUDapp.CRUD.model.Book;
import az.edu.ada.wm2.CRUDapp.CRUD.service.BookService;
import az.edu.ada.wm2.CRUDapp.CRUD.service.BookServiceImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}



}
