package ar.com.unpaz.gestionfinales.database;

import java.util.List;

public interface EntityRepository <E> {
  
  void add(E entity);

  void remove(E entity);

  void update(E entity);

  List<E> getAll();

  List<E> query(Specification<E> spec);

}
