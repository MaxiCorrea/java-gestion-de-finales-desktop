package ar.com.unpaz.gestionfinales.persistence.inmemory;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.domain.Year;
import ar.com.unpaz.gestionfinales.persistence.Specification;

public class ByYearSpecification implements Specification<Subject> {

  private final Year year;

  public ByYearSpecification(int year) {
    this.year = Year.of(year);
  }

  @Override
  public boolean specified(Subject entity) {
    return year == entity.getYear();
  }

}
