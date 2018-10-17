package ar.com.unpaz.gestionfinales.mysql.students;

import java.sql.ResultSet;
import java.sql.SQLException;
import ar.com.unpaz.gestionfinales.domain.Student;

public class ResultSetToStudent {

  public static Student convert(ResultSet resultSet) throws SQLException {
    return new Student(resultSet.getInt("dniStudent"), resultSet.getString("name"),
        resultSet.getString("surname"), resultSet.getString("email"));
  }

}
