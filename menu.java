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
    static String statusInicial = "Aguardando...";

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
        boolean sair = false;

        while (!sair){
        int tipoUsuario = 0;

        while (tipoUsuario != 1 && tipoUsuario != 2) {
            System.out.println("Digite 1 para Administrador");
            System.out.println("Digite 2 para Funcionario\n");
            tipoUsuario = lerInt(usuario);
            if (tipoUsuario != 1 && tipoUsuario != 2) {
                System.out.println("Opção Inválida! Tente Novamente.\n");
            }
        }

        boolean loginSucesso = false;
        String nome = "";
        while (!loginSucesso) {
            System.out.println("Digite suas Credenciais para Confirmação.\n");
            System.out.print("Digite seu Nome: ");
            nome = usuario.nextLine();
            System.out.print("Digite seu CPF: ");
            String cpf = usuario.nextLine();

            if ((tipoUsuario == 1 && nome.equals("Guto") && cpf.equals("12345")) ||
                (tipoUsuario == 2 && nome.equals("Adilson") && cpf.equals("12345"))) {
                loginSucesso = true;
            } else {
                System.out.println("\nCredenciais Incorretas! Tente Novamente.\n");
            }
        }

        if (tipoUsuario == 1) {
            System.out.println("\nPainel do Administrador " + nome + "!\n");
            menuAdministrador(usuario);
        } else {
            System.out.println("\nPainel do Funcionário " + nome + "!\n");
            menuFuncionario(usuario);
        }
        System.out.println("\nRetornando a Tela Inicial...\n");
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
                System.out.print("Digite um Número Inteiro Válido: ");
            }
        }
    }

    public static double lerDouble(Scanner sc) {
        while (true) {
            String entrada = sc.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Digite um Valor Válido: ");
            }
        }
    }

    public static void menuAdministrador(Scanner usuario) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n--Menu do Adm--\n");
            System.out.println("1. Visão Geral da Oficina");
            System.out.println("2. Gerenciar Atendimentos");
            System.out.println("3. Gerenciar Clientes");
            System.out.println("4. Gerenciar Veículos");
            System.out.println("5. Gerenciar Funcionários");
            System.out.println("6. Gerenciar Serviços e Orçamentos");
            System.out.println("7. Gerenciar Peças");
            System.out.println("8. Histórico e Relatórios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma Opção: ");
            int opcao = lerInt(usuario);
            System.out.println();

            if (opcao == 1) {
                System.out.println("Voce está na visão Geral da Oficina");
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
                System.out.println("Aqui estão suas Peças");
            } else if (opcao == 8) {
                menuRelatorios(usuario);
            } else if (opcao == 0) {
                sair = true;
                System.out.println("Saindo do Painel do Administrador...");
            } else {
                System.out.println("Opcao Inválida!");
            }
        }
    }

    public static void menuFuncionario(Scanner usuario) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n--Menu do Funcionário--\n");
            System.out.println("1. Meu Painel");
            System.out.println("2. Meus Serviços");
            System.out.println("3. Atendimentos");
            System.out.println("4. Meu Histórico");
            System.out.println("5. Meu Perfil");
            System.out.println("0. Sair");
            System.out.print("Escolha uma Opção: ");
            int opcao = lerInt(usuario);

            if (opcao == 1) {
                System.out.println("Voce está em seu Painel");

                
                

            } else if (opcao == 2) {
                menuServicos(usuario);
            } else if (opcao == 3) {
                menuAtendimentos(usuario);
            } else if (opcao == 4) {
                System.out.println("Aqui está seu Histórico");
            } else if (opcao == 5) {
                System.out.println("Aqui está seu Perfil");
            } else if (opcao == 0) {
                sair = true;
                System.out.println("Programa encerrado com sucesso. Até logo!");
            } else {
                System.out.println("Opcao Inválida!");
            }
        }
    }

    // ==================== CLIENTES ====================
    public static void menuClientes(Scanner sc) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== CLIENTES - OFICINA ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Buscar Cliente");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = lerInt(sc);

            if (opcao == 1) {
                if (totalClientes < 100) {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    if (nome.isBlank() || telefone.isBlank() || endereco.isBlank()) {
                        System.out.println("Preencha Todos os Campos!");
                    } else {
                        nomes[totalClientes] = nome;
                        telefones[totalClientes] = telefone;
                        enderecos[totalClientes] = endereco;
                        totalClientes++;
                        System.out.println("Cliente Cadastrado!");
                    }
                } else {
                    System.out.println("Limite de Clientes Atingido!");
                }
            } else if (opcao == 2) {
                if (totalClientes == 0) {
                    System.out.println("Nenhum Cliente Cadastrado!");
                } else {
                    for (int i = 0; i < totalClientes; i++) {
                        System.out.println("\nCliente " + (i + 1));
                        System.out.println("Nome: " + nomes[i]);
                        System.out.println("Telefone: " + telefones[i]);
                        System.out.println("Endereço: " + enderecos[i]);
                    }
                }
            } else if (opcao == 3) {
                System.out.print("Digite o Nome: ");
                String busca = sc.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < totalClientes; i++) {
                    if (nomes[i].equalsIgnoreCase(busca)) {
                        System.out.println("Nome: " + nomes[i]);
                        System.out.println("Telefone: " + telefones[i]);
                        System.out.println("Endereço: " + enderecos[i]);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Cliente não Encontrado!");
                }
            } else if (opcao == 0) {
                System.out.println("Voltando ao Menu...");
            } else {
                System.out.println("Opcao Inválida!");
            }
        }
    }

    // ==================== ATENDIMENTOS ====================
    public static void registrarAtendimento(Scanner sc) {
        if (totalAtendimentos < 100) {
            System.out.print("Placa do Veículo: ");
            String placa = sc.nextLine();
            System.out.print("Data de Entrada (dd/mm/aaaa): ");
            String data = sc.nextLine();
            System.out.print("Problema Relatado: ");
            String problema = sc.nextLine();
            if (placa.isBlank() || data.isBlank() || problema.isBlank()) {
                System.out.println("Preencha Todos os Campos!");
            } else {
                placasAtendimento[totalAtendimentos] = placa;
                datas[totalAtendimentos] = data;
                problemas[totalAtendimentos] = problema;
                status[totalAtendimentos] = statusInicial;
                totalAtendimentos++;
                System.out.println("Atendimento Número " + totalAtendimentos + " Registrado!");
            }
        } else {
            System.out.println("Limite de Atendimentos Atingido!");
        }
    }

    public static void consultarAtendimentos() {
        if (totalAtendimentos == 0) {
            System.out.println("Nenhum Atendimento Registrado!");
        } else {
            for (int i = 0; i < totalAtendimentos; i++) {
                System.out.println("\nAtendimento " + (i + 1));
                System.out.println("Placa: " + placasAtendimento[i]);
                System.out.println("Data de Entrada: " + datas[i]);
                System.out.println("Problema Relatado: " + problemas[i]);
                System.out.println("Status: " + status[i]);
            }
        }
    }

    public static void menuAtendimentos(Scanner sc) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GERENCIAR ATENDIMENTOS ===");
            System.out.println("1 - Registrar Atendimento");
            System.out.println("2 - Consultar Atendimentos");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = lerInt(sc);
            if (opcao == 1) {
                registrarAtendimento(sc);
            } else if (opcao == 2) {
                consultarAtendimentos();
            } else if (opcao == 0) {
                System.out.println("\nVoltando ao Menu...");
            } else {
                System.out.println("Opcao Inválida!");
            }
        }
    }

    // ==================== SERVICOS ====================
    public static void menuServicos(Scanner tec) {
        int opcao;
        do {
            System.out.println("\n=== SERVIÇOS DALL CAR ===");
            System.out.println("1 - Cadastrar Serviços");
            System.out.println("2 - Consultar Atendimento");
            System.out.println("0 - Voltar");
            System.out.print("Opcao: ");
            opcao = lerInt(tec);

            switch (opcao) {
                case 1:
                    if (quantidadeServicos < MAX_SERVICOS) {
                        int posicao = quantidadeServicos;
                        System.out.print("Número do Atendimento: ");
                        int numero = lerInt(tec);
                        if (numero < 1 || numero > totalAtendimentos) {
                            System.out.println("Atendimento Não Existe. Registre o Atendimento Primeiro!");
                            break;
                        }
                        numeroAtendimento[posicao] = numero;
                        System.out.print("Descrição do Serviço: ");
                        String descricao = tec.nextLine();
                        if (descricao.isBlank()) {
                            System.out.println("Descrição Obrigatória. Cadastro Cancelado.");
                            break;
                        }
                        descricaoServicos[posicao] = descricao;
                        System.out.print("Valor da Mão de Obra: R$ ");
                        double valorMaoObra = lerDouble(tec);
                        if (valorMaoObra < 0 || !Double.isFinite(valorMaoObra)) {
                            System.out.println("Valor Inválido. Cadastro Cancelado.");
                            break;
                        }
                        maoObra[posicao] = valorMaoObra;
                        System.out.print("Quantidade de Peças (0 a 10): ");
                        int qtd = lerInt(tec);
                        if (qtd < 0 || qtd > MAX_PECAS) {
                            System.out.println("Quantidade Inválida. Cadastro Cancelado.");
                            break;
                        }
                        quantidadePecas[posicao] = qtd;
                        double somaPecas = 0;
                        boolean cadastroValido = true;
                        for (int p = 0; p < qtd; p++) {
                            System.out.println("\nPeça " + (p + 1));
                            System.out.print("Descrição: ");
                            descricaoPeca[posicao][p] = tec.nextLine();
                            System.out.print("Valor: R$ ");
                            valorPeca[posicao][p] = lerDouble(tec);
                            if (descricaoPeca[posicao][p].isBlank() ||
                                valorPeca[posicao][p] < 0 || !Double.isFinite(valorPeca[posicao][p])) {
                                System.out.println("Dados da Peça Inválidos. Cadastro Cancelado.");
                                cadastroValido = false;
                                break;
                            }
                            System.out.print("A peca esta Disponível? (S/N): ");
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
                        System.out.println("\nServiço Cadastrado!");
                        System.out.printf("Total do Serviço: R$ %.2f%n", totalServico[posicao]);
                    } else {
                        System.out.println("Limite de Serviços Atingido!");
                    }
                    break;

                case 2:
                    System.out.print("Número do Atendimento para Consultar: ");
                    int atendimentoBusca = lerInt(tec);
                    boolean encontrou = false;
                    double totalAtendimento = 0;
                    for (int i = 0; i < quantidadeServicos; i++) {
                        if (numeroAtendimento[i] == atendimentoBusca) {
                            encontrou = true;
                            System.out.println("\nServiço: " + descricaoServicos[i]);
                            System.out.printf("Mão de Obra: R$ %.2f%n", maoObra[i]);
                            for (int p = 0; p < quantidadePecas[i]; p++) {
                                System.out.println("Peça: " + descricaoPeca[i][p]);
                                System.out.printf("Valor: R$ %.2f%n", valorPeca[i][p]);
                                System.out.println("Situação: " + statusPeca[i][p]);
                            }
                            System.out.printf("Total do Serviço: R$ %.2f%n", totalServico[i]);
                            totalAtendimento += totalServico[i];
                        }
                    }
                    if (encontrou) {
                        System.out.printf("\nTotal do Atendimento: R$ %.2f%n", totalAtendimento);
                    } else {
                        System.out.println("\nNenhum Serviço Encontrado para esse Atendimento.");
                    }
                    break;

                case 0:
                    System.out.println("\nVoltando ao menu...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // ==================== VEICULOS ====================
    public static void menuVeiculos(Scanner enter) {
        int opcao = -1;
        while (opcao != 0) {
        System.out.println("\n=== VEÍCULOS - OFICINA ===");
            System.out.println("1 - Consultar Veículos");
            System.out.println("2 - Cadastrar Veículo");
            System.out.println("0 - Voltar");
            System.out.print("Comando: ");
            opcao = lerInt(enter);

            if (opcao == 1) {
                if (totalVeiculos == 0) {
                    System.out.println("Nenhum Veículo Cadastrado!");
                } else {
                    for (int i = 0; i < totalVeiculos; i++) {
                        System.out.println("\nVeículo " + (i + 1));
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
                    System.out.println("Limite de Veículos Atingido!");
                    continue;
                }
                int i = totalVeiculos;
                System.out.print("Cadastre a Placa do Veículo: ");
                String placa = enter.nextLine();
                System.out.print("Cadastre o Modelo do Veículo: ");
                String modelo = enter.nextLine();
                System.out.print("Cadastre a Marca do Veículo: ");
                String marca = enter.nextLine();
                System.out.print("Cadastre a Quilometragem do Veículo: ");
                int km = lerInt(enter);
                System.out.print("Cadastre o Ano do Veículo: ");
                int ano = lerInt(enter);
                while (ano < 1886 || ano > 9999) {
                    System.out.print("Ano Inválido! Insira novamente: ");
                    ano = lerInt(enter);
                }
                System.out.print("Cadastre o dono do Veículo: ");
                String dono = enter.nextLine();

                if (placa.isBlank() || modelo.isBlank() || marca.isBlank() || dono.isBlank() || km < 0) {
                    System.out.println("Dados Inválidos! Cadastro Cancelado.");
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
                    System.out.println("Cliente Não Cadastrado! Cadastre-o no menu Clientes primeiro.");
                    continue;
                }
                placasVeiculo[i] = placa;
                modelos[i] = modelo;
                marcas[i] = marca;
                quilometragens[i] = km;
                anos[i] = ano;
                donos[i] = dono;
                totalVeiculos++;
                System.out.println("Veículo Cadastrado!");
            } else if (opcao == 0) {
                System.out.println("\nVoltando ao Menu...");
            } else {
                System.out.println("Opção Inválida!");
            }
        }
    }

    // ==================== FUNCIONARIOS - OPCAO 5 DO ADMIN ====================
    public static void menuFuncionarios(Scanner sc) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GERENCIAR FUNCIONÁRIOS ===");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Listar Funcionários");
            System.out.println("3 - Buscar Funcionário");
            System.out.println("4 - Alterar Situação do Funcionário");
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
                        System.out.println("Preencha Todos os Campos!");
                    } else {
                        nomesFuncionarios[totalFuncionarios] = nome;
                        telefonesFuncionarios[totalFuncionarios] = telefone;
                        cargosFuncionarios[totalFuncionarios] = cargo;
                        situacoesFuncionarios[totalFuncionarios] = "Ativo";
                        totalFuncionarios++;
                        System.out.println("Funcionário Cadastrado!");
                    }
                } else {
                    System.out.println("Limite de Funcionários Atingido!");
                }
            } else if (opcao == 2) {
                if (totalFuncionarios == 0) {
                    System.out.println("Nenhum Funcionário Cadastrado!");
                } else {
                    for (int i = 0; i < totalFuncionarios; i++) {
                        System.out.println("\nFuncionário " + (i + 1));
                        System.out.println("Nome: " + nomesFuncionarios[i]);
                        System.out.println("Telefone: " + telefonesFuncionarios[i]);
                        System.out.println("Cargo: " + cargosFuncionarios[i]);
                        System.out.println("Situação: " + situacoesFuncionarios[i]);
                    }
                }
            } else if (opcao == 3) {
                System.out.print("Digite o Nome: ");
                String busca = sc.nextLine().trim();
                boolean encontrado = false;
                for (int i = 0; i < totalFuncionarios; i++) {
                    if (nomesFuncionarios[i].equalsIgnoreCase(busca)) {
                        System.out.println("\nFuncionário " + (i + 1));
                        System.out.println("Nome: " + nomesFuncionarios[i]);
                        System.out.println("Telefone: " + telefonesFuncionarios[i]);
                        System.out.println("Cargo: " + cargosFuncionarios[i]);
                        System.out.println("Situação: " + situacoesFuncionarios[i]);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Funcionário Não Encontrado!");
                }
            } else if (opcao == 4) {
                System.out.print("Número do Funcionário na Lista: ");
                int numero = lerInt(sc);
                if (numero < 1 || numero > totalFuncionarios) {
                    System.out.println("Funcionário não encontrado!");
                } else {
                    int i = numero - 1;
                    System.out.println("Funcionário: " + nomesFuncionarios[i]);
                    System.out.println("1 - Ativo");
                    System.out.println("2 - Inativo");
                    System.out.print("Escolha: ");
                    int situacao = lerInt(sc);
                    if (situacao == 1) {
                        situacoesFuncionarios[i] = "Ativo";
                        System.out.println("Situação Atualizada!");
                    } else if (situacao == 2) {
                        situacoesFuncionarios[i] = "Inativo";
                        System.out.println("Situação Atualizada!");
                    } else {
                        System.out.println("Opção Inválida!");
                    }
                }
            } else if (opcao == 0) {
                System.out.println("\nVoltando ao Menu do Administrador...");
            } else {
                System.out.println("Opção Inválida!");
            }
        }
    }

    // ==================== HISTORICO E RELATORIOS - OPCAO 8 ====================
    public static void menuRelatorios(Scanner sc) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== HISTÓRICO E RELATÓRIOS ===");
            System.out.println("1 - Resumo Geral da Oficina");
            System.out.println("2 - Histórico dos Atendimentos");
            System.out.println("3 - Relatório de Serviços e Valores");
            System.out.println("4 - Consultar Histórico por Placa");
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
                System.out.println("Clientes Cadastrados: " + totalClientes);
                System.out.println("Veículos Cadastrados: " + totalVeiculos);
                System.out.println("Funcionários Cadastrados: " + totalFuncionarios);
                System.out.println("Funcionários Ativos: " + ativos);
                System.out.println("Atendimentos Registrados: " + totalAtendimentos);
                System.out.println("Serviços Cadastrados: " + quantidadeServicos);
                System.out.printf("Soma dos Serviços Orçados: R$ %.2f%n", valorTotal);
                System.out.println("OBS: Valor orçado não significa pagamento recebido.");

            } else if (opcao == 2) {
                if (totalAtendimentos == 0) {
                    System.out.println("Nenhum Atendimento Registrado!");
                } else {
                    for (int i = 0; i < totalAtendimentos; i++) {
                        System.out.println("\nAtendimento " + (i + 1));
                        System.out.println("Placa: " + placasAtendimento[i]);
                        System.out.println("Data de Entrada: " + datas[i]);
                        System.out.println("Problema: " + problemas[i]);
                        System.out.println("Situação: " + status[i]);
                    }
                }

            } else if (opcao == 3) {
                if (quantidadeServicos == 0) {
                    System.out.println("Nenhum Servico Cadastrado!");
                } else {
                    double valorTotal = 0;
                    for (int i = 0; i < quantidadeServicos; i++) {
                        System.out.println("\nServico " + (i + 1));
                        System.out.println("Atendimento: " + numeroAtendimento[i]);
                        System.out.println("Descrição: " + descricaoServicos[i]);
                        System.out.printf("Mão de Obra: R$ %.2f%n", maoObra[i]);
                        System.out.println("Quantidade de Peças: " + quantidadePecas[i]);
                        System.out.printf("Total do Serviço: R$ %.2f%n", totalServico[i]);
                        valorTotal += totalServico[i];
                    }
                    System.out.printf("\nTOTAL ORCADO: R$ %.2f%n", valorTotal);
                    System.out.println("OBS: Não representa faturamento recebido.");
                }

            } else if (opcao == 4) {
                System.out.print("Digite a Placa do Veículo: ");
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
                        System.out.println("Situação: " + status[i]);
                        for (int j = 0; j < quantidadeServicos; j++) {
                            if (numeroAtendimento[j] == numero) {
                                System.out.println("Serviço: " + descricaoServicos[j]);
                                System.out.printf("Valor: R$ %.2f%n", totalServico[j]);
                                valorTotal += totalServico[j];
                            }
                        }
                    }
                }
                if (encontrado) {
                    System.out.printf("Total Orçado para a Placa: R$ %.2f%n", valorTotal);
                } else {
                    System.out.println("Nenhum Atendimento encontrado para esta Placa!");
                }

            } else if (opcao == 0) {
                System.out.println("\nVoltando ao Menu do Administrador...");
            } else {
                System.out.println("Opcao Inválida!");
            }
        }
    }

}
