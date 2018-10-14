package ar.com.unpaz.gestionfinales.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.com.unpaz.gestionfinales.database.StudentRepository;
import ar.com.unpaz.gestionfinales.domain.Student;

public class InMemoryStudentRepository extends AbstractInMemoryRepository<Student>
    implements StudentRepository {

  private Map<Integer, Student> students;

  public InMemoryStudentRepository() {
    students = new HashMap<>();
  }

  @Override
  public void add(Student entity) {
    students.put(entity.getId(), entity);
  }

  @Override
  public void remove(Student entity) {
    students.remove(entity.getId());
  }

  @Override
  public void update(Student entity) {
    students.put(entity.getId(), entity);
  }

  @Override
  public List<Student> getAll() {
    List<Student> result = new ArrayList<>();
    for (Integer key : students.keySet()) {
      Student student = students.get(key);
      int dni = student.getId();
      String name = student.getName();
      String surname = student.getSurname();
      String email = student.getEmail();
      result.add(new Student(dni, name, surname, email));
    }
    return result;
  }

}
