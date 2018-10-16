package ar.com.unpaz.gestionfinales.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.com.unpaz.gestionfinales.database.StudentRepository;
import ar.com.unpaz.gestionfinales.domain.Student;

public class InMemoryStudentRepository extends AbstractInMemoryRepository<Student>
    implements StudentRepository {

  private Map<String, Student> students;

  public InMemoryStudentRepository() {
    students = new HashMap<>();
  }

  @Override
  public void add(Student entity) {
    students.put(entity.getDni(), entity);
  }

  @Override
  public void remove(Student entity) {
    students.remove(entity.getDni());
  }

  @Override
  public void update(Student entity) {
    students.put(entity.getDni(), entity);
  }

  @Override
  public List<Student> getAll() {
    List<Student> result = new ArrayList<>();
    for (String key : students.keySet()) {
      Student student = students.get(key);
      String dni = student.getDni();
      String name = student.getName();
      String surname = student.getSurname();
      String email = student.getEmail();
      result.add(new Student(dni, name, surname, email));
    }
    return result;
  }

}
