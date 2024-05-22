import java.util.Scanner;

public class Bee1062{
    public static void main(String[] args){
        //ler quantidade de vagoes -> inicial
        Scanner sc = new Scanner(System.in);  //5
        while (true) {
            int n_vagoes = sc.nextInt();
            if (n_vagoes == 0) {
                return;
            }
            //ler sequencia de vagoes que foi inserido
            sc.nextLine(); 
            String sequencia = sc.nextLine();

            //separar sequencia em um vetor de inteiros  
            String[] sequenciaStrings = sequencia.split(" "); // 5 4 3 2 1 
            int[] sequenciaInts = new int[sequenciaStrings.length];
            for (int i = 0; i < sequenciaStrings.length; i++) {
                sequenciaInts[i] = Integer.parseInt(sequenciaStrings[i]);
            }

            Pilha estacao = new Pilha();
            boolean isPossible = true;
            //comparar ordenada/contador com a sequencia de vagoes inserido 
            for ( int i = 1, j = 0; i <= n_vagoes && isPossible; i ++){
                if ( i == sequenciaInts[j] ){
                    i ++;
                    j ++; 
                }else if ( i < sequenciaInts[j]){
                    estacao.push(i);
                    j++;
                } else if (!estacao.estaVazia() && sequenciaInts[j] == estacao.pop()){
                    i ++;
                    j++;
                }
                else{
                    System.out.println("No");
                    isPossible = false;
                }
            }
            if (isPossible) {
                System.out.println("Yes");
            }
        } 
    }
}
class No{
    private int info;
    private No proximo;
    public No (int info) {
        setInfo(info);
        proximo = null; //por clareza
    }
    public int getInfo() {
        return info;
    }
    public No getProximo() {
        return proximo;
    }
    public void setInfo (int info) {
        this.info = info;
    }
    public void setProximo (No proximo) {
        this.proximo = proximo;
    }
}

class Pilha{
    private No topo;
    //construtor padrão 
    public boolean estaVazia() {
        return topo == null;
    }
    public void push(int info) {
        No novo = new No(info);
        if (!estaVazia()) {
            novo.setProximo(topo);
        }
        topo = novo;
    }
    public int pop () {
        if (!estaVazia()) {
            int temp = topo.getInfo();
            topo = topo.getProximo();
            return temp;
        }
        return -1; // Retorne um valor padrão ou lance uma exceção
    }
}