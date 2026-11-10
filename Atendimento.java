import java.util.Scanner;

// P5 - Registrar atendimento
// Registra a entrada de um veículo na oficina e o problema relatado pelo cliente
// No menu, é só chamar: Atendimento.menuAtendimentos(usuario);
public class Atendimento {

    // Vetores que guardam os dados dos atendimentos
    // (a mesma posição nos vetores é o mesmo atendimento)
    // static faz os dados ficarem guardados enquanto o programa está rodando
    static String[] placas = new String[100];     // placa do veículo (liga o atendimento ao veículo)
    static String[] datas = new String[100];      // data de entrada na oficina
    static String[] problemas = new String[100];  // problema relatado pelo cliente
    static String[] status = new String[100];     // situação do atendimento

    // quantidade de atendimentos já registrados (também é a próxima posição livre dos vetores)
    static int total = 0;

    // status inicial de todo atendimento (Trocar se precisar)
    static String statusInicial = "Aguardando";

    // Registrar: lê os dados pelo Scanner e guarda nos vetores
    static void registrar(Scanner sc) {

        // só registra se ainda tiver espaço nos vetores
        if (total < 100) {

            System.out.print("Placa do veiculo: ");
            String placa = sc.nextLine();

            System.out.print("Data de entrada (dd/mm/aaaa): ");
            String data = sc.nextLine();

            System.out.print("Problema relatado: ");
            String problema = sc.nextLine();

            // valida os campos obrigatórios 
            if (placa.isBlank() || data.isBlank() || problema.isBlank()) {

                System.out.println("Preencha todos os campos!");

            } else {

                placas[total] = placa;
                datas[total] = data;
                problemas[total] = problema;

                // o atendimento já começa com o status inicial
                status[total] = statusInicial;

                // aumenta o total (a próxima posição livre passa a ser a seguinte)
                total++;

                System.out.println("Atendimento registrado!");
            }

        } else {
            System.out.println("Limite de atendimentos atingido!");
        }
    }

    // Consultar: mostra todos os atendimentos registrados
    static void consultar() {

        if (total == 0) {

            System.out.println("Nenhum atendimento registrado!");

        } else {

            // percorre os vetores até o total registrado
            for (int i = 0; i < total; i++) {

                System.out.println("\nAtendimento " + (i + 1));
                System.out.println("Placa: " + placas[i]);
                System.out.println("Data de entrada: " + datas[i]);
                System.out.println("Problema relatado: " + problemas[i]);
                System.out.println("Status: " + status[i]);
            }
        }
    }

    // Submenu de atendimentos: é o que o menu principal chama
    static void menuAtendimentos(Scanner sc) {

        int opcao = -1;

        // repete até a pessoa digitar 0
        while (opcao != 0) {

            System.out.println("\n=== GERENCIAR ATENDIMENTOS ===");
            System.out.println("1 - Registrar atendimento");
            System.out.println("2 - Consultar atendimentos");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            // só aceita número (se digitar letra, avisa e pergunta de novo)
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
                sc.nextLine(); // limpa o Enter que sobrou depois do número
            } else {
                System.out.println("Digite um numero valido!");
                sc.nextLine();
                continue;
            }

            if (opcao == 1) {

                registrar(sc);

            } else if (opcao == 2) {

                consultar();

            } else if (opcao == 0) {

                System.out.println("Voltando ao menu...");

            } else {

                System.out.println("Opcao invalida!");
            }
        }
    }

    // main: serve só pra rodar e testar o atendimento sozinho
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        menuAtendimentos(sc);

        sc.close();
    }
}
