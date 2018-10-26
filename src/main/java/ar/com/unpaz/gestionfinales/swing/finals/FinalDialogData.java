package ar.com.unpaz.gestionfinales.swing.finals;

public enum FinalDialogData {

  ADD {

    @Override
    String title() {
      return "Nuevo Final";
    }

    @Override
    boolean buttonSubjectStatus() {
      return true;
    }

    @Override
    boolean buttonStudentStatus() {
      return true;
    }

    @Override
    boolean comboQualificationStatus() {
      return true;
    }
    
  } ,
  
  DELETE {

    @Override
    String title() {
      return "Borrar Final";
    }

    @Override
    boolean buttonSubjectStatus() {
      return false;
    }

    @Override
    boolean buttonStudentStatus() {
      return false;
    }

    @Override
    boolean comboQualificationStatus() {
      return false;
    }
    
  } ,
  
  UPDATE {

    @Override
    String title() {
      return "Actualizar Final";
    }

    @Override
    boolean buttonSubjectStatus() {
      return true;
    }

    @Override
    boolean buttonStudentStatus() {
      return true;
    }

    @Override
    boolean comboQualificationStatus() {
      return true;
    }
    
  };
  
  abstract String title();
  
  abstract boolean buttonSubjectStatus();
  
  abstract boolean buttonStudentStatus();
  
  abstract boolean comboQualificationStatus();
  
}
