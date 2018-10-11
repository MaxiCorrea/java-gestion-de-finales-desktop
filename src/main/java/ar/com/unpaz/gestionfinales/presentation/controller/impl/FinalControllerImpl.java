package ar.com.unpaz.gestionfinales.presentation.controller.impl;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;
import ar.com.unpaz.gestionfinales.presentation.controller.FinalController;
import ar.com.unpaz.gestionfinales.presentation.view.AppViewContext;

public class FinalControllerImpl implements FinalController {

  public FinalControllerImpl() {
    AppViewContext.addFinalDialog.setController( new AddFinalDialogController());
    AppViewContext.delFinalDialog.setController( new DelFinalDialogController());
    AppViewContext.updFinalDialog.setController( new UpdFinalDialogController());
  }
  
  public FinalControllerImpl(DialogController addFinalDialogController ,
                             DialogController delFinalDialogController ,
                             DialogController updFinalDialogController ) {
    
    AppViewContext.addFinalDialog.setController(addFinalDialogController);
    AppViewContext.delFinalDialog.setController(delFinalDialogController);
    AppViewContext.updFinalDialog.setController(updFinalDialogController);
  }
  
  @Override
  public void addFinal() {
   AppViewContext.addFinalDialog.setFinal(Final.EMPTY); 
   AppViewContext.addFinalDialog.show();
  }

  @Override
  public void deleteFinal() {
    if(AppViewContext.finalsView.getSelectedRow() != -1) {
      int row = AppViewContext.finalsView.getSelectedRow();
      Final finalObj = AppViewContext.finalsView.getFinalInRow(row);
      AppViewContext.delFinalDialog.setFinal(finalObj);
      AppViewContext.delFinalDialog.show();
    }
  }

  @Override
  public void updateFinal() {
    if(AppViewContext.finalsView.getSelectedRow() != -1) {
      int row = AppViewContext.finalsView.getSelectedRow();
      Final finalObj = AppViewContext.finalsView.getFinalInRow(row);
      AppViewContext.updFinalDialog.setFinal(finalObj);
      AppViewContext.updFinalDialog.show();
    }
  }

  private class AddFinalDialogController implements DialogController {

    @Override
    public void accept() {
      
    }

    @Override
    public void cancel() {
      // TODO Auto-generated method stub
      
    }
    
  }
  
  private class DelFinalDialogController implements DialogController {

    @Override
    public void accept() {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void cancel() {
      // TODO Auto-generated method stub
      
    }
    
  }
  
  private class UpdFinalDialogController implements DialogController {

    @Override
    public void accept() {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void cancel() {
      // TODO Auto-generated method stub
      
    }
    
  }
  
}
