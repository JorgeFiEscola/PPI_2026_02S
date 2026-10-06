
import java.util.Scanner;

public class m6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		int[][] mA = new int[2][2];
		int[][] mB = new int[2][2];
		int[][] mC = new int[2][2];
				
		// Preenche a matriz A
		System.out.println("Informe os dados da matriz A: ");
		for(int i=0; i < mA.length; i++) { 
			for(int j=0; j < mA.length; j++) { 
				System.out.print("Digite um valor ("+i+j+"):");
				mA[i][j] = sc.nextInt();				
			}
		}
		
		// Preenche a matriz B
		System.out.println("Informe os dados da matriz B: ");
		for(int i=0; i < mB.length; i++) { 
			for(int j=0; j < mB.length; j++) { 
				System.out.print("Digite um valor ("+i+j+"):");
				mB[i][j] = sc.nextInt();				
			}
		}
		
		// Compara as matrizes A e B, preenchendo a C
		for(int i=0; i < mA.length; i++) { 
			for(int j=0; j < mA.length; j++) { 
				
				// verifica qual é o maior valor
				if(mA[i][j] >= mB[i][j]) {
					mC[i][j] = mA[i][j]; 
				} else {
					mC[i][j] = mB[i][j];
				}
				
			}
		}
		
		// Exibe na tela a matriz resultante
		System.out.println("Matriz resultante: ");
		for(int i=0; i < mC.length; i++) { 
			for(int j=0; j < mC.length; j++) { 
				System.out.print(mC[i][j]+" ");	
			}
			System.out.println();
		}
		
		
	}

}
