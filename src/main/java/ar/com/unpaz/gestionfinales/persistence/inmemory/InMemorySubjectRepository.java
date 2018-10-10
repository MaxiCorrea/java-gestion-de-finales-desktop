package ar.com.unpaz.gestionfinales.persistence.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.persistence.SubjectRepository;

public class InMemorySubjectRepository extends AbstractInMemoryRepository<Subject>
    implements SubjectRepository {

  private static int id = 0;

  private final Map<Integer, Subject> subjects;

  public InMemorySubjectRepository() {
    subjects = new HashMap<>();
  }

  @Override
  public void add(Subject subject) {
    subjects.put(id++, subject);
  }

  @Override
  public void remove(Subject subject) {
    subjects.remove(subject.getId());
  }

  @Override
  public void update(Subject subject) {
    subjects.put(subject.getId(), subject);
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

}
