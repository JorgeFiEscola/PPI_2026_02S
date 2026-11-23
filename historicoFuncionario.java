public static void historicoFuncionario(String nomeFuncionario) {

    boolean encontrado = false;

    System.out.println("\n=== MEU HISTORICO ===");
    System.out.println("Funcionario: " + nomeFuncionario);

    for (int i = 0; i < quantidadeServicos; i++) {

        if (funcionariosServicos[i].equalsIgnoreCase(nomeFuncionario)) {

            int atendimento = numeroAtendimento[i];
            int posicao = atendimento - 1;

            encontrado = true;

            System.out.println("\n----------------------------");
            System.out.println("Servico: " + descricaoServicos[i]);
            System.out.println("Atendimento: " + atendimento);
            System.out.println("Data: " + datas[posicao]);
            System.out.println("Placa: " + placasAtendimento[posicao]);
            System.out.println("Problema: " + problemas[posicao]);
            System.out.println("Status: " + status[posicao]);
            System.out.printf("Valor do servico: R$ %.2f%n", totalServico[i]);

            for (int v = 0; v < totalVeiculos; v++) {
                if (placasVeiculo[v].equalsIgnoreCase(placasAtendimento[posicao])) {
                    System.out.println("Veiculo: " + marcas[v] + " " + modelos[v]);
                    System.out.println("Ano: " + anos[v]);
                    break;
                }
            }
        }
    }

    if (!encontrado) {
        System.out.println("\nNenhum servico encontrado para este funcionario.");
    }

    System.out.println("----------------------------");
}
