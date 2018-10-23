package ar.com.unpaz.gestionfinales.mysql.finals;

import static ar.com.unpaz.gestionfinales.domain.Qualification.of;
import static java.lang.Integer.valueOf;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ar.com.unpaz.gestionfinales.database.EntityRepository;
import ar.com.unpaz.gestionfinales.database.Specification;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Qualification;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.mysql.MySqlConnection;
import ar.com.unpaz.gestionfinales.mysql.students.ResultSetToStudent;
import ar.com.unpaz.gestionfinales.mysql.subjects.ResultSetToSubject;

public class MySqlFinalRepository implements EntityRepository<Final> {

  @Override
  public void add(Final entity) {
    String sql = "INSERT INTO Final(subjectIdSubject,studentDniStudent,"
        + "dateFinal,qualification) VALUES(?,?,?,?)";
    Connection connection = MySqlConnection.getConexion();
    try (PreparedStatement st = connection.prepareStatement(sql)) {
      st.setInt(1, entity.getSubject().getId());
      st.setInt(2, valueOf(entity.getStudent().getDni()));
      st.setDate(3, Date.valueOf(entity.getDate()));
      st.setInt(4, entity.getQualification().number);
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remove(Final entity) {
    String sql = "DELETE FROM Final WHERE idFinal=?";
    Connection connection = MySqlConnection.getConexion();
    try (PreparedStatement st = connection.prepareStatement(sql)) {
      st.setInt(1, entity.getId());
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Final entity) {
    String sql = "UPDATE Final SET subjectIdSubject=?,studentDniStudent=?,"
        + "dateFinal=?,qualification=? WHERE idFinal=?";
    Connection connection = MySqlConnection.getConexion();
    try (PreparedStatement st = connection.prepareStatement(sql)) {
      st.setInt(1, entity.getSubject().getId());
      st.setInt(2, valueOf(entity.getStudent().getDni()));
      st.setDate(3, Date.valueOf(entity.getDate()));
      st.setInt(4, entity.getQualification().number);
      st.setInt(5, entity.getId());
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Final> getAll() {
    String query = "SELECT * FROM Final";
    Connection connection = MySqlConnection.getConexion();
    List<Final> finals = new ArrayList<>();
    try (PreparedStatement st = connection.prepareStatement(query);
        ResultSet resultSet = st.executeQuery()) {
      while (resultSet.next()) {
        int id = resultSet.getInt("idFinal");
        Subject subject = getSubject(resultSet.getInt("subjectIdSubject"));
        Student student = getStudent(resultSet.getInt("studentDniStudent"));
        LocalDate date = resultSet.getDate("dateFinal").toLocalDate();
        Qualification qualification = of(resultSet.getInt("qualification"));
        finals.add(new Final(id, subject, student, date, qualification));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return finals;
  }

  private Subject getSubject(int id) {
    Connection connection = MySqlConnection.getConexion();
    String query = "SELECT * FROM Subject WHERE idSubject =?";
    try (PreparedStatement st = connection.prepareStatement(query)) {
      st.setInt(1, id);
      try (ResultSet resultSet = st.executeQuery()) {
        if (resultSet.next()) {
          return ResultSetToSubject.convert(resultSet);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  private Student getStudent(int dni) {
    Connection connection = MySqlConnection.getConexion();
    String query = "SELECT * FROM Student WHERE dniStudent =?";
    try (PreparedStatement st = connection.prepareStatement(query)) {
      st.setInt(1, dni);
      try (ResultSet resultSet = st.executeQuery()) {
        if (resultSet.next()) {
          return ResultSetToStudent.convert(resultSet);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<Final> query(Specification<Final> spec) {
    return null;
  }

}
