package ar.com.unpaz.gestionfinales.application;

import ar.com.unpaz.gestionfinales.presentation.AppView;
import ar.com.unpaz.gestionfinales.presentation.finals.AddFinalDialog;
import ar.com.unpaz.gestionfinales.presentation.finals.DeleteFinalDialog;
import ar.com.unpaz.gestionfinales.presentation.finals.FinalsView;
import ar.com.unpaz.gestionfinales.presentation.finals.UpdateFinalDialog;
import ar.com.unpaz.gestionfinales.presentation.students.AddStudentDialog;
import ar.com.unpaz.gestionfinales.presentation.students.DeleteStudentDialog;
import ar.com.unpaz.gestionfinales.presentation.students.SelectStudentDialog;
import ar.com.unpaz.gestionfinales.presentation.students.StudentsView;
import ar.com.unpaz.gestionfinales.presentation.students.UpdateStudentDialog;
import ar.com.unpaz.gestionfinales.presentation.subjects.AddSubjectDialog;
import ar.com.unpaz.gestionfinales.presentation.subjects.DeleteSubjectDialog;
import ar.com.unpaz.gestionfinales.presentation.subjects.SelectSubjectDialog;
import ar.com.unpaz.gestionfinales.presentation.subjects.SubjectsView;
import ar.com.unpaz.gestionfinales.presentation.subjects.UpdateSubjectDialog;

public class AppViewContext {

  public static AppView appView;
  
  public static SubjectsView subjectsView;
  public static AddSubjectDialog addSubjectDialog;
  public static DeleteSubjectDialog delSubjectDialog;
  public static UpdateSubjectDialog updSubjectDialog;
  
  public static StudentsView studentsView;
  public static AddStudentDialog addStudentDialog;
  public static UpdateStudentDialog updStudentDialog;
  public static DeleteStudentDialog delStudentDialog;
  
  public static FinalsView finalsView;
  public static AddFinalDialog addFinalDialog;
  public static SelectSubjectDialog selectSubjectDialog;
  public static SelectStudentDialog selectStudentDialog;
  public static UpdateFinalDialog updFinalDialog;
  public static DeleteFinalDialog delFinalDialog;
 
}
