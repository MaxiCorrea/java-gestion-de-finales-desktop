package ar.com.unpaz.gestionfinales.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.com.unpaz.gestionfinales.domain.Final;

public class InMemoryFinalRepository extends AbstractInMemoryRepository<Final> {

  private int ids;
  private int numberOfInterations;
  private Map<Integer, Final> finals;

  public InMemoryFinalRepository() {
    finals = new HashMap<>();
    numberOfInterations = 0;
  }

  @Override
  public void add(Final entity) {
    numberOfInterations++;
    finals.put(ids++, entity);
  }

  @Override
  public void remove(Final entity) {
    numberOfInterations++;
    finals.remove(entity.getId());
  }

  @Override
  public void update(Final entity) {
    numberOfInterations++;
    finals.put(entity.getId(), entity);
  }

  @Override
  public List<Final> getAll() {
    numberOfInterations++;
    List<Final> result = new ArrayList<>();
    for (Integer key : finals.keySet()) {
      Final f = finals.get(key);
      result.add(new Final(key, f.getSubject(), 
          f.getStudent(), f.getDate(), f.getQualification()));
    }
    return result;
  }

  public boolean noInteractions() {
    return numberOfInterations == 0;
  }

}
