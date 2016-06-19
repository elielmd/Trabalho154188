package br.univel.interfaces;

import java.io.File;

public interface Serializador<T> {
	
	/**
	 * 
	 * Verifica com reflection se T implementa serializable. Serializa o objeto no arquivo especificado
	 * 
	 * SerializadorException deixa encapsulado os erros originais
	 * 
	 * @param t
	 * @param file
	 * @throws SerializadorException
	 */
	
	public boolean gravarArquivo(T t, File arq);
	
	
	/**
	 * Le o arquivo especificado e retorna o objeto de classe utilizada na instanciacao 
	 * do Serializador(T);
	 * 
	 * Antes de retornar verifica com reflection se a classe é correta.
	 * 
	 * @param file
	 * @return
	 * @throws SerializadorException
	 */
	public T lerArquivo(File arq);	

}
