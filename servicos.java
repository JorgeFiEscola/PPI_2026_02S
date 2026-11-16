package ServicoDallCar;

import java.util.Scanner;


public class servicos {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner tec = new Scanner (System.in);
		
		
		//LIMITES DO PROTÓTIPO
		final int max_servicos = 100;
		final int max_pecas = 10;
		
		//DADOS DOS SERVIÇOS
		
		String [] descricaoServicos = new String [max_servicos];
		Double [] maoObra = new Double [max_servicos];
		int [] numeroAtendimento = new int [max_servicos];
		Double [] totalServico = new Double [max_servicos];
		
		//DADOS DAS PEÇAS: cada linha pertence a um serviço
		
		String [][] descricaoPeca = new String [max_servicos] [max_pecas];
		Double [][] valorPeca = new Double [max_servicos] [max_pecas];
		String [][] statusPeca = new String [max_servicos] [ max_pecas];
		int [] quantidadePecas = new int [max_servicos];
		
		int quantidadeServicos=0;
		int opcao;
		
		do {
		
			System.out.println("\n=== SERVIÇOS DALL CAR ===");
			System.out.println("1 - Cadastrar serviços");
			System.out.println("2 - Consultar atendimento");
			System.out.println("0 - Sair ");
			System.out.println("Opção: ");
			
			opcao=tec.nextInt();
			tec.nextLine();
		

			switch (opcao) {
			case 1:
				if (quantidadeServicos<max_servicos) {
					
					int posicao = quantidadeServicos;
					
					System.out.println ("Nº do atendimento: ");
					numeroAtendimento[posicao] = tec.nextInt();
					tec.nextLine();
					
					System.out.println ("Descrição do serviço: ");
					descricaoServicos[posicao] = tec.nextLine();
					
					
					System.out.println ("Valor da mão de obra: R$");
					maoObra[posicao] = tec.nextDouble();
					
					System.out.println ("Quantidade de peças (0 à 10):  ");
					int qtd = tec.nextInt();
					tec.nextLine();
					
					if (qtd<0||qtd> max_pecas) {
						System.out.println("Quantidade inválida. Cadastro cancelado.");
						break;
					}
				
					
					quantidadePecas [posicao] = qtd;
					
					double somaPecas = 0;
					
					for (int p = 0; p<qtd; p++) {
						System.out.println("\nPeça " + (p+1));
						
						System.out.print("Descrição: ");
						descricaoPeca[posicao][p] = tec.nextLine();
						
						System.out.print("Valor: R$ ");
						valorPeca[posicao][p] = tec.nextDouble();
						tec.nextLine();
						
						System.out.print("A peça está disponível? (S/N): ");
						String resposta = tec.nextLine();
						
						if (resposta.equalsIgnoreCase("S")) {
							statusPeca[posicao][p] = "Disponível";
							
						} else {
							statusPeca[posicao][p]= "Aguardando";
							
						}
						
						somaPecas+= valorPeca[posicao][p];
					}
					
					totalServico[posicao] = maoObra[posicao] + somaPecas;
					
					quantidadeServicos++;
					
					System.out.println("\nServico cadastrado!");
					System.out.printf("Total do serviço: R$  %.2f%n",
							+ totalServico[posicao]);
					
				} else {
					System.out.println("Limite de serviços atingido");
					
				}break;
				
			case 2:
				System.out.print("Número do atendimento para consultar: ");
				
				int atendimentoBusca = tec.nextInt();
					
					boolean encontrou = false;
					double totalAtendimento=0;
					
					for (int i=0; i<quantidadeServicos; i++) {
						
						if (numeroAtendimento[i]==atendimentoBusca) {
							encontrou = true;
							
							System.out.println("\nServico: " + descricaoServicos[i]);
							
							System.out.printf("Mão de obra: R$ %.2f%n", + maoObra[i]);
							
						for (int p = 0; p<quantidadePecas[i]; p++) {	
							
							System.out.println("Peça:" + descricaoPeca[i][p]);
							
							System.out.printf("Valor: R$ %.2f%n", + valorPeca[i][p]);
							
							System.out.println ("Situaçao: " + statusPeca[i] [p]);
							
						}
						
						System.out.printf("Total do servico: R$ %.2f%n", + totalServico[i]);
						
						totalAtendimento+= totalServico[i];
						
						}
						
					}
						
						if (encontrou) {
							
							System.out.printf("\nTotal do atendimento: R$ %.2f%n", + totalAtendimento);
							
						} else {
							
							System.out.println("Nenhum serviço encontrado para esse atendimento.");
							
						} break;
						
						case 0: 
							System.out.println("Encerrando o sistema...");
							break;
							
							default:
								System.out.println("Opção inválida.");
								
			}			
								
			}  while (opcao!=0);
			
			tec.close();
							
		}
}			
						
				
			
		
