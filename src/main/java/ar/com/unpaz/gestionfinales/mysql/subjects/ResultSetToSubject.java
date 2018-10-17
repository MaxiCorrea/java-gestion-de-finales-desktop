package ar.com.unpaz.gestionfinales.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.domain.Year;

public class ResultSetToSubject {

  public static Subject convert(ResultSet resultSet) throws SQLException {
    return new Subject(resultSet.getInt("idSubject"), resultSet.getString("description"),
        Year.of(resultSet.getInt("year")));
  }

}
