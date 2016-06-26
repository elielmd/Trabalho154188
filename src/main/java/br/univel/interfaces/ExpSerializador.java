package br.univel.interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface ExpSerializador<T> {

	public boolean ExportaSerializable(T t, File arq) throws FileNotFoundException, IOException;

	public T ImportaSerializable(File arq) throws FileNotFoundException, IOException, ClassNotFoundException;

}
