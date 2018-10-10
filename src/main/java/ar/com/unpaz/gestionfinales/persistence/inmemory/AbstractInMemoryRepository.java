package ar.com.unpaz.gestionfinales.persistence.inmemory;

import java.util.ArrayList;
import java.util.List;
import ar.com.unpaz.gestionfinales.persistence.EntityRepository;
import ar.com.unpaz.gestionfinales.persistence.Specification;

public abstract class AbstractInMemoryRepository<E> implements EntityRepository<E> {

  @Override
  public List<E> query(Specification<E> spec) {
    List<E> result = new ArrayList<>();
    for (E e : getAll()) {
      if (spec.specified(e)) {
        result.add(e);
      }
    }
    return result;
  }
}
