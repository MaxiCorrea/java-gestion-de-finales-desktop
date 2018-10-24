package ar.com.unpaz.gestionfinales.presentation;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.finals.UpdateFinalDialog;

public class AppViewContext {

  public static AppView appView;

  public static View<Subject> subjectsView;
  public static Dialog<Subject> addSubjectDialog;
  public static Dialog<Subject> delSubjectDialog;
  public static Dialog<Subject> updSubjectDialog;
  public static ReportDialog<Subject> reportSubjectDialog;

  public static View<Student> studentsView;
  public static Dialog<Student> addStudentDialog;
  public static Dialog<Student> delStudentDialog;
  public static Dialog<Student> updStudentDialog;
  public static ReportDialog<Student> reportStudentDialog;

  public static View<Final> finalsView;
  public static Dialog<Final> addFinalDialog;
  public static SelectDialog<Subject> selectSubjectDialog;
  public static SelectDialog<Student> selectStudentDialog;
  public static UpdateFinalDialog updFinalDialog;
  public static Dialog<Final> delFinalDialog;
  public static ReportDialog<Final> reportFinalDialog;

  public static AboutDialog aboutDialog;

}
