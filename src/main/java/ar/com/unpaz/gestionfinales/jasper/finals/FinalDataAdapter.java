package ar.com.unpaz.gestionfinales.jasper;

import static java.lang.String.valueOf;
import ar.com.unpaz.gestionfinales.domain.Final;

public class FinalDataAdapter {

  private Final finalObj;
  
  public FinalDataAdapter() {
    super();
  }
  
  public FinalDataAdapter(Final finalObj) {
    this.finalObj = finalObj;
  }
  
  public String getId() {
    if(finalObj == null) {
      return "";
    }
    return String.valueOf(finalObj.getId());
  }
  
  public String getStudent() {
    if(finalObj == null) {
      return "";
    }
    return finalObj.getStudent().getFullName();
  }
  
  public String getSubject() {
    if(finalObj == null) {
      return "";
    }
    return finalObj.getSubject().getDescription();
  }
  
  public String getDate() {
    if(finalObj == null) {
      return "";
    }
    return valueOf(finalObj.getDate());
  }
  
  public String getQualification() {
    if(finalObj == null) {
      return "";
    }
    return valueOf(finalObj.getQualification().number);
  }
  
}
