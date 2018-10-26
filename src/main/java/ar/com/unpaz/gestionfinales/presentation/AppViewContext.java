package ar.com.unpaz.gestionfinales.presentation;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;

public class AppViewContext {

  public static AppView appView;

  public static View<Subject> subjectsView;
  public static Dialog<Subject> addSubjectDialog;
  public static Dialog<Subject> delSubjectDialog;
  public static Dialog<Subject> updSubjectDialog;
  public static Report<Subject> reportSubjectDialog;

  public static View<Student> studentsView;
  public static Dialog<Student> addStudentDialog;
  public static Dialog<Student> delStudentDialog;
  public static Dialog<Student> updStudentDialog;
  public static Report<Student> reportStudentDialog;

  public static View<Final> finalsView;
  public static Dialog<Final> addFinalDialog;
  public static Select<Subject> addSelectSubjectDialog;
  public static Select<Student> addSelectStudentDialog;
  public static Select<Subject> updSelectSubjectDialog;
  public static Select<Student> updSelectStudentDialog;
  public static Dialog<Final> updFinalDialog;
  public static Dialog<Final> delFinalDialog;
  public static Report<Final> reportFinalDialog;

  public static About aboutDialog;

}
