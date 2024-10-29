package br.com.fiap.produtos;

import java.util.List;
import java.util.function.Predicate;

public interface IRepositorio<T> {
	
	public void adicionar(T item);
	
	public void remover(T item);
	
	public List<T> listarTodos();
	
	
	//Predicate - é um critério dpara filtrar
	public List<T> filtrarPor(Predicate<T> criterio);
	
	

}
