package ar.com.unpaz.gestionfinales.persistence;

public interface Specification<T> {

  boolean specified(T entity);

}
