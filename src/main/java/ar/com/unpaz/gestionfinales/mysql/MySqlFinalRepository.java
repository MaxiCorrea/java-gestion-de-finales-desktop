package ar.com.unpaz.gestionfinales.mysql;

import static ar.com.unpaz.gestionfinales.domain.Qualification.of;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ar.com.unpaz.gestionfinales.database.FinalRepository;
import ar.com.unpaz.gestionfinales.database.Specification;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Qualification;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;

public class MySqlFinalRepository implements FinalRepository {

  @Override
  public void add(Final entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void remove(Final entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Final entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Final> getAll() {
    String query = "SELECT * FROM Final";
    Connection connection = MySqlConexion.getConexion();
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
    Connection connection = MySqlConexion.getConexion();
    String query = "SELECT * FROM Subject WHERE idSubject =?";
    try (PreparedStatement st = connection.prepareStatement(query)) {
      st.setInt(1, id);
      try(ResultSet resultSet = st.executeQuery()) {
        if(resultSet.next()) {
          return ResultSetToSubject.convert(resultSet);
        }
      }
    }catch(SQLException e) {
     e.printStackTrace(); 
    }
    return null;
  }
  
  private Student getStudent(int dni) {
    Connection connection = MySqlConexion.getConexion();
    String query = "SELECT * FROM Student WHERE dniStudent =?";
    try (PreparedStatement st = connection.prepareStatement(query)) {
      st.setInt(1, dni);
      try(ResultSet resultSet = st.executeQuery()) {
        if(resultSet.next()) {
          return ResultSetToStudent.convert(resultSet);
        }
      }
    }catch(SQLException e) {
     e.printStackTrace(); 
    }
    return null;
  }

  @Override
  public List<Final> query(Specification<Final> spec) {
    return null;
  }

}
