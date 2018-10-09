package ar.com.unpaz.gestionfinales.persistence;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;

public interface SubjectRepository {

  void addSubject(Subject subject);

  void removeSubject(Subject subject);

  void updateSubject(Subject subject);

  List<Subject> getAll();

  List<Subject> filterByYear(int year);

  List<Subject> query(SubjectSpecification spec);

}
