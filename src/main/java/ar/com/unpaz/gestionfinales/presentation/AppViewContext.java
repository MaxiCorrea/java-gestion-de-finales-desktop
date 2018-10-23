package ar.com.unpaz.gestionfinales.presentation;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.finals.AddFinalDialog;
import ar.com.unpaz.gestionfinales.presentation.finals.DeleteFinalDialog;
import ar.com.unpaz.gestionfinales.presentation.finals.FinalsView;
import ar.com.unpaz.gestionfinales.presentation.finals.UpdateFinalDialog;
import ar.com.unpaz.gestionfinales.presentation.students.SelectStudentDialog;
import ar.com.unpaz.gestionfinales.presentation.subjects.SelectSubjectDialog;

public class AppViewContext {

  public static AppView appView;

  public static View<Subject> subjectsView;
  public static AddDialog<Subject> addSubjectDialog;
  public static DeleteDialog<Subject> delSubjectDialog;
  public static UpdateDialog<Subject> updSubjectDialog;
  public static ReportDialog reportSubjectDialog;

  public static View<Student> studentsView;
  public static AddDialog<Student> addStudentDialog;
  public static DeleteDialog<Student> delStudentDialog;
  public static UpdateDialog<Student> updStudentDialog;
  public static ReportDialog reportStudentDialog;

  public static FinalsView finalsView;
  public static AddFinalDialog addFinalDialog;
  public static SelectSubjectDialog selectSubjectDialog;
  public static SelectStudentDialog selectStudentDialog;
  public static UpdateFinalDialog updFinalDialog;
  public static DeleteFinalDialog delFinalDialog;
  public static ReportDialog reportFinalDialog;

  public static AboutDialog aboutDialog;
  
}
