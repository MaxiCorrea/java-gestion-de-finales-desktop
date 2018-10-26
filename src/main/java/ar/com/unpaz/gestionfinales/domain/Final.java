package ar.com.unpaz.gestionfinales.domain;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import java.time.LocalDate;

public class Final extends Entity<Final> {
  
  public static final Final EMPTY = new Final();
  
  private final Subject subject;
  private final Student student;
  private final LocalDate date;
  private final Qualification qualification;

  public Final() {
    this(0, Subject.EMPTY, Student.EMPTY, LocalDate.now(), Qualification.NONE);
  }

  public Final(int id, Subject subject, Student student, LocalDate date,
      Qualification qualification) {
    super(id);
    this.subject = requireNonNull(subject);
    this.student = requireNonNull(student);
    this.date = requireNonNull(date);
    this.qualification = requireNonNull(qualification);
  }

  public Subject getSubject() {
    return subject;
  }

  public Student getStudent() {
    return student;
  }

  public LocalDate getDate() {
    return date;
  }

  public Qualification getQualification() {
    return qualification;
  }

  public boolean hasThisSubject(Subject s) {
    return getSubject().equals(s);
  }
  
  public boolean hasThisStudent(Student s) {
    return getStudent().equals(s);
  }
  
  public boolean hasThisQualification(Qualification q) {
    return getQualification() == q;
  }
  
  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return "Final [subject=" + subject + ", student=" + student + ", date=" + date
        + ", qualification=" + qualification + "]";
  }

}
