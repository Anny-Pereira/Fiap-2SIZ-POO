package br.com.fiap.produtos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RepositorioProduto implements IRepositorio<Produto> {
	
	List<Produto> lista = new ArrayList<Produto>();
	

	@Override
	public void adicionar(Produto item) {
		lista.add(item);
		
	}

	@Override
	public void remover(Produto item) {
		lista.remove(item);
		
	}

	@Override
	public List<Produto> listarTodos() {
		return lista;
	}

	@Override
	public List<Produto> filtrarPor(Predicate<Produto> criterio) {
		//strem - leitura ativa da lista enquanto a função não é finalizada
		return lista.stream().filter(criterio).collect(Collectors.toList());
	}

}
