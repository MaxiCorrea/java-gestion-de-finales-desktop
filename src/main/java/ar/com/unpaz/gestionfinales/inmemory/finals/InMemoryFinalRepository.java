package ar.com.unpaz.gestionfinales.inmemory.finals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.com.unpaz.gestionfinales.database.FinalRepository;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.inmemory.AbstractInMemoryRepository;

public class InMemoryFinalRepository extends AbstractInMemoryRepository<Final>
    implements FinalRepository {

  private static int ids;
  private Map<Integer, Final> finals;

  public InMemoryFinalRepository() {
    finals = new HashMap<>();
  }

  @Override
  public void add(Final entity) {
    finals.put(ids++, entity);
  }

  @Override
  public void remove(Final entity) {
    finals.remove(entity.getId());
  }

  @Override
  public void update(Final entity) {
    finals.put(entity.getId(), entity);
  }

  @Override
  public List<Final> getAll() {
    List<Final> result = new ArrayList<>();
    for (Integer key : finals.keySet()) {
      Final f = finals.get(key);
      result.add(new Final(key, f.getSubject(), 
          f.getStudent(), f.getDate(), f.getNote()));
    }
    return result;
  }

}
