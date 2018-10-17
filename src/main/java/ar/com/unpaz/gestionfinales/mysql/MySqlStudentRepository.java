package ar.com.unpaz.gestionfinales.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ar.com.unpaz.gestionfinales.database.Specification;
import ar.com.unpaz.gestionfinales.database.StudentRepository;
import ar.com.unpaz.gestionfinales.domain.Student;

public class MySqlStudentRepository implements StudentRepository {

  @Override
  public void add(Student entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void remove(Student entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Student entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Student> getAll() {
    String query = "SELECT * FROM Student";
    Connection connection = MySqlConexion.getConexion();
    List<Student> students = new ArrayList<>();
    try (PreparedStatement st = connection.prepareStatement(query);
        ResultSet resultSet = st.executeQuery()) {
      while (resultSet.next()) {
        students.add(ResultSetToStudent.convert(resultSet));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return students;
  }

  @Override
  public List<Student> query(Specification<Student> spec) {
    // TODO Auto-generated method stub
    return null;
  }

}
