package ar.com.unpaz.gestionfinales.domain;

public abstract class Entity<E> {

  private final int id;

  public Entity() {
    id = 0;
  }
  
  public Entity(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
  
}
