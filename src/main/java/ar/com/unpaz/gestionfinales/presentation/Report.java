package ar.com.unpaz.gestionfinales.presentation;

import java.io.File;

public interface Report<E> extends Dialog<E> {

  File getFile();

}
