package ar.com.unpaz.gestionfinales.presentation;

import java.io.File;

public interface ReportDialog<E> extends Dialog<E> {

  File getFile();

}
