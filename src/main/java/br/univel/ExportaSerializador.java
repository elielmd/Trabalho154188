package br.univel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.univel.interfaces.ExpSerializador;

public class ExportaSerializador<T> implements ExpSerializador<T>{

	@SuppressWarnings("resource")
	@Override
	public boolean ExportaSerializable(T t, File arq) throws IOException {
		boolean resultado = false;
		
		FileOutputStream fos = new FileOutputStream(arq);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(fos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		oos.writeObject(t);
		resultado = true;
		
		return resultado;
		
	}

	@SuppressWarnings({ "unchecked", "resource" })
	@Override
	public T ImportaSerializable(File arq) throws IOException, ClassNotFoundException{
	
		FileInputStream fis   = new FileInputStream(arq);
		ObjectInputStream ois = new ObjectInputStream(fis);
				
		Object object = ois.readObject();
			
		return (T) object;			
	} 	
}
