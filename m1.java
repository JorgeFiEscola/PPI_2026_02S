import java.util.Scanner;
public class m1 {
        public static void main(String[] args) {
    
            Scanner sc = new Scanner(System.in);
    
            int[][] matriz = new int[4][4];
            int contador = 0;
    
            // Leitura da matriz
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print("Digite o valor [" + i + "][" + j + "]: ");
                    matriz[i][j] = sc.nextInt();
    
                    // Verifica se o valor é maior que 10
                    if (matriz[i][j] > 10) {
                        contador++;
                    }
                }
            }
    
            // Mostra o resultado
            System.out.println("A matriz possui " + contador + " valores maiores que 10.");
    
            sc.close();
        }
    }
    
    

