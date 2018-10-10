package ar.com.unpaz.gestionfinales.persistence.inmemory;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.persistence.Specification;

public class ByYearSpecification implements Specification<Subject> {

  private final int year;

  public ByYearSpecification(int year) {
    this.year = year;
  }

  @Override
  public boolean specified(Subject entity) {
    return year == entity.getYear();
  }

}
