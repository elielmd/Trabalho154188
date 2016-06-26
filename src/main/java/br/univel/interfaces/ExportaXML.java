package br.univel.interfaces;

import java.io.File;

public interface ExportaXML<T> {

	public boolean ExportarXml(T xml, File arq);

	public T ImportarXml(T xml, File arq);

}
