package jdbc;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		Cliente c1 = new Cliente();
//		c1.setIdCliente(2);
//		c1.setNome("Fulano de Tal");
//		c1.setEmail("fulano2fiap.com");
//		c1.setCpf("888.777.666-00");
//		c1.setTelefone("(11)75878-9999");
//		c1.insereCliente();
//		
//
//		Cliente c2 = new Cliente();
//		c2.setIdCliente(1);
//		c2.setNome("Rosa Maria");
//		c2.setEmail("fulanosouza2fiap.com");
//		c2.setCpf("888.777.666-10");
//		c2.setTelefone("(11)78878-9999");
//		c2.insereCliente();
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escolha qual é a função desejada: ");
		System.out.println("1 - Incluir novo cliente");
		System.out.println("2 - Alterar um cliente");
		System.out.println("3 - Excluir um cliente");
		System.out.println("4 - Pesquisar clientes");
		System.out.println("5 - Criar nova categoria");
		System.out.println("6 - Alterar uma categoria");
		System.out.println("7 - Excluir uma categoria");
		System.out.println("8 - Pesquisar categorias");
		System.out.println("9 - Cancelar");
		
		int resposta = sc.nextInt();
		Cliente c3 = new Cliente();
		
		switch (resposta) {
		case 1: {
			
			System.out.println("Digite o código do cliente:");
			c3.setIdCliente(sc.nextInt());
			System.out.println("Informe o nome do cliente:");
			c3.setNome(sc.next());
			System.out.println("Informe o email:");
			c3.setEmail(sc.next());
			System.out.println("Informe o CPF:");
			c3.setCpf(sc.next());
			System.out.println("Informe o telefone:");
			c3.setTelefone(sc.next());
			c3.insereCliente();
			}
			break;
		
		case 2:
			System.out.println("Deseja alterar um cadastro? S ou N");
			if(sc.next().equalsIgnoreCase("S")) {
				System.out.println("Informe o Id do cliente que deseja alterar :");
				c3.setIdCliente(sc.nextInt());
				System.out.println("Informe o novo email:");
				c3.setEmail(sc.next());
				System.out.println("Informe o novo telefone:");
				c3.setTelefone(sc.next());
				c3.alteraCliente();
				
			} else {
				System.out.println("Encerrando...");
			}
			break;
			
		case 3:
			System.out.println("Deseja excluir um cadastro? S ou N");
			if(sc.next().equalsIgnoreCase("S")) {
				System.out.println("Digite o id do cliente que deseja excluir:");
				c3.setIdCliente(sc.nextInt());
				c3.excluiCliente();
				System.out.println("Cliente excluído com sucesso!");
			} else {
				System.out.println("Encerrando...");
			}
			break;
		
		case 4:{
			System.out.println("\nPesquisar um cliente");
			System.out.println("----CLIENTES");
			c3.pesquisarClientes();
			break;
			}
			
		case 5:{
			Categoria cat1 = new Categoria();
			System.out.println("Digite o código da categria:");
			cat1.setIdCategoria(sc.nextInt());
			sc.nextLine();
			System.out.println("Digite a descricao da categoria:");
			cat1.setDescricao(sc.nextLine());
			cat1.inserirCategoria();
			break;
		}
			
		case 6:{
			Categoria cat1 = new Categoria();
			System.out.println("Digite o codigo da categoria: ");
			cat1.setIdCategoria(sc.nextInt());
			sc.nextLine();
			System.out.println("Digite a descricao da categoria: ");
			cat1.setDescricao(sc.nextLine());
			cat1.alterarCategoria();
			break;
		}
		case 7:
		{
			Categoria cat1 = new Categoria();
			System.out.println("Digite o código da categoria: ");
			cat1.setIdCategoria(sc.nextInt());
			cat1.excluirCategoria();
			break;
		}
		case 8: 
		{
			Categoria cat1 = new Categoria();
			System.out.println("----Categorias");
			for(Categoria c : cat1.pesquisarCategorias()) {
				System.out.println(c);
			}
			break;
		}
		case 9:
		{
			System.out.println("Encerrando...");
			break;
		}
			
		default:
			System.out.println("Insira uma opção válida!");
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
	}

}
