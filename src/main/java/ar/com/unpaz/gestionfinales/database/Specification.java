package ar.com.unpaz.gestionfinales.database;

public interface Specification<T> {

  boolean specified(T entity);

}
