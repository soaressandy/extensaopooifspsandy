package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import entities.Contato;
import entities.Endereco;

public class AgendaProgram {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		ArrayList<Contato> list = new ArrayList<>();

		boolean continua = true;

		int opcao = 0;
		int index = 0;
		String seguir = "0";

		do {
			System.out.println("\n--- Agenda de Contatos---\n");
			System.out.println(" ");
			System.out.println("  Informe: ");
			System.out.println(" ");
			System.out.println("  <1> Cadastrar contato\n");
			System.out.println("  <2> Remover contato\n");
			System.out.println("  <3> Listar contatos\n");
			System.out.println("  <4> Pesquisar contatos\n");
			System.out.println("  <0> Sair\n ");
			System.out.print("\n  Opcao ==>  ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				list.add(cadastrarContato());
				System.out.println("\nCadastro realizado com sucesso !!! Tecle algo para continuar\n");
				sc.nextLine();
				seguir = sc.nextLine();
				break;
			case 2:
				index = removerContato(list);
				if (index == -1) {
					System.out.println("\nContato não encontrado !!! Tecle algo para continuar\n");
				} else {
					list.remove(index);
					System.out.println("\nContato removido com sucesso !!!Tecle algo para continuar\n");
				}
				sc.nextLine();
				seguir = sc.nextLine();
				break;
			case 3:
				listarContatos(list);
				System.out.println("\nTecle algo para continuar");
				sc.nextLine();
	    		seguir = sc.nextLine();
				break;
			case 4:
				pesquisarContato(list);
				break;
			case 0:
				continua = false;
				break;
			default:
				System.out.println("\nOpcao invalida !!!\n");
				sc.nextLine();				
				seguir = sc.nextLine();
				continue;
			}
		} while (continua);
		sc.close();

	}

	private static void pesquisarContato(ArrayList<Contato> list) {

		Scanner sc2 = new Scanner(System.in);
			
		int opcao = 0;
		
		do {
			System.out.println("\n--- Informe a opcao de pesquisa ---\n");
			System.out.println("\n <1> Pesquisar por CPF\n");
			System.out.println("\n <2> Pesquisar por Nome\n");
			System.out.println("\n <0> Sair da Pesquisa\n");
			System.out.print  ("\n Opcao ==> ");
			
			 opcao = sc2.nextInt();
			 
			 boolean encontrou = false;
			
			if (opcao == 1) {
				System.out.print  ("\n Informe CPF: ");
				String cpf = sc2.next();
				for (Contato c : list) {

					if (c.getCpf().equals(cpf)) {
						System.out.println(c.toString());
						encontrou = true;
						break;
					}
				}
				if (!encontrou) {
					System.out.println("Contato nao localizado para o CPF informado");
				}
			} else if (opcao == 2) {
				System.out.print  ("\n Informe Nome: ");
				String nome = sc2.next();
				for (Contato c : list) {

					if (c.getName().equals(nome)) {
						System.out.print (c.toString());;
					}
				}	
				if (!encontrou) {
					System.out.println("Contato(s) nao localizado(s) para o Nome informado");
				}
			} else if (opcao != 0) {
				System.out.println("\nOpcao invalida !!!");
				sc2.nextLine();
			}	
			
		} while (opcao != 0);
		
	}

	private static int removerContato(ArrayList<Contato> list) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("\nInforme Nome do contato que deseja remover: ");
		String name = scanner.nextLine();
		int index = 0;

		for (Contato c : list) {

			if (c.getName().equals(name)) {
				return index;
			}
			index++;
		}

		return -1;
	}

	private static void listarContatos(ArrayList<Contato> list) {

		System.out.println("\n--- Lista de Contatos ---\n");

		if (list.isEmpty()) {
			System.out.println("\nLista de contatos esta vazia !!!\n");
		} else {
			for (Contato c : list) {
				System.out.println(c.toString());
			}
		}

	}

	private static Contato cadastrarContato() throws ParseException {

		Scanner sc1 = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Nome ..........................: ");
		String name = sc1.nextLine();

		System.out.print("Rua ...........................: ");
		String rua = sc1.nextLine();

		System.out.print("Cidade ........................: ");
		String cidade = sc1.nextLine();

		System.out.print("Estado ........................: ");
		String estado = sc1.nextLine();

		Endereco endereco = new Endereco(rua, cidade, estado);

		System.out.print("Data de Nascimento (DD/MM/YYYY): ");
		String dataNascimento = sc1.nextLine();
		Date dtnasc = sdf1.parse(dataNascimento);

		System.out.print("Email .........................: ");
		String email = sc1.nextLine();

		System.out.print("Telefone .....................: ");
		Integer telefone = sc1.nextInt();

		sc1.nextLine();
		System.out.print("CPF ..........................: ");
		String cpf = sc1.nextLine();

		Contato contato = new Contato(name, endereco, dtnasc, email, telefone, cpf);

		// sc1.close();

		return contato;
	}
	

}
