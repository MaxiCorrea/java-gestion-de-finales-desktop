package ar.com.unpaz.gestionfinales.persistence.inmemory;

import java.util.ArrayList;
import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.persistence.SubjectRepository;
import ar.com.unpaz.gestionfinales.persistence.SubjectSpecification;

public class InMemorySubjectRepository implements SubjectRepository {

  private static int id = 0;

  private final List<Subject> subjects;

  public InMemorySubjectRepository() {
    subjects = new ArrayList<>();
  }

  @Override
  public void addSubject(Subject subject) {
    subjects.add(new Subject(id++, subject.getDescription(), subject.getYear()));
  }

  @Override
  public void removeSubject(Subject subject) {
    subjects.remove(subject);
  }

  @Override
  public void updateSubject(Subject subject) {
    for (Subject each : subjects) {
      if (each.getId() == subject.getId()) {
        subjects.remove(each);
        subjects.add(subject);
        break;
      }
    }
  }

  @Override
  public List<Subject> query(SubjectSpecification spec) {
    List<Subject> result = new ArrayList<>();
    for (Subject each : subjects) {
      if (spec.specified(each)) {
        result.add(each);
      }
    }
    return result;
  }

  @Override
  public List<Subject> getAll() {
    return subjects;
  }

}
