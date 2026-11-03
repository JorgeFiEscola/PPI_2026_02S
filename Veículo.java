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
    int RspPG1 = 0;
    int total = 0;
    
    //Pré-Associações FK --------------!!
    String Cliente;
    Cliente = "Harry";

    //Seleção se deseja Consultar ou Cadastrar
    while (RspPG1 >= 1 || RspPG1 <= 2){
    System.out.print("\n=== OFICINA ===");
    System.out.println("Digite '1' para Consultar um Veículo.");
    System.out.println("Digite '2' para Cadastrar um Veículo.");
    System.out.print("Comando: ");
    RspPG1 = enter.nextInt();

    if (RspPG1 == 1){
        System.out.println("\n=== OFICINA ===");
         System.out.print("Veículo (ID?): ");
         System.out.print("Placa: " +placa);
         System.out.print("Cliente: " +Cliente);
         System.out.print("Modelo: " +modelo);
         System.out.print("Marca: " +marca);
         System.out.print("Ano: " +ano);
         System.out.print("Quilometragem" +km );
    
    } else if (RspPG1 == 2){
        for (int i = 0; i < total; i++){
        System.out.println("\n Cadastre a Placa do Veículo:");
        enter.nextLine();
        placa[i] = enter.nextLine();
        System.out.println("\n Cadastre o Modelo do Veículo:");
        modelo[i] = enter.nextLine();
        System.out.println("\n Cadastre a Marca do Veículo:");
        marca[i] = enter.nextLine();

        System.out.println("\n Cadastre a Quilometragem do Veículo:");
        km[i] = enter.nextInt();
        System.out.println("\n Cadastre o Ano do Veículo:");
        ano[i] = enter.nextInt();

        System.out.println("\n Cadastre o Dono do Veículo:");
        Cliente = enter.nextLine();
        //Criar um sistema que conecte essa aba ao Cliente.-------------------------!!

        //Código relacionado a Data/Ano do Carro.
             while (ano[i] > 9999){
            System.out.println("\n Ano Inválido! Insira novamente: ");
            ano[i] = enter.nextInt();
            }

        }
    }

    return 

    }        
}













}