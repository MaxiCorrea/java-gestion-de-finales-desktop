package ar.com.unpaz.gestionfinales.persistence;

import ar.com.unpaz.gestionfinales.domain.Subject;

public interface SubjectSpecification {

  boolean specified(Subject subject);

}
