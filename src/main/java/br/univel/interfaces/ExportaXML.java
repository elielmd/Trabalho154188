package br.univel.interfaces;

import java.io.File;

public interface ExportaXML<T> {

	public boolean ExportarXml(T t, File arq);

	public T ImportarXml(T t, File arq);

}
