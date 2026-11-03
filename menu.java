import java.util.Scanner;

public class menu {

	public static void main(String[] args) {

		Scanner usuario = new Scanner(System.in);

		int tipoUsuario = 0;

		while (tipoUsuario != 1 && tipoUsuario != 2) {
			System.out.println("Digite 1 para Administrador ou 2 para Funcionário:");
			tipoUsuario = usuario.nextInt();
			usuario.nextLine();
			if (tipoUsuario != 1 && tipoUsuario != 2) {
				System.out.println("Opção inválida! Tente novamente.\n");
			}
		}
		if (tipoUsuario == 1) {

			boolean loginSucesso = false;
			String Nome = "";
			String CPF = "";

			while (!loginSucesso) {
				System.out.println("Digite suas credenciais para confirmação.\n");

				System.out.print("Digite seu nome: ");
				Nome = usuario.nextLine();

				System.out.print("Digite seu CPF: ");
				CPF = usuario.nextLine();

				if (Nome.equals("Guto") && CPF.equals("12345")) {
					loginSucesso = true;
				} else {
					System.out.println("\nCredenciais incorretas! Tente novamente.\n");
				}
			}

			System.out.println("\nPainel do Administrador " + Nome + "!\n");

			System.out.println("--Menu do Adm--\n");

			boolean sair = false;
			while (!sair) {
				System.out.println("1. Visão geral da oficina");
				System.out.println("2.Gerenciar atendimentos ");
				System.out.println("3. Gerenciar Clientes");
				System.out.println("4. Gerenciar Veículos");
				System.out.println("5. Gerenciar Funcionários");
				System.out.println("6. Gerenciar serviços e orçamentos");
				System.out.println("7. Gerenciar peças");
				System.out.println("8. Histórico e relatórios");
				System.out.println("0. Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = usuario.nextInt();
				usuario.nextLine();

				System.out.println();

				if (opcao == 1) {
					System.out.println("Você está o geral da oficina");
				} else if (opcao == 2) {
					System.out.println("Aqui estão seus atendimentos");
				} else if (opcao == 3) {
					System.out.println("Aqui estão seus clientes");
				} else if (opcao == 4) {
					System.out.println("Aqui estão seus veículos");
				} else if (opcao == 5) {
					System.out.println("Aqui estão seus funcionários");
				} else if (opcao == 6) {
					System.out.println("Aqui estão seus serviços e orçamentos");
				} else if (opcao == 7) {
					System.out.println("Aqui estão suas peças");
				} else if (opcao == 8) {
					System.out.println("Aqui estão seus relatórios");
				} else if (opcao == 0) {
					sair = true;
					System.out.println("Saindo do painel do Administrador...");
				} else {
					System.out.println("Opção inválida!");
				}
				System.out.println();
			}
		}

		else if (tipoUsuario == 2) {

			boolean loginSucesso = false;
			String Nome = "";
			String CPF = "";

			while (!loginSucesso) {
				System.out.println("Digite suas credenciais para confirmação.\n");

				System.out.print("Digite seu nome: ");
				Nome = usuario.nextLine();

				System.out.print("Digite seu CPF: ");
				CPF = usuario.nextLine();

				if (Nome.equals("Adilson") && CPF.equals("12345")) {
					loginSucesso = true;
				} else {
					System.out.println("\nCredenciais incorretas! Tente novamente.\n");
				}
			}

			System.out.println("\nPainel do funcionário " + Nome + "!\n");

			System.out.println("--Menu do Funcionário--\n");

			boolean sair = false;

			while (!sair) {
				System.out.println("1. Meu painel");
				System.out.println("2. Meus serviços");
				System.out.println("3. Atendimentos");
				System.out.println("4. Meu histórico");
				System.out.println("5. Meu perfil");
				System.out.println("0. Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = usuario.nextInt(); 
				usuario.nextLine();

				System.out.println();

				if (opcao == 1) {
					System.out.println("Você está em seu Painel");
				} else if (opcao == 2) {

					System.out.println("Aqui estão seus Serviços");

				} else if (opcao == 3) {
					System.out.println("Aqui estão seus Atendimentos");

				} else if (opcao == 4) {
					System.out.println("Aqui está seu Histórico");

				} else if (opcao == 5) {
					System.out.println("Aqui está seu Perfil");

				} else if (opcao == 0) {
					sair = true;
					System.out.println("Programa encerrado com sucesso. Até logo!.");
				} else {
					System.out.println("Opção inválida!");
				}

				System.out.println();
			}

			usuario.close();
		}
	}
}