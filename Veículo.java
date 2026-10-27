import java.util.Scanner;
public class Veículo {
    public static void main(String[] args) {
    Scanner enter = new Scanner(System.in);

    //Dados do Veículo
    String placa, marca, modelo;
    int ano, km;

    //Dados do Programa
    int RspPG1 = 0;

    //Pré-Associações
    placa = "XBQ1";
    marca = "Volkswagen";
    modelo = "Onyx";
    ano = 1990;
    km = 99999;

    //Pré-Associações FK
    String Cliente;
    Cliente = "Harry";

    //Seleção se deseja Consultar ou Cadastrar
    while (RspPG1 >= 1 || RspPG1 <= 2){
    System.out.print("\nDigite '1' para Consultar um Veículo. \nDigite '2' para Cadastrar um Veículo. \nComando: ");
    RspPG1 = enter.nextInt();

    if (RspPG1 == 1){
        System.out.println("\n(Fluxo de Navegação)\n\n Veículo (ID?)\n Placa: " +placa+ "\n Cliente: " +Cliente+ "\n Modelo: " +modelo+ "\n Marca: " +marca+ "\n Ano: " +ano+ "\n Quilometragem" +km );
    
    } else if (RspPG1 == 2){
        System.out.println("\n Cadastre a Placa do Veículo:");
        enter.nextLine();
        placa = enter.nextLine();
        System.out.println("\n Cadastre o Modelo do Veículo:");
        modelo = enter.nextLine();
        System.out.println("\n Cadastre a Marca do Veículo:");
        marca = enter.nextLine();

        System.out.println("\n Cadastre a Quilometragem do Veículo:");
        km = enter.nextInt();
        System.out.println("\n Cadastre o Ano do Veículo:");
        ano = enter.nextInt();

        System.out.println("\n Cadastre o Dono do Veículo:");
        Cliente = enter.nextLine();
        //Criar um sistema que conecte essa aba ao Cliente.

        //Código relacionado a Data/Ano do Carro.
        while (ano > 9999){
            System.out.println("\n Ano Inválido! Insira novamente: ");
            ano = enter.nextInt();
        }

    }
    }   
        

}













}