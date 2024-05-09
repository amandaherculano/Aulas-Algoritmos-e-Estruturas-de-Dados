import java.util.Scanner;
import java.util.Random;

public class PreencheSemRepetir{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int n = sc.nextInt();
        int[] v;

        while(n>0){
            v =  new int[n];
            v[0] = r.nextInt(n) + 1;
            int i = 1;
            while (i<v.length){ //preencher elementos 
                int a =  r.nextInt(n) + 1;
                boolean repete =  false; //ver se repete
                for (int j=i-1; j>=0 && !repete; j--){
                    if (v[j] == a){
                        repete = true;
                    }
                }
                if (!repete){
                    v[i++] = a;
                    System.out.print(v[i++]); //imprimir todas as vezes que gra numero
                }
            }

            for (i=0; i< v.length; i++){
                System.out.print(v[i] + " ");
            }
            
            System.out.println("Proximo: ");
            n = sc.nextInt();   //peso do NextInt é meior porque percebe que vai repetir
            
        }
        sc.close();

    }
}