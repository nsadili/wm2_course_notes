package az.edu.ada.wm2.testing.service;

import az.edu.ada.wm2.testing.entity.Student;
import az.edu.ada.wm2.testing.repo.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepository stdRepo;

    @InjectMocks
    StudentService stdService;

    @Test
    @DisplayName("Expect a list of 3 students when getStudents() is called")
    void getStudents() {
        Student std1 = new Student();
        Student std2 = new Student(1L, "Nuraddin", "Sadili", "nsadili");
        Student std3 = new Student(2L, "Ali", "Teymurov", "ateymurov");

        List<Student> students = new ArrayList<>();
        students.add(std1);
        students.add(std2);
        students.add(std3);

        //GIVEN
        given(stdRepo.findAll()).willReturn(students);

        //WHEN - OPERATION
        List<Student> allStudentsFromService = stdService.getStudents();

        //THEN - EXPECTED
        then(stdRepo).should().findAll();
        assertThat(allStudentsFromService).hasSize(3);
    }

    @Test
    @DisplayName("Expect a student when getStudent(id) is called")
    void getStudent() {
        Student std = new Student();
        //GIVEN
        given(stdRepo.findById(anyLong())).willReturn(Optional.of(std));

        //WHEN - OPERATION
        Student res = stdService.getStudent(anyLong());

        //THEN - EXPECTED
        then(stdRepo).should().findById(anyLong());
        assertThat(res).isNotNull();
    }

    @Test
    @DisplayName("Expect a student when save(std) is called")
    void save() {
        Student std = new Student();
        //GIVEN
        given(stdRepo.save(std)).willReturn(std);

        //WHEN - OPERATION
        Student res = stdService.save(std);

        //THEN - EXPECTED
        then(stdRepo).should().save(any(Student.class));
        assertThat(res).isNotNull();
    }
}