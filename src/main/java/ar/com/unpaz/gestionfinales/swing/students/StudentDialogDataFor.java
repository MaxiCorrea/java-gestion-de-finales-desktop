package ar.com.unpaz.gestionfinales.swing.students;

public enum StudentDialogDataFor {

  ADD {

    @Override
    String titleDialog() {
      return "Nuevo Alumno";
    }

    @Override
    boolean dniFieldStatus() {
      return true;
    }

    @Override
    boolean nameFieldStatus() {
      return true;
    }

    @Override
    boolean surnameFieldStatus() {
      return true;
    }

    @Override
    boolean emailFieldStatus() {
      return true;
    }

    @Override
    String buttonAcceptText() {
      return "Agregar";
    }

    @Override
    String buttonCancelText() {
      return "Cancelar";
    }
    
  } ,
  
  DELETE {

    @Override
    String titleDialog() {
      return "Borrar Alumno";
    }

    @Override
    boolean dniFieldStatus() {
      return false;
    }

    @Override
    boolean nameFieldStatus() {
      return false;
    }

    @Override
    boolean surnameFieldStatus() {
      return false;
    }

    @Override
    boolean emailFieldStatus() {
      return false;
    }

    @Override
    String buttonAcceptText() {
      return "Borrar";
    }

    @Override
    String buttonCancelText() {
      return "Cancelar";
    }
    
  } ,
  
  UPDATE {

    @Override
    String titleDialog() {
      return "Actualizar Alumno";
    }

    @Override
    boolean dniFieldStatus() {
      return false;
    }

    @Override
    boolean nameFieldStatus() {
      return true;
    }

    @Override
    boolean surnameFieldStatus() {
      return true;
    }

    @Override
    boolean emailFieldStatus() {
      return true;
    }

    @Override
    String buttonAcceptText() {
      return "Actualizar";
    }

    @Override
    String buttonCancelText() {
      return "Cancelar";
    }
    
  };
  
  
  abstract String titleDialog();
  
  abstract boolean dniFieldStatus();
  
  abstract boolean nameFieldStatus();
  
  abstract boolean surnameFieldStatus();
  
  abstract boolean emailFieldStatus();
  
  abstract String buttonAcceptText();
  
  abstract String buttonCancelText();
  
}
