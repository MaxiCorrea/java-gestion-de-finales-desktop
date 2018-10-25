package ar.com.unpaz.gestionfinales.swing.subjects;

public enum SubjectDialogDataFor {
  
  ADD {

    @Override
    String title() {
      return "Nueva Materia";
    }

    @Override
    boolean comboYearStatus() {
      return true;
    }

    @Override
    boolean fieldDescriptionStatus() {
      return true;
    }

    @Override
    String acceptButtonName() {
      return "Agregar";
    }

    @Override
    String cancelButtonName() {
      return "Cancelar";
    }
    
  } ,
  
  DELETE {

    @Override
    String title() {
      return "Borrar Materia";
    }

    @Override
    boolean comboYearStatus() {
      return false;
    }

    @Override
    boolean fieldDescriptionStatus() {
      return false;
    }

    @Override
    String acceptButtonName() {
      return "Borrar";
    }

    @Override
    String cancelButtonName() {
      return "Cancelar";
    }
    
  } ,
  
  UPDATE {

    @Override
    String title() {
      return "Actualizar Materia";
    }

    @Override
    boolean comboYearStatus() {
      return true;
    }

    @Override
    boolean fieldDescriptionStatus() {
      return true;
    }

    @Override
    String acceptButtonName() {
      return "Actualizar";
    }

    @Override
    String cancelButtonName() {
      return "Cancelar";
    }
    
  };
  
  abstract String title();

  abstract boolean comboYearStatus();

  abstract boolean fieldDescriptionStatus(); 

  abstract String acceptButtonName();

  abstract String cancelButtonName(); 

}
