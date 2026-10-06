
import java.util.Scanner;
import java.util.Random;
public class m5 {

	public static void main(String[] args) {
	Scanner enter = new Scanner(System.in);
	
	int [][] matriz = new int [5][5];	
	int valorX = 0;

	for (int lin = 0; lin < matriz.length; lin++) {
		for (int col = 0; col < matriz[lin].length; col++) {
			System.out.print("Informe um Número: ");
			matriz[lin][col] = enter.nextInt();
		}
	}
			
	System.out.print("Digite o Valor X: ");
	valorX = enter.nextInt();
	
	for (int lin = 0; lin < matriz.length; lin++) {
		for (int col = 0; col < matriz[lin].length; col++) {
			if (valorX == matriz[lin][col]) {
				System.out.println("\nValor X está em " +lin+ " e "+col+"!!");
			}
		}
	}
			
	for (int[] linha: matriz) {
		for(int valor: linha) {
			System.out.print(valor+" ");
		}
		System.out.println();
		
	}
	
	}
	
}

