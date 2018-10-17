package ar.com.unpaz.gestionfinales.mysql.subjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ar.com.unpaz.gestionfinales.database.Specification;
import ar.com.unpaz.gestionfinales.database.SubjectRepository;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.mysql.MySqlConnection;

public class MySqlSubjectRepository implements SubjectRepository {

  @Override
  public void add(Subject entity) {
    String sql = "INSERT INTO Subject(description,year) values(?,?)";
    Connection connection = MySqlConnection.getConexion();
    try (PreparedStatement st = connection.prepareStatement(sql)) {
      st.setString(1, entity.getDescription());
      st.setInt(2, entity.getYear().number);
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remove(Subject entity) {
    String sql = "DELETE FROM Subject WHERE idSubject=?";
    Connection connection = MySqlConnection.getConexion();
    try (PreparedStatement st = connection.prepareStatement(sql)) {
      st.setInt(1, entity.getId());
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Subject entity) {
    String sql = "UPDATE Subject SET description=? , year=? WHERE idSubject=?";
    Connection connection = MySqlConnection.getConexion();
    try (PreparedStatement st = connection.prepareStatement(sql)) {
      st.setString(1, entity.getDescription());
      st.setInt(2, entity.getYear().number);
      st.setInt(3, entity.getId());
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Subject> getAll() {
    String query = "SELECT * FROM Subject";
    Connection connection = MySqlConnection.getConexion();
    List<Subject> subjects = new ArrayList<>();
    try (PreparedStatement st = connection.prepareStatement(query);
        ResultSet resultSet = st.executeQuery()) {
      while (resultSet.next()) {
        subjects.add(ResultSetToSubject.convert(resultSet));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return subjects;
  }

  @Override
  public List<Subject> query(Specification<Subject> spec) {
    // TODO Auto-generated method stub
    return null;
  }

}
