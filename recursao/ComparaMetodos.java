import java.util.Scanner;
import java.util.Date;


public class ComparaMetodos {
    //metodo principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MeuVetor v;
        long ini, fim; //cronometro
        System.out.println("escolha o tamanho do vetor, 0 encerra: ");
        int t = scanner.nextInt();
        while(t>0){
            v = new MeuVetor(t);

            //se o vetor tiver 10 posicoes preenche ate 99
            //valores aleatórios
            //v.preencheVetor(t*10);
            //System.out.println("1o vetor gerado\n" + v);
            //ini = new Date().getTime();
            //v.insertionsort();
            //fim = new Date().getTime();
           // System.out.println("Ordenação pelo insertion:\n" + v);
            //System.out.println("Insertion demorou: " + (fim-ini) + " ms\n");
           //v.resetVetor(); //limpa vetor 
            //obs: deixar sempre private, principio do menor privilegio, se precisar abre

            v.preencheVetor(t*10);

            // ------------ quick primeira vez
            // System.out.println("2o vetor gerado\n" + v);
            ini = new Date().getTime(); //instanciar pq objeto é instanciado pegando o tempo da maquina
            v.quick(0, t-1); // 0 primeira prosicao e t-1 ultima
            fim = new Date().getTime();
            // System.out.println("Ordenação pelo quick:\n" + v);
            System.out.println("Na primeira vez, Quick demorou: " + (fim-ini) + " ms\n");

            // --------- quick segunda vez 
            ini = new Date().getTime(); //instanciar pq objeto é instanciado pegando o tempo da maquina
            v.quick(0, t-1); // 0 primeira prosicao e t-1 ultima
            fim = new Date().getTime();
            // System.out.println("Ordenação pelo quick:\n" + v);
            System.out.println("Na segundahava vez, Quick demorou: " + (fim-ini) + " ms\n");


            System.out.println("\nescolha o tamanho do vetor, 0 encerra: ");
            t = scanner.nextInt();
        }
        scanner.close();
    }
}
