package ar.com.unpaz.gestionfinales.domain;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import java.time.LocalDate;

public class Final extends Entity {

  public static String NOTE_ERROR = "Seleccione Nota";
  public static String STUDENT_ERROR = "Seleccione Alumno";
  public static String SUBJECT_ERROR = "Seleccione Materia";
  public static String NO_ERROR = "";

  public static final Final EMPTY = new Final();

  public static String validateFieldsOf(Final finalObj) {
    if(Note.NONE == finalObj.getNote()) {
      return NOTE_ERROR;
    }
    if(Student.EMPTY.equals(finalObj.getStudent())) {
      return STUDENT_ERROR;
    }
    if(Subject.EMPTY.equals(finalObj.getSubject())) {
      return SUBJECT_ERROR;
    }
    return NO_ERROR;
  }
  
  private final Subject subject;
  private final Student student;
  private final LocalDate date;
  private final Note note;

  public Final() {
    this(0, Subject.EMPTY, Student.EMPTY, LocalDate.now(), Note.NONE);
  }

  public Final(int id, Subject subject, Student student, LocalDate date, Note note) {
    super(id);
    this.subject = subject;
    this.student = student;
    this.date = requireNonNull(date);
    this.note = requireNonNull(note);
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

  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }
  
  @Override
  public boolean equals(Object obj) {
    return reflectionEquals(this, obj);
  }
  
}
