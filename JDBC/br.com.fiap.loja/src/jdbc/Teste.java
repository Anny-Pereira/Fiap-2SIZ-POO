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
		System.out.println("I - Incluir novo cliente");
		System.out.println("A - Alterar um cliente");
		System.out.println("E - Excluir um cliente");
		
		Cliente c3 = new Cliente();
		
		String resposta = sc.next();
		
		if(resposta.equalsIgnoreCase("I")) {
			
			
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
			
		} else if(resposta.equalsIgnoreCase("A")) {
			
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
		} else if(resposta.equalsIgnoreCase("E")) {
			
			
			System.out.println("Deseja excluir um cadastro? S ou N");
			if(sc.next().equalsIgnoreCase("S")) {
				System.out.println("Digite o id do cliente que deseja excluir:");
				c3.setIdCliente(sc.nextInt());
				c3.excluiCliente();
				System.out.println("Cliente excluído com sucesso!");
			}
		} else {
			System.out.println("Insira uma opção válida!");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
