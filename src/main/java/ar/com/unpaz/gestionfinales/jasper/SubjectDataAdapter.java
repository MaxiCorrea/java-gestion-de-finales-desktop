package ar.com.unpaz.gestionfinales.jasper;

import static java.lang.String.valueOf;
import ar.com.unpaz.gestionfinales.domain.Subject;

public class SubjectDataAdapter {

  private Subject subject;

  public SubjectDataAdapter() {
    super();
  }
  
  public SubjectDataAdapter(Subject subject) {
    this.subject = subject;
  }

  public String getId() {
    return valueOf(subject.getId());
  }

  public String getDescription() {
    return subject.getDescription();
  }

  public String getYear() {
    return valueOf(subject.getYear().number);
  }

}
