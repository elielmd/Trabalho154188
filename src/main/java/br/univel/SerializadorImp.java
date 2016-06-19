package br.univel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import br.univel.interfaces.Serializador;

public class SerializadorImp<T> implements Serializador<T> {

	@Override
	public boolean gravarArquivo(T t, File arq) {
		Class<?>[] vet = t.getClass().getInterfaces();

		boolean achou = false;
		boolean resultado = false;

		for (Class<?> c : vet) {
			if (c.equals(Serializable.class)) {
				achou = true;
				break;
			}
		}

		if (!achou) {
			System.out.println("Nao achou..");
		}

		try (FileOutputStream fos = new FileOutputStream(arq); ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(t);
			resultado = true;
		} catch (Exception e) {
			try {
				throw new Exception(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return resultado;

	}

	@SuppressWarnings("unchecked")
	@Override
	public T lerArquivo(File arq) {

		try (FileInputStream fis = new FileInputStream(arq); ObjectInputStream ois = new ObjectInputStream(fis)) {

			Object object = ois.readObject();

			return (T) object;
		} catch (Exception e) {
			try {
				throw new Exception(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

}
