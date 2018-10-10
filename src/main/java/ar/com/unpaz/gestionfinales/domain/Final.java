package ar.com.unpaz.gestionfinales.domain;

import java.time.LocalDate;

public class Final extends Entity {

  private final Subject subject;
  private final Student student;
  private final LocalDate date;
  private final Note note;

  public Final(int id, Subject subject, Student student, LocalDate date, Note note) {
    super(id);
    this.subject = subject;
    this.student = student;
    this.date = date;
    this.note = note;
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

  public Note getNote() {
    return note;
  }

}
