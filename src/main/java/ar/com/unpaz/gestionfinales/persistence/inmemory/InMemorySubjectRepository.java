package ar.com.unpaz.gestionfinales.persistence.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.persistence.SubjectRepository;
import ar.com.unpaz.gestionfinales.persistence.SubjectSpecification;

public class InMemorySubjectRepository implements SubjectRepository {

  private static int id = 0;

  private final Map<Integer, Subject> subjects;

  public InMemorySubjectRepository() {
    subjects = new HashMap<>();
  }

  @Override
  public void addSubject(Subject subject) {
    subjects.put(id++, subject);
  }

  @Override
  public void removeSubject(Subject subject) {
    subjects.remove(subject.getId());
  }

  @Override
  public void updateSubject(Subject subject) {
    subjects.put(subject.getId(), subject);
  }

  @Override
  public List<Subject> query(SubjectSpecification spec) {
    List<Subject> result = new ArrayList<>();
    for (Integer key : subjects.keySet()) {
      Subject subject = subjects.get(key);
      if (spec.specified(subject)) {
        result.add(subject);
      }
    }
    return result;
  }

  @Override
  public List<Subject> getAll() {
    List<Subject> result = new ArrayList<>();
    for (Integer key : subjects.keySet()) {
      Subject subject = subjects.get(key);
      String des = subject.getDescription();
      int year = subject.getYear();
      result.add(new Subject(key, des, year));
    }
    return result;
  }

  @Override
  public List<Subject> filterByYear(int year) {
    List<Subject> result = new ArrayList<>();
    for (Integer key : subjects.keySet()) {
      Subject subject = subjects.get(key);
      if (subject.getYear() == year) {
        String des = subject.getDescription();
        result.add(new Subject(key, des, year));
      }
    }
    return result;
  }

}
