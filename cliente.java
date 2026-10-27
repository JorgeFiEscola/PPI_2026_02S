import java.util.Scanner;

public class cliente {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] nomes = new String[100];
        String[] telefones = new String[100];
        String[] enderecos = new String[100];

        int total = 0;
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n=== OFICINA ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Digite um numero valido!");
                sc.nextLine();
                continue;
            }

            if (opcao == 1) {

                if (total < 100) {

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Endereco: ");
                    String endereco = sc.nextLine();

                    if (nome.isBlank() || telefone.isBlank()
                            || endereco.isBlank()) {

                        System.out.println("Preencha todos os campos!");

                    } else {

                        nomes[total] = nome;
                        telefones[total] = telefone;
                        enderecos[total] = endereco;

                        total++;

                        System.out.println("Cliente cadastrado!");
                    }

                } else {
                    System.out.println("Limite de clientes atingido!");
                }

            } else if (opcao == 2) {

                if (total == 0) {

                    System.out.println("Nenhum cliente cadastrado!");

                } else {

                    for (int i = 0; i < total; i++) {

                        System.out.println("\nCliente " + (i + 1));
                        System.out.println("Nome: " + nomes[i]);
                        System.out.println("Telefone: " + telefones[i]);
                        System.out.println("Endereco: " + enderecos[i]);

                    }
                }

            } else if (opcao == 3) {

                System.out.print("Digite o nome: ");
                String busca = sc.nextLine();

                boolean encontrado = false;

                for (int i = 0; i < total; i++) {

                    if (nomes[i].equalsIgnoreCase(busca)) {

                        System.out.println("Nome: " + nomes[i]);
                        System.out.println("Telefone: " + telefones[i]);
                        System.out.println("Endereco: " + enderecos[i]);

                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("Cliente nao encontrado!");
                }

            } else if (opcao == 0) {

                System.out.println("Saindo do sistema...");

            } else {

                System.out.println("Opcao invalida!");
            }
        }

        sc.close();
    }
}