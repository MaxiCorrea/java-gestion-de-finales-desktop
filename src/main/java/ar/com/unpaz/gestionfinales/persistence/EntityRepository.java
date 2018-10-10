package ar.com.unpaz.gestionfinales.persistence;

import java.util.List;

public interface EntityRepository <Entity> {
  
  void add(Entity entity);

  void remove(Entity entity);

  void update(Entity entity);

  List<Entity> getAll();

  List<Entity> query(Specification<Entity> spec);

}
