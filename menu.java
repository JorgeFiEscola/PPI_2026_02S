import java.util.Scanner;

public class menu {

    // Os dados ficam guardados enquanto o programa estiver aberto.
    // CLIENTES
    static String[] nomes = new String[100];
    static String[] telefones = new String[100];
    static String[] enderecos = new String[100];
    static int totalClientes = 0;

    // ATENDIMENTOS
    static String[] placasAtendimento = new String[100];
    static String[] datas = new String[100];
    static String[] problemas = new String[100];
    static String[] status = new String[100];
    static int totalAtendimentos = 0;
    static String statusInicial = "Aguardando";

    // SERVICOS
    static final int MAX_SERVICOS = 100;
    static final int MAX_PECAS = 10;
    static String[] descricaoServicos = new String[MAX_SERVICOS];
    static double[] maoObra = new double[MAX_SERVICOS];
    static int[] numeroAtendimento = new int[MAX_SERVICOS];
    static double[] totalServico = new double[MAX_SERVICOS];
    static String[][] descricaoPeca = new String[MAX_SERVICOS][MAX_PECAS];
    static double[][] valorPeca = new double[MAX_SERVICOS][MAX_PECAS];
    static String[][] statusPeca = new String[MAX_SERVICOS][MAX_PECAS];
    static int[] quantidadePecas = new int[MAX_SERVICOS];
    static int quantidadeServicos = 0;

    // VEICULOS
    static String[] placasVeiculo = new String[100];
    static String[] marcas = new String[100];
    static String[] modelos = new String[100];
    static int[] anos = new int[100];
    static int[] quilometragens = new int[100];
    static String[] donos = new String[100];
    static int totalVeiculos = 0;

    // FUNCIONARIOS - dados guardados em vetores, como no cadastro de clientes
    static String[] nomesFuncionarios = new String[100];
    static String[] telefonesFuncionarios = new String[100];
    static String[] cargosFuncionarios = new String[100];
    static String[] situacoesFuncionarios = new String[100];
    static int totalFuncionarios = 0;

    public static void main(String[] args) {
        Scanner usuario = new Scanner(System.in);
        int tipoUsuario = 0;

        while (tipoUsuario != 1 && tipoUsuario != 2) {
            System.out.println("Digite 1 para Administrador ou 2 para Funcionario:");
            tipoUsuario = lerInt(usuario);
            if (tipoUsuario != 1 && tipoUsuario != 2) {
                System.out.println("Opcao invalida! Tente novamente.\n");
            }
        }

        boolean loginSucesso = false;
        String nome = "";
        while (!loginSucesso) {
            System.out.println("Digite suas credenciais para confirmacao.\n");
            System.out.print("Digite seu nome: ");
            nome = usuario.nextLine();
            System.out.print("Digite seu CPF: ");
            String cpf = usuario.nextLine();

            if ((tipoUsuario == 1 && nome.equals("Guto") && cpf.equals("12345")) ||
                (tipoUsuario == 2 && nome.equals("Adilson") && cpf.equals("12345"))) {
                loginSucesso = true;
            } else {
                System.out.println("\nCredenciais incorretas! Tente novamente.\n");
            }
        }

        if (tipoUsuario == 1) {
            System.out.println("\nPainel do Administrador " + nome + "!\n");
            menuAdministrador(usuario);
        } else {
            System.out.println("\nPainel do Funcionario " + nome + "!\n");
            menuFuncionario(usuario);
        }
        usuario.close();
    }

