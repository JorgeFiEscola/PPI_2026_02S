import java.util.Scanner;
public class Veículo {
    public static void main(String[] args) {
    Scanner enter = new Scanner(System.in);

    //Dados do Veículo
    String[] placa = new String[100];
    String[] marca = new String[100];
    String[] modelo = new String[100];
    int[] ano = new int[100];
    int[] km = new int[100];

    //Dados do Programa
boolean Vsair = false;
                    int RspPG1 = 0;
                    String entV;
    
                    
                    while(!Vsair){
                    System.out.print("\n=== GERENCIAR VEÍCULOS ===");
                    System.out.println(nomes[totalV] +" "+nomes[total]);
                    System.out.println("\n1 - Cadastrar um Veículo.");
                    System.out.println("2 - Consultar um Veículo.");
                    System.out.println("0 - Retornar");
                    System.out.print("Comando: ");
                    RspPG1 = usuario.nextInt();      
                    
                    if (RspPG1 > 2){
                        System.out.println("\nDigite um Número Válido!");
                        System.out.println("Comando: ");
                        RspPG1 = usuario.nextInt();
                    }
                        
                        if (RspPG1 == 2){

                         for (int i = 0; i < totalV; i++){
                            if (totalV == 0){
                                System.out.println("Sem Veículos Cadastrados!");
                            }else{
                            System.out.println("\n=== CONSULTAR VEÍCULO ===");
                            System.out.println(placa[i]);
                            System.out.println("Digite a Placa do Veículo Cadastrado: ");
                            usuario.nextLine();
                            entV = usuario.nextLine();

                            if (entV.equals(placa[i])){
                            System.out.println("Veículo (ID): " +i);
                            System.out.println("Placa: " +placa[i]);
                            System.out.println("Cliente: " +nomes[i]);
                            System.out.println("Modelo: " +modelo[i]);
                            System.out.println("Marca: " +marca[i]);
                            System.out.println("Ano: " +ano[i]);
                            System.out.println("Quilometragem" +km[i] );
                            System.out.println("Digite 'S' para Sair...");
                            entV = usuario.nextLine();
                            }else{
                                System.out.println("\nVeículo Não Tem Cadastro!");
                            }
                            }
                            }
                         }
                    
                        if (RspPG1 == 1){

                        if(totalV < 100){                        
                        System.out.println("\n Cadastre a Placa do Veículo:");
                        usuario.nextLine();
                        String placaPK = usuario.nextLine();
                        System.out.println("\n Cadastre o Modelo do Veículo:");
                        String modeloK = usuario.nextLine();
                        System.out.println("\n Cadastre a Marca do Veículo:");
                        String marcaK = usuario.nextLine();

                        System.out.println("\n Cadastre a Quilometragem do Veículo:");
                        int kmK = usuario.nextInt();
                        System.out.println("\n Cadastre o Ano do Veículo:");
                        int anoK = usuario.nextInt();

                        System.out.println("\n Cadastre o Dono do Veículo:");
                        usuario.nextLine();
                        String clienteV = usuario.nextLine();
                        

                        if (placaPK.isBlank() || modeloK.isBlank() || marcaK.isBlank() || kmK == 0 || anoK == 0){
                            System.out.println("\n Preencha Todos os Campos!");
                        
                        }else if(!clienteV.equals(nomes[totalV])){
                            System.out.println("\n Cliente Não Cadastrado!");
                          
                        }else{
                            placa[totalV] = placaPK;
                            modelo[totalV] = modeloK;
                            marca[totalV] = marcaK;
                            km[totalV] = kmK;
                            ano[totalV] = anoK;
                            totalV++;
                            System.out.println("\n Veículo Cadastrado!!");

                        }
                            }else{
                                System.out.println("\n Limite de Veículos atingidos!");
                            }
                    }

                    if (RspPG1 == 0){
                        System.out.println("");
                    }
                }      
}













}