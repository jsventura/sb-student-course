package pe.isil.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.isil.model.Student;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop",
})
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void whenSaved_thenFindById(){
        Student supplierSaved = studentRepository.save(
                new Student("DNI001", null));

        assertThat(studentRepository.findById("DNI001")).isNotNull();
    }

}