    // Evita erro se alguem digitar texto em vez de um numero inteiro.
    public static int lerInt(Scanner sc) {
        while (true) {
            String entrada = sc.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Digite um numero inteiro valido: ");
            }
        }
    }

    public static double lerDouble(Scanner sc) {
        while (true) {
            String entrada = sc.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Digite um valor valido: ");
            }
        }
    }

    public static void menuAdministrador(Scanner usuario) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n--Menu do Adm--\n");
            System.out.println("1. Visao geral da oficina");
            System.out.println("2. Gerenciar atendimentos");
            System.out.println("3. Gerenciar Clientes");
            System.out.println("4. Gerenciar Veiculos");
            System.out.println("5. Gerenciar Funcionarios");
            System.out.println("6. Gerenciar servicos e orcamentos");
            System.out.println("7. Gerenciar pecas");
            System.out.println("8. Historico e relatorios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = lerInt(usuario);
            System.out.println();

            if (opcao == 1) {
                System.out.println("Voce esta na visao geral da oficina");
            } else if (opcao == 2) {
                menuAtendimentos(usuario); 
            } else if (opcao == 3) {
                menuClientes(usuario); 
            } else if (opcao == 4) {
                menuVeiculos(usuario); 
            } else if (opcao == 5) {
                menuFuncionarios(usuario);
            } else if (opcao == 6) {
                menuServicos(usuario); 
            } else if (opcao == 7) {
                System.out.println("Aqui estao suas pecas");
            } else if (opcao == 8) {
                menuRelatorios(usuario);
            } else if (opcao == 0) {
                sair = true;
                System.out.println("Saindo do painel do Administrador...");
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }

    public static void menuFuncionario(Scanner usuario) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n--Menu do Funcionario--\n");
            System.out.println("1. Meu painel");
            System.out.println("2. Meus servicos");
            System.out.println("3. Atendimentos");
            System.out.println("4. Meu historico");
            System.out.println("5. Meu perfil");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = lerInt(usuario);

            if (opcao == 1) {
                System.out.println("Voce esta em seu painel");
            } else if (opcao == 2) {
                menuServicos(usuario);
            } else if (opcao == 3) {
                menuAtendimentos(usuario);
            } else if (opcao == 4) {
                System.out.println("Aqui esta seu historico");
            } else if (opcao == 5) {
                System.out.println("Aqui esta seu perfil");
            } else if (opcao == 0) {
                sair = true;
                System.out.println("Programa encerrado com sucesso. Ate logo!");
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }

    // ==================== CLIENTES ====================
    public static void menuClientes(Scanner sc) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== CLIENTES - OFICINA ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = lerInt(sc);

            if (opcao == 1) {
                if (totalClientes < 100) {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Endereco: ");
                    String endereco = sc.nextLine();
                    if (nome.isBlank() || telefone.isBlank() || endereco.isBlank()) {
                        System.out.println("Preencha todos os campos!");
                    } else {
                        nomes[totalClientes] = nome;
                        telefones[totalClientes] = telefone;
                        enderecos[totalClientes] = endereco;
                        totalClientes++;
                        System.out.println("Cliente cadastrado!");
                    }
                } else {
                    System.out.println("Limite de clientes atingido!");
                }
            } else if (opcao == 2) {
                if (totalClientes == 0) {
                    System.out.println("Nenhum cliente cadastrado!");
                } else {
                    for (int i = 0; i < totalClientes; i++) {
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
                for (int i = 0; i < totalClientes; i++) {
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
                System.out.println("Voltando ao menu...");
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }

    // ==================== ATENDIMENTOS ====================
    public static void registrarAtendimento(Scanner sc) {
        if (totalAtendimentos < 100) {
            System.out.print("Placa do veiculo: ");
            String placa = sc.nextLine();
            System.out.print("Data de entrada (dd/mm/aaaa): ");
            String data = sc.nextLine();
            System.out.print("Problema relatado: ");
            String problema = sc.nextLine();
            if (placa.isBlank() || data.isBlank() || problema.isBlank()) {
                System.out.println("Preencha todos os campos!");
            } else {
                placasAtendimento[totalAtendimentos] = placa;
                datas[totalAtendimentos] = data;
                problemas[totalAtendimentos] = problema;
                status[totalAtendimentos] = statusInicial;
                totalAtendimentos++;
                System.out.println("Atendimento numero " + totalAtendimentos + " registrado!");
            }
        } else {
            System.out.println("Limite de atendimentos atingido!");
        }
    }

    public static void consultarAtendimentos() {
        if (totalAtendimentos == 0) {
            System.out.println("Nenhum atendimento registrado!");
        } else {
            for (int i = 0; i < totalAtendimentos; i++) {
                System.out.println("\nAtendimento " + (i + 1));
                System.out.println("Placa: " + placasAtendimento[i]);
                System.out.println("Data de entrada: " + datas[i]);
                System.out.println("Problema relatado: " + problemas[i]);
                System.out.println("Status: " + status[i]);
            }
        }
    }

    public static void menuAtendimentos(Scanner sc) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GERENCIAR ATENDIMENTOS ===");
            System.out.println("1 - Registrar atendimento");
            System.out.println("2 - Consultar atendimentos");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = lerInt(sc);
            if (opcao == 1) {
                registrarAtendimento(sc);
            } else if (opcao == 2) {
                consultarAtendimentos();
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu...");
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }

    // ==================== SERVICOS ====================
    public static void menuServicos(Scanner tec) {
        int opcao;
        do {
            System.out.println("\n=== SERVICOS DALL CAR ===");
            System.out.println("1 - Cadastrar servicos");
            System.out.println("2 - Consultar atendimento");
            System.out.println("0 - Voltar");
            System.out.print("Opcao: ");
            opcao = lerInt(tec);

            switch (opcao) {
                case 1:
                    if (quantidadeServicos < MAX_SERVICOS) {
                        int posicao = quantidadeServicos;
                        System.out.print("N do atendimento: ");
                        int numero = lerInt(tec);
                        if (numero < 1 || numero > totalAtendimentos) {
                            System.out.println("Atendimento nao existe. Registre o atendimento primeiro.");
                            break;
                        }
                        numeroAtendimento[posicao] = numero;
                        System.out.print("Descricao do servico: ");
                        String descricao = tec.nextLine();
                        if (descricao.isBlank()) {
                            System.out.println("Descricao obrigatoria. Cadastro cancelado.");
                            break;
                        }
                        descricaoServicos[posicao] = descricao;
                        System.out.print("Valor da mao de obra: R$ ");
                        double valorMaoObra = lerDouble(tec);
                        if (valorMaoObra < 0 || !Double.isFinite(valorMaoObra)) {
                            System.out.println("Valor invalido. Cadastro cancelado.");
                            break;
                        }
                        maoObra[posicao] = valorMaoObra;
                        System.out.print("Quantidade de pecas (0 a 10): ");
                        int qtd = lerInt(tec);
                        if (qtd < 0 || qtd > MAX_PECAS) {
                            System.out.println("Quantidade invalida. Cadastro cancelado.");
                            break;
                        }
                        quantidadePecas[posicao] = qtd;
                        double somaPecas = 0;
                        boolean cadastroValido = true;
                        for (int p = 0; p < qtd; p++) {
                            System.out.println("\nPeca " + (p + 1));
                            System.out.print("Descricao: ");
                            descricaoPeca[posicao][p] = tec.nextLine();
                            System.out.print("Valor: R$ ");
                            valorPeca[posicao][p] = lerDouble(tec);
                            if (descricaoPeca[posicao][p].isBlank() ||
                                valorPeca[posicao][p] < 0 || !Double.isFinite(valorPeca[posicao][p])) {
                                System.out.println("Dados da peca invalidos. Cadastro cancelado.");
                                cadastroValido = false;
                                break;
                            }
                            System.out.print("A peca esta disponivel? (S/N): ");
                            String resposta = tec.nextLine();
                            if (resposta.equalsIgnoreCase("S")) {
                                statusPeca[posicao][p] = "Disponivel";
                            } else {
                                statusPeca[posicao][p] = "Aguardando";
                            }
                            somaPecas += valorPeca[posicao][p];
                        }
                        if (!cadastroValido) {
                            break;
                        }
                        totalServico[posicao] = maoObra[posicao] + somaPecas;
                        quantidadeServicos++;
                        System.out.println("\nServico cadastrado!");
                        System.out.printf("Total do servico: R$ %.2f%n", totalServico[posicao]);
                    } else {
                        System.out.println("Limite de servicos atingido!");
                    }
                    break;

                case 2:
                    System.out.print("Numero do atendimento para consultar: ");
                    int atendimentoBusca = lerInt(tec);
                    boolean encontrou = false;
                    double totalAtendimento = 0;
                    for (int i = 0; i < quantidadeServicos; i++) {
                        if (numeroAtendimento[i] == atendimentoBusca) {
                            encontrou = true;
                            System.out.println("\nServico: " + descricaoServicos[i]);
                            System.out.printf("Mao de obra: R$ %.2f%n", maoObra[i]);
                            for (int p = 0; p < quantidadePecas[i]; p++) {
                                System.out.println("Peca: " + descricaoPeca[i][p]);
                                System.out.printf("Valor: R$ %.2f%n", valorPeca[i][p]);
                                System.out.println("Situacao: " + statusPeca[i][p]);
                            }
                            System.out.printf("Total do servico: R$ %.2f%n", totalServico[i]);
                            totalAtendimento += totalServico[i];
                        }
                    }
                    if (encontrou) {
                        System.out.printf("\nTotal do atendimento: R$ %.2f%n", totalAtendimento);
                    } else {
                        System.out.println("Nenhum servico encontrado para esse atendimento.");
                    }
                    break;

                case 0:
                    System.out.println("Voltando ao menu...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    // ==================== VEICULOS ====================
    public static void menuVeiculos(Scanner enter) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== VEICULOS - OFICINA ===");
            System.out.println("1 - Consultar veiculos");
            System.out.println("2 - Cadastrar veiculo");
            System.out.println("0 - Voltar");
            System.out.print("Comando: ");
            opcao = lerInt(enter);

            if (opcao == 1) {
                if (totalVeiculos == 0) {
                    System.out.println("Nenhum veiculo cadastrado!");
                } else {
                    for (int i = 0; i < totalVeiculos; i++) {
                        System.out.println("\nVeiculo " + (i + 1));
                        System.out.println("Placa: " + placasVeiculo[i]);
                        System.out.println("Cliente: " + donos[i]);
                        System.out.println("Modelo: " + modelos[i]);
                        System.out.println("Marca: " + marcas[i]);
                        System.out.println("Ano: " + anos[i]);
                        System.out.println("Quilometragem: " + quilometragens[i]);
                    }
                }
            } else if (opcao == 2) {
                if (totalVeiculos >= 100) {
                    System.out.println("Limite de veiculos atingido!");
                    continue;
                }
                int i = totalVeiculos;
                System.out.print("Cadastre a placa do veiculo: ");
                String placa = enter.nextLine();
                System.out.print("Cadastre o modelo do veiculo: ");
                String modelo = enter.nextLine();
                System.out.print("Cadastre a marca do veiculo: ");
                String marca = enter.nextLine();
                System.out.print("Cadastre a quilometragem do veiculo: ");
                int km = lerInt(enter);
                System.out.print("Cadastre o ano do veiculo: ");
                int ano = lerInt(enter);
                while (ano < 1886 || ano > 9999) {
                    System.out.print("Ano invalido! Insira novamente: ");
                    ano = lerInt(enter);
                }
                System.out.print("Cadastre o dono do veiculo: ");
                String dono = enter.nextLine();

                if (placa.isBlank() || modelo.isBlank() || marca.isBlank() || dono.isBlank() || km < 0) {
                    System.out.println("Dados invalidos! Cadastro cancelado.");
                    continue;
                }
                // O dono deve existir no cadastro de clientes.
                boolean clienteExiste = false;
                for (int c = 0; c < totalClientes; c++) {
                    if (nomes[c].equalsIgnoreCase(dono)) {
                        dono = nomes[c];
                        clienteExiste = true;
                        break;
                    }
                }
                if (!clienteExiste) {
                    System.out.println("Cliente nao cadastrado! Cadastre-o no menu Clientes primeiro.");
                    continue;
                }
                placasVeiculo[i] = placa;
                modelos[i] = modelo;
                marcas[i] = marca;
                quilometragens[i] = km;
                anos[i] = ano;
                donos[i] = dono;
                totalVeiculos++;
                System.out.println("Veiculo cadastrado!");
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu...");
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }

    // ==================== FUNCIONARIOS - OPCAO 5 DO ADMIN ====================
    public static void menuFuncionarios(Scanner sc) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GERENCIAR FUNCIONARIOS ===");
            System.out.println("1 - Cadastrar funcionario");
            System.out.println("2 - Listar funcionarios");
            System.out.println("3 - Buscar funcionario");
            System.out.println("4 - Alterar situacao do funcionario");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = lerInt(sc);

            if (opcao == 1) {
                if (totalFuncionarios < 100) {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine().trim();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine().trim();
                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine().trim();
                    if (nome.isBlank() || telefone.isBlank() || cargo.isBlank()) {
                        System.out.println("Preencha todos os campos!");
                    } else {
                        nomesFuncionarios[totalFuncionarios] = nome;
                        telefonesFuncionarios[totalFuncionarios] = telefone;
                        cargosFuncionarios[totalFuncionarios] = cargo;
                        situacoesFuncionarios[totalFuncionarios] = "Ativo";
                        totalFuncionarios++;
                        System.out.println("Funcionario cadastrado!");
                    }
                } else {
                    System.out.println("Limite de funcionarios atingido!");
                }
            } else if (opcao == 2) {
                if (totalFuncionarios == 0) {
                    System.out.println("Nenhum funcionario cadastrado!");
                } else {
                    for (int i = 0; i < totalFuncionarios; i++) {
                        System.out.println("\nFuncionario " + (i + 1));
                        System.out.println("Nome: " + nomesFuncionarios[i]);
                        System.out.println("Telefone: " + telefonesFuncionarios[i]);
                        System.out.println("Cargo: " + cargosFuncionarios[i]);
                        System.out.println("Situacao: " + situacoesFuncionarios[i]);
                    }
                }
            } else if (opcao == 3) {
                System.out.print("Digite o nome: ");
                String busca = sc.nextLine().trim();
                boolean encontrado = false;
                for (int i = 0; i < totalFuncionarios; i++) {
                    if (nomesFuncionarios[i].equalsIgnoreCase(busca)) {
                        System.out.println("\nFuncionario " + (i + 1));
                        System.out.println("Nome: " + nomesFuncionarios[i]);
                        System.out.println("Telefone: " + telefonesFuncionarios[i]);
                        System.out.println("Cargo: " + cargosFuncionarios[i]);
                        System.out.println("Situacao: " + situacoesFuncionarios[i]);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Funcionario nao encontrado!");
                }
            } else if (opcao == 4) {
                System.out.print("Numero do funcionario na lista: ");
                int numero = lerInt(sc);
                if (numero < 1 || numero > totalFuncionarios) {
                    System.out.println("Funcionario nao encontrado!");
                } else {
                    int i = numero - 1;
                    System.out.println("Funcionario: " + nomesFuncionarios[i]);
                    System.out.println("1 - Ativo");
                    System.out.println("2 - Inativo");
                    System.out.print("Escolha: ");
                    int situacao = lerInt(sc);
                    if (situacao == 1) {
                        situacoesFuncionarios[i] = "Ativo";
                        System.out.println("Situacao atualizada!");
                    } else if (situacao == 2) {
                        situacoesFuncionarios[i] = "Inativo";
                        System.out.println("Situacao atualizada!");
                    } else {
                        System.out.println("Opcao invalida!");
                    }
                }
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu do administrador...");
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }

    // ==================== HISTORICO E RELATORIOS - OPCAO 8 ====================
    public static void menuRelatorios(Scanner sc) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== HISTORICO E RELATORIOS ===");
            System.out.println("1 - Resumo geral da oficina");
            System.out.println("2 - Historico dos atendimentos");
            System.out.println("3 - Relatorio de servicos e valores");
            System.out.println("4 - Consultar historico por placa");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = lerInt(sc);

            if (opcao == 1) {
                int ativos = 0;
                for (int i = 0; i < totalFuncionarios; i++) {
                    if (situacoesFuncionarios[i].equals("Ativo")) {
                        ativos++;
                    }
                }
                double valorTotal = 0;
                for (int i = 0; i < quantidadeServicos; i++) {
                    valorTotal += totalServico[i];
                }
                System.out.println("\n=== RESUMO GERAL ===");
                System.out.println("Clientes cadastrados: " + totalClientes);
                System.out.println("Veiculos cadastrados: " + totalVeiculos);
                System.out.println("Funcionarios cadastrados: " + totalFuncionarios);
                System.out.println("Funcionarios ativos: " + ativos);
                System.out.println("Atendimentos registrados: " + totalAtendimentos);
                System.out.println("Servicos cadastrados: " + quantidadeServicos);
                System.out.printf("Soma dos servicos orcados: R$ %.2f%n", valorTotal);
                System.out.println("OBS: valor orcado nao significa pagamento recebido.");

            } else if (opcao == 2) {
                if (totalAtendimentos == 0) {
                    System.out.println("Nenhum atendimento registrado!");
                } else {
                    for (int i = 0; i < totalAtendimentos; i++) {
                        System.out.println("\nAtendimento " + (i + 1));
                        System.out.println("Placa: " + placasAtendimento[i]);
                        System.out.println("Data de entrada: " + datas[i]);
                        System.out.println("Problema: " + problemas[i]);
                        System.out.println("Situacao: " + status[i]);
                    }
                }

            } else if (opcao == 3) {
                if (quantidadeServicos == 0) {
                    System.out.println("Nenhum servico cadastrado!");
                } else {
                    double valorTotal = 0;
                    for (int i = 0; i < quantidadeServicos; i++) {
                        System.out.println("\nServico " + (i + 1));
                        System.out.println("Atendimento: " + numeroAtendimento[i]);
                        System.out.println("Descricao: " + descricaoServicos[i]);
                        System.out.printf("Mao de obra: R$ %.2f%n", maoObra[i]);
                        System.out.println("Quantidade de pecas: " + quantidadePecas[i]);
                        System.out.printf("Total do servico: R$ %.2f%n", totalServico[i]);
                        valorTotal += totalServico[i];
                    }
                    System.out.printf("\nTOTAL ORCADO: R$ %.2f%n", valorTotal);
                    System.out.println("OBS: nao representa faturamento recebido.");
                }

            } else if (opcao == 4) {
                System.out.print("Digite a placa do veiculo: ");
                String placaBusca = sc.nextLine().trim();
                boolean encontrado = false;
                double valorTotal = 0;
                for (int i = 0; i < totalAtendimentos; i++) {
                    if (placasAtendimento[i].equalsIgnoreCase(placaBusca)) {
                        encontrado = true;
                        int numero = i + 1;
                        System.out.println("\nAtendimento " + numero);
                        System.out.println("Data: " + datas[i]);
                        System.out.println("Problema: " + problemas[i]);
                        System.out.println("Situacao: " + status[i]);
                        for (int j = 0; j < quantidadeServicos; j++) {
                            if (numeroAtendimento[j] == numero) {
                                System.out.println("Servico: " + descricaoServicos[j]);
                                System.out.printf("Valor: R$ %.2f%n", totalServico[j]);
                                valorTotal += totalServico[j];
                            }
                        }
                    }
                }
                if (encontrado) {
                    System.out.printf("Total orcado para a placa: R$ %.2f%n", valorTotal);
                } else {
                    System.out.println("Nenhum atendimento encontrado para esta placa!");
                }

            } else if (opcao == 0) {
                System.out.println("Voltando ao menu do administrador...");
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }

}
