package ar.com.unpaz.gestionfinales.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.com.unpaz.gestionfinales.database.SubjectRepository;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.domain.Year;

public class InMemorySubjectRepository extends AbstractInMemoryRepository<Subject>
    implements SubjectRepository {

  private static int id = 0;
  private int numberOfInteractions;

  private final Map<Integer, Subject> subjects;

  public InMemorySubjectRepository() {
    numberOfInteractions = 0;
    subjects = new HashMap<>();
  }

  @Override
  public void add(Subject subject) {
    numberOfInteractions++;
    subjects.put(id++, subject);
  }

  @Override
  public void remove(Subject subject) {
    numberOfInteractions++;
    subjects.remove(subject.getId());
  }

  @Override
  public void update(Subject subject) {
    numberOfInteractions++;
    subjects.put(subject.getId(), subject);
  }

  @Override
  public List<Subject> getAll() {
    numberOfInteractions++;
    List<Subject> result = new ArrayList<>();
    for (Integer key : subjects.keySet()) {
      Subject subject = subjects.get(key);
      String des = subject.getDescription();
      Year year = subject.getYear();
      result.add(new Subject(key, des, year));
    }
    return result;
  }

  public boolean noInteractions() {
    return getNumberOfInteractions() == 0;
  }

  public int getNumberOfInteractions() {
    return numberOfInteractions;
  }

}
