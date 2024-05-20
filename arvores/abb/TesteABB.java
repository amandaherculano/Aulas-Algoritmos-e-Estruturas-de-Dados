import java.util.Random;
 
public class TesteABB {
    public static void main(String[] args) {
        Random random = new Random();
        int[] v = new int[12];
        ABB abb = new ABB();
        for (int i=0; i<12; i++) {
            v[i] = random.nextInt(20) + 1;
            System.out.print(v[i] + " ");
            abb.insere(v[i]);
        }
        System.out.println("\na arvore:\n" + abb.stringInOrder());
        System.out.println("\nnivel: " + abb.nivel());
        System.out.println("\ntotal de nos: " + abb.numeroNos());
        System.out.println("\nMaior valor: " + abb.maior());
        System.out.println("\nMaior por recursao: " + abb.chamaMaiorRec());
        System.out.println("\nTemos " + abb.folhas() + " folhas");
        // int x = random.nextInt(20);
        // if ( abb.existeValor(x)){
        //     System.out.println(x + " existe na arvore");

        // }else{
        //     System.out.println(x + " nao existe na arvore");
        // }

        // System.out.println("chamada do proximo: " + abb.proximo(20));
        int result = abb.proximo(20);
        if (result == -1){
            System.out.println("oh oh, tente mais tarde");
        }
        else{
            System.out.println("O proximo valor eh: " + result);
        }
    }
}