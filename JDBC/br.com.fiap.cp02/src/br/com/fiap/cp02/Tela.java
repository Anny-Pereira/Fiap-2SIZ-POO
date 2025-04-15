package br.com.fiap.cp02;

import java.util.Scanner;


public class Tela {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----Escolha qual e a funcao desejada: ");
		System.out.println("1 - Incluir novo filme");
		System.out.println("2 - Alterar um filme");
		System.out.println("3 - Excluir um filme");
		System.out.println("4 - Listar Filmes");
		System.out.println("5 - Pesquisar um filme pelo genero");
		System.out.println("6 - Cancelar");
		
		int resposta = sc.nextInt();
		Filme novoFilme = new Filme();

		switch (resposta) {
		case 1: {
			
			System.out.println("Digite o codigo do filme:");
			novoFilme.setId(sc.nextInt());
			System.out.println("Digite o titulo do filme:");
			novoFilme.setTitulo(sc.next());
			System.out.println("Digite o diretor do filme:");
			novoFilme.setDiretor(sc.next());
			sc.nextLine();
			System.out.println("Digite o genero do filme:");
			novoFilme.setGenero(sc.next());
			sc.nextLine();
			System.out.println("Digite a duracao do filme em minutos:");
			novoFilme.setDuracao_min(sc.nextInt());
			novoFilme.inserirFilme();
			}
			break;
		
		case 2:
			System.out.println("Deseja alterar um cadastro? S ou N");
			if(sc.next().equalsIgnoreCase("S")) {
				System.out.println("Informe o Id do filme que deseja alterar :");
				novoFilme.setId(sc.nextInt());
				System.out.println("Informe o novo diretor:");
				novoFilme.setDiretor(sc.next());
				System.out.println("Informe o novo genero:");
				novoFilme.setGenero(sc.next());
				novoFilme.alterarFilme();
				
			} else {
				System.out.println("Encerrando...");
			}
			break;
			
		case 3:
			System.out.println("Deseja excluir um cadastro? S ou N");
			if(sc.next().equalsIgnoreCase("S")) {
				System.out.println("Digite o id do filme que deseja excluir:");
				novoFilme.setId(sc.nextInt());
				novoFilme.excluirFilme();
			} else {
				System.out.println("Encerrando...");
			}
			break;
		
		case 4:{
			System.out.println("\n---Lista de Filmes");
			System.out.println("TITULO" + "	   " + "DIRETOR" + "	" +"GENERO");
			novoFilme.listarTodos();
			break;
			}
			
		case 5:{			
			System.out.println("Digite o genero que deseja pesquisar: ");
			String respostaGenero = sc.next();
			novoFilme.buscaFilme(respostaGenero);
			break;
		}
			
		case 6:		{
			System.out.println("Encerrando...");
			break;
		}
			
		default:
			System.out.println("Insira uma opção válida!");
		}
		

	}

}
