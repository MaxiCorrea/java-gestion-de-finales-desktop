package ar.com.unpaz.gestionfinales.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ar.com.unpaz.gestionfinales.database.Specification;
import ar.com.unpaz.gestionfinales.database.SubjectRepository;
import ar.com.unpaz.gestionfinales.domain.Subject;

public class MySqlSubjectRepository implements SubjectRepository {

  @Override
  public void add(Subject entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void remove(Subject entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Subject entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Subject> getAll() {
    String query = "SELECT * FROM Subject";
    Connection connection = MySqlConexion.getConexion();
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
