package ar.com.unpaz.gestionfinales.mysql;

import static java.lang.Integer.valueOf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ar.com.unpaz.gestionfinales.database.Specification;
import ar.com.unpaz.gestionfinales.database.StudentRepository;
import ar.com.unpaz.gestionfinales.domain.Student;

public class MySqlStudentRepository implements StudentRepository {

  @Override
  public void add(Student entity) {
    String sql = "INSERT INTO Student(dniStudent,name,surname,email) VALUES(?,?,?,?)";
    Connection connection = MySqlConexion.getConexion();
    try (PreparedStatement st = connection.prepareStatement(sql)) {
      st.setInt(1, valueOf(entity.getDni()));
      st.setString(2, entity.getName());
      st.setString(3, entity.getSurname());
      st.setString(4, entity.getEmail());
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remove(Student entity) {
    String sql = "DELETE FROM Student WHERE dniStudent=?";
    Connection connection = MySqlConexion.getConexion();
    try (PreparedStatement st = connection.prepareStatement(sql)) {
      st.setInt(1, valueOf(entity.getDni()));
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Student entity) {
    String sql = "UPDATE Student SET name=?,surname=?,email=? WHERE dniStudent=?";
    Connection connection = MySqlConexion.getConexion();
    try (PreparedStatement st = connection.prepareStatement(sql)) {
      st.setString(1, entity.getName());
      st.setString(2, entity.getSurname());
      st.setString(3, entity.getEmail());
      st.setInt(4, valueOf(entity.getDni()));
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
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
