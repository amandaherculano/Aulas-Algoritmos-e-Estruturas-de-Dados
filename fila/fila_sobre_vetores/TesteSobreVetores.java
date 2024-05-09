import java.util.Random;

public class TesteSobreVetores{
    public static void main(String[] args) {
        Fila f = new Fila();
        Random r = new Random();
        do {
            if (r.nextBoolean()){
                if (!f.estaCheia()) f.enfileira(r.nextInt(10));
            }
            else{
                if (!f.estaVazia()) System.out.println("\n" + f.desenfilera() + " saiu da fila");
            }
            System.out.println(f);
            f.mostraVetor();
        }while (!f.estaVazia());
    }
}
