package ar.com.unpaz.gestionfinales.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.com.unpaz.gestionfinales.domain.Student;

public class InMemoryStudentRepository extends AbstractInMemoryRepository<Student> {

  private Map<String, Student> students;
  private int numberOfInteractions;

  public InMemoryStudentRepository() {
    students = new HashMap<>();
    numberOfInteractions = 0;
  }

  @Override
  public void add(Student entity) {
    numberOfInteractions++;
    students.put(entity.getDni(), entity);
  }

  @Override
  public void remove(Student entity) {
    numberOfInteractions++;
    students.remove(entity.getDni());
  }

  @Override
  public void update(Student entity) {
    numberOfInteractions++;
    students.put(entity.getDni(), entity);
  }

  @Override
  public List<Student> getAll() {
    numberOfInteractions++;
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

  public boolean noInteractions() {
    return numberOfInteractions == 0;
  }

}
