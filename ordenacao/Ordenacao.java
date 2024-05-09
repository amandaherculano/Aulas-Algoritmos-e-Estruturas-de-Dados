

import Aula02.MeuVetor2;
import java.util.Scanner;
import java.util.Date;

public class Ordenacao {
    public static void main(String[] args){
        MeuVetor2 v1;
        Scanner  sc = new Scanner(System.in);
        int tamanho;
        System.out.print("Digite um tamanho para o vetor de teste, 0 encerra: ");
        tamanho= sc.nextInt();
        // não colocar tamnaho=1 variaveis X não sao boas 
        // inicializar condição com valor valido, se for o caso pede para o usuario
        
        while (tamanho > 0 ){
            v1= new MeuVetor2(tamanho);
            v1.preencheVetor();
            System.out.println("primeiro vetor gerado:\n" + v1);
            long inicio = new Date().getTime();
            int comparacoes = v1.bubbleSort();
            long fim = new Date().getTime();
            System.out.println("vetor ordenado pelo Bubble:\n" + v1);
            // System.out.println("tamanho: " +  tamanho + " comparacoes: " + comparacoes);
            System.out.println("vetor gerado:\n" + v1);
            System.out.print("Tamanho: " + tamanho + "Bubble demorou: " + (fim-inicio) + " ms" );
            
            v1.preencheVetor();
            System.out.println("segundo vetor gerado:\n" + v1);
            inicio= new Date().getTime();
            v1.insertionsort();
            fim = new Date().getTime();
            System.out.println("vetor ordenado pelo Bubble:\n" + v1);
            System.out.print("Tamanho: " + tamanho + "  Insertion demorou: " + (fim-inicio) + " ms" );
            
            v1.preencheVetor();
            System.out.println("terceiro vetor gerado:\n" + v1);
            inicio= new Date().getTime();
            v1.selectionsort();
            fim = new Date().getTime();
            System.out.println("vetor ordenado pelo Bubble:\n" + v1);
            System.out.print("Tamanho: " + tamanho + "  Selection demorou: " + (fim-inicio) + " ms" );

        }
        sc.close();
    }
}
