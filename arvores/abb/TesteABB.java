import java.util.Random;

public class TesteABB {
    public static void main(String[] args) {
        Random random =  new Random();
        int[] v = new int[200];
        ABB abb = new ABB();

        for(int i = 0; i<200; i++){
            v[i] = random.nextInt(20) + 1;
            System.out.print(v[i] + " ");
            abb.insere(v[i]);
        }
        System.out.println("\nA árvore:\n" + abb.stringInOrder());  
        System.out.println("\nnivel: "+ abb.nivel());
        System.out.println("\ntotal de nos: "  +abb.numeroNos());
    }
}
