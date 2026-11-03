
import java.util.Scanner;

public class menu {

    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);

        // Arrays para armazenar clientes
        String[] nomes = new String[100];
        String[] telefones = new String[100];
        String[] enderecos = new String[100];

        int total = 0;
        int tipoUsuario = 0;

        // ESCOLHER TIPO DE USUARIO
        while (tipoUsuario != 1 && tipoUsuario != 2) {

            System.out.println("=== OFICINA DALL CAR ===");
            System.out.println("1 - Administrador");
            System.out.println("2 - Funcionario");
            System.out.print("Escolha: ");

            if (usuario.hasNextInt()) {
                tipoUsuario = usuario.nextInt();
                usuario.nextLine();
            } else {
                usuario.nextLine();
            }

            if (tipoUsuario != 1 && tipoUsuario != 2) {
                System.out.println("Opcao invalida!\n");
            }
        }

        // ADMINISTRADOR
        if (tipoUsuario == 1) {

            boolean loginSucesso = false;
            String nome = "";

            while (!loginSucesso) {

                System.out.println("\n=== LOGIN ADMIN ===");

                System.out.print("Digite seu nome: ");
                nome = usuario.nextLine();

                System.out.print("Digite seu CPF: ");
                String cpf = usuario.nextLine();

                if (nome.equals("Guto") && cpf.equals("12345")) {
                    loginSucesso = true;
                } else {
                    System.out.println("Credenciais incorretas!");
                }
            }

            System.out.println("\nBem-vindo, " + nome + "!");

            boolean sair = false;

            while (!sair) {

                System.out.println("\n=== MENU ADMIN ===");
                System.out.println("1 - Visao geral da oficina");
                System.out.println("2 - Gerenciar atendimentos");
                System.out.println("3 - Gerenciar clientes");
                System.out.println("4 - Gerenciar veiculos");
                System.out.println("5 - Gerenciar funcionarios");
                System.out.println("6 - Servicos e orcamentos");
                System.out.println("7 - Gerenciar pecas");
                System.out.println("8 - Historico e relatorios");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                int opcao = -1;

                if (usuario.hasNextInt()) {
                    opcao = usuario.nextInt();
                    usuario.nextLine();
                } else {
                    usuario.nextLine();
                }

                if (opcao == 1) {

                    System.out.println("Visao geral da oficina");

                } else if (opcao == 2) {

                    System.out.println("Gerenciar atendimentos");

                } else if (opcao == 3) {

                    // SUBMENU DE CLIENTES
                    int opcaoCliente = -1;

                    while (opcaoCliente != 0) {

                        System.out.println("\n=== GERENCIAR CLIENTES ===");
                        System.out.println("1 - Cadastrar cliente");
                        System.out.println("2 - Listar clientes");
                        System.out.println("3 - Buscar cliente");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha: ");

                        if (usuario.hasNextInt()) {
                            opcaoCliente = usuario.nextInt();
                            usuario.nextLine();
                        } else {
                            System.out.println("Digite um numero valido!");
                            usuario.nextLine();
                            continue;
                        }

                        if (opcaoCliente == 1) {

                            if (total < 100) {

                                System.out.print("Nome: ");
                                String cliente = usuario.nextLine();

                                System.out.print("Telefone: ");
                                String telefone = usuario.nextLine();

                                System.out.print("Endereco: ");
                                String endereco = usuario.nextLine();

                                if (cliente.isBlank()
                                        || telefone.isBlank()
                                        || endereco.isBlank()) {

                                    System.out.println(
                                        "Preencha todos os campos!"
                                    );

                                } else {

                                    nomes[total] = cliente;
                                    telefones[total] = telefone;
                                    enderecos[total] = endereco;

                                    total++;

                                    System.out.println(
                                        "Cliente cadastrado com sucesso!"
                                    );
                                }

                            } else {
                                System.out.println(
                                    "Limite de clientes atingido!"
                                );
                            }

                        } else if (opcaoCliente == 2) {

                            if (total == 0) {

                                System.out.println(
                                    "Nenhum cliente cadastrado!"
                                );

                            } else {

                                for (int i = 0; i < total; i++) {

                                    System.out.println(
                                        "\nCliente " + (i + 1)
                                    );
                                    System.out.println(
                                        "Nome: " + nomes[i]
                                    );
                                    System.out.println(
                                        "Telefone: " + telefones[i]
                                    );
                                    System.out.println(
                                        "Endereco: " + enderecos[i]
                                    );
                                }
                            }

                        } else if (opcaoCliente == 3) {

                            System.out.print("Digite o nome: ");
                            String busca = usuario.nextLine();

                            boolean encontrado = false;

                            for (int i = 0; i < total; i++) {

                                if (nomes[i].equalsIgnoreCase(busca)) {

                                    System.out.println(
                                        "\nNome: " + nomes[i]
                                    );
                                    System.out.println(
                                        "Telefone: " + telefones[i]
                                    );
                                    System.out.println(
                                        "Endereco: " + enderecos[i]
                                    );

                                    encontrado = true;
                                }
                            }

                            if (!encontrado) {
                                System.out.println(
                                    "Cliente nao encontrado!"
                                );
                            }

                        } else if (opcaoCliente == 0) {

                            System.out.println(
                                "Voltando ao menu administrador..."
                            );

                        } else {

                            System.out.println("Opcao invalida!");
                        }
                    }

                } else if (opcao == 4) {

                    System.out.println("Gerenciar veiculos");

                } else if (opcao == 5) {

                    System.out.println("Gerenciar funcionarios");

                } else if (opcao == 6) {

                    System.out.println("Servicos e orcamentos");

                } else if (opcao == 7) {

                    System.out.println("Gerenciar pecas");

                } else if (opcao == 8) {

                    System.out.println("Historico e relatorios");

                } else if (opcao == 0) {

                    sair = true;
                    System.out.println("Saindo do administrador...");

                } else {

                    System.out.println("Opcao invalida!");
                }
            }
        }

        // FUNCIONARIO
        else if (tipoUsuario == 2) {

            boolean loginSucesso = false;
            String nome = "";

            while (!loginSucesso) {

                System.out.println("\n=== LOGIN FUNCIONARIO ===");

                System.out.print("Digite seu nome: ");
                nome = usuario.nextLine();

                System.out.print("Digite seu CPF: ");
                String cpf = usuario.nextLine();

                if (nome.equals("Adilson") && cpf.equals("12345")) {
                    loginSucesso = true;
                } else {
                    System.out.println("Credenciais incorretas!");
                }
            }

            System.out.println("\nBem-vindo, " + nome + "!");

            boolean sair = false;

            while (!sair) {

                System.out.println("\n=== MENU FUNCIONARIO ===");
                System.out.println("1 - Meu painel");
                System.out.println("2 - Meus servicos");
                System.out.println("3 - Atendimentos");
                System.out.println("4 - Meu historico");
                System.out.println("5 - Meu perfil");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                int opcao = -1;

                if (usuario.hasNextInt()) {
                    opcao = usuario.nextInt();
                    usuario.nextLine();
                } else {
                    usuario.nextLine();
                }

                if (opcao == 1) {

                    System.out.println("Meu painel");

                } else if (opcao == 2) {

                    System.out.println("Meus servicos");

                } else if (opcao == 3) {

                    System.out.println("Atendimentos");

                } else if (opcao == 4) {

                    System.out.println("Meu historico");

                } else if (opcao == 5) {

                    System.out.println("Meu perfil");

                } else if (opcao == 0) {

                    sair = true;
                    System.out.println("Saindo do funcionario...");

                } else {

                    System.out.println("Opcao invalida!");
                }
            }
        }

        usuario.close();
        System.out.println("\nPrograma encerrado!");
    }
}
