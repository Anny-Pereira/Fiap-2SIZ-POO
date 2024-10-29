package br.com.fiap.produtos;

public class Tela {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RepositorioProduto rep = new RepositorioProduto();
		
		Livro l = new Livro();
		l.setNome("Harry Potter");
		l.setPreco(39.99);
		rep.adicionar(l);
		
		Livro l2 = new Livro();
		l2.setNome("Pequeno Principe");
		l2.setPreco(19.99);
		rep.adicionar(l2);
		
		
		
		//Novos Cadastros
		Livro livro1 = new Livro();
        livro1.setNome("Dom Casmurro");
        livro1.setPreco(29.90);
        rep.adicionar(livro1);

        Livro livro2 = new Livro();
        livro2.setNome("O Guarani");
        livro2.setPreco(34.90);
        rep.adicionar(livro2);

        Livro livro3 = new Livro();
        livro3.setNome("Memórias Póstumas de Brás Cubas");
        livro3.setPreco(25.00);
        rep.adicionar(livro3);

        Livro livro4 = new Livro();
        livro4.setNome("A Moreninha");
        livro4.setPreco(27.50);
        rep.adicionar(livro4);

        Livro livro5 = new Livro();
        livro5.setNome("O Primo Basílio");
        livro5.setPreco(30.00);
        rep.adicionar(livro5);

        Livro livro6 = new Livro();
        livro6.setNome("Iracema");
        livro6.setPreco(22.50);
        rep.adicionar(livro6);

        Livro livro7 = new Livro();
        livro7.setNome("Senhora");
        livro7.setPreco(28.00);
        rep.adicionar(livro7);

        Livro livro8 = new Livro();
        livro8.setNome("A Escrava Isaura");
        livro8.setPreco(31.90);
        rep.adicionar(livro8);

        Livro livro9 = new Livro();
        livro9.setNome("Capitães da Areia");
        livro9.setPreco(33.50);
        rep.adicionar(livro9);

        Livro livro10 = new Livro();
        livro10.setNome("Os Sertões");
        livro10.setPreco(39.90);
        rep.adicionar(livro10);

        Livro livro11 = new Livro();
        livro11.setNome("O Alquimista");
        livro11.setPreco(25.90);
        rep.adicionar(livro11);

        Livro livro12 = new Livro();
        livro12.setNome("1984");
        livro12.setPreco(35.00);
        rep.adicionar(livro12);

        Livro livro13 = new Livro();
        livro13.setNome("A Revolução dos Bichos");
        livro13.setPreco(24.90);
        rep.adicionar(livro13);

        Livro livro14 = new Livro();
        livro14.setNome("Brave New World");
        livro14.setPreco(36.50);
        rep.adicionar(livro14);

        Livro livro15 = new Livro();
        livro15.setNome("O Pequeno Príncipe");
        livro15.setPreco(19.90);
        rep.adicionar(livro15);

        Livro livro16 = new Livro();
        livro16.setNome("O Hobbit");
        livro16.setPreco(45.00);
        rep.adicionar(livro16);

        Livro livro17 = new Livro();
        livro17.setNome("Cem Anos de Solidão");
        livro17.setPreco(50.00);
        rep.adicionar(livro17);

        Livro livro18 = new Livro();
        livro18.setNome("Dom Quixote");
        livro18.setPreco(40.00);
        rep.adicionar(livro18);

        Livro livro19 = new Livro();
        livro19.setNome("A Divina Comédia");
        livro19.setPreco(55.00);
        rep.adicionar(livro19);

        Livro livro20 = new Livro();
        livro20.setNome("O Morro dos Ventos Uivantes");
        livro20.setPreco(42.00);
        rep.adicionar(livro20);
        
        Livro livro21 = new Livro();
        livro20.setNome("O Coração");
        livro20.setPreco(46.00);
        rep.adicionar(livro21);
        

		
		
		//Lista os produtos incluídos
		for(Produto p : rep.listarTodos()) {
			System.out.println(p);
		}
		
		//Excluir o livro Harry Potter
		//rep.remover(l);
		
		
		System.out.println("\nLista atualizada");
		for(Produto p : rep.listarTodos()) {
			System.out.println(p);
		}
		
		
		//Listar todos os produtos com valor maior que 10,00
		System.out.println("\nProdutos com valor maior que 10,00");
		for (Produto p : rep.filtrarPor(preco -> preco.getPreco() > 10)) {
			System.out.println(p);
		}
		
		
		//Listar todos os produtos com nome igual Pequeno Principe
				System.out.println("\nProdutos com nome igual Pequeno Principe");
				for (Produto p : rep.filtrarPor(nome -> nome.getNome().equalsIgnoreCase("Pequeno Principe"))) {
					System.out.println(p);
				}
	
				
				
		
		        
		        //1- Buscar livros com preço menor que R$30
		        System.out.println("\nLivros com preco menor que R$30,00");
				for (Produto p : rep.filtrarPor(produto -> produto.getPreco() < 30)) {
					System.out.println(p);
				}
		        
				
				//2- Buscar livros com nome que começa com a letra "O"
		        System.out.println("\nLivros com nome que começa com a letra O");
				for (Produto p : rep.filtrarPor(nome -> nome.getNome().startsWith("O"))) {					
						System.out.println(p);
				}
				
				
				//3- Buscar livros que contem a palavra "Coração"
				System.out.println("\nLivros que contem a palavra Coracao");
				for(Produto p : rep.filtrarPor(livro -> livro.getNome().contains("Coração"))) {
					System.out.println(p);
				}
				
				
				//4- Buscar livros com preço maior que RS 40,00
				System.out.println("\nLivros com preco maior que R$40,00");
				for (Produto p : rep.filtrarPor(livro -> livro.getPreco() > 40.00)) {
					System.out.println(p);
				}
				
				
				//5- Buscar livros que tem exatamente 20 caracteres no nome
				System.out.println("\nLivros que tem exatamente 20 caracteres no nome");
				for(Produto p : rep.filtrarPor(livro -> livro.getNome().length() == 20)) {
					System.out.println(p);
				}
				
				
				//6- Buscar livros cujo nome termina com a letra "A"
				System.out.println("\nLivros cujo nome termina com a letra a");
				for(Produto p : rep.filtrarPor(livro -> livro.getNome().endsWith("a"))) {
					System.out.println(p);
				}
				
				
				//7- Buscar livros com nome que contem a letra "e"
				System.out.println("\nLivros com nome que contem a letra e");
				for(Produto p : rep.filtrarPor(livro -> livro.getNome().contains("e"))) {
					System.out.println(p);
				}
				
				
				//8- Buscar livros com preços entre R$30,00 e R$50,00
				System.out.println("\nLivros com com preços entre R$30,00 e R$50,00");
				for(Produto p : rep.filtrarPor(livro -> livro.getPreco() > 30 && livro.getPreco()< 50)) {
					System.out.println(p);
				}
				
				
				//9- Buscar livros cujo nome tem mais de 15 caracteres 
				System.out.println("\nLivros cujo nome tem mais de 15 caracteres ");
				for(Produto p : rep.filtrarPor(livro -> livro.getNome().length() > 15)) {
					System.out.println(p);
				}
				
		
	}

}
