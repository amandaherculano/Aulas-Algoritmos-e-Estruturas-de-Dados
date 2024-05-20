import java.util.ArrayList;

public class ABB {
    private No raiz;
    public boolean estaVazia(){
        //primeira pergunta: esta vazia? teste se raiza é nula
        return raiz == null;
    }
    //colocar elementos na arvore: recursiva e regra direita e esquerda 
    //insersao é publica e internamente faz chamada do recursivo 
    
    public void insere (int info){
        No novo = new No(info);
        //primeira pergunta: esta vazia? teste se raiza é nula
        if (estaVazia()){
            raiz = novo ;
        }
        else{
            // se não esta vazia: verificar se é maior ou menor -> perguntar 

            insereRec(novo, raiz);
        }
    }

    void insereRec( No novo, No atual){    //atual é uma referencia de onde esta agora
        if ( novo.getInfo() <= atual.getInfo()){
            //verificar se ramo da esquerda esta vazio 
            if (atual.getEsquerda() == null){
                atual.setEsquerda(novo);
            }
            else{
                insereRec(novo, atual.getEsquerda());
            }
        }
        else{
            //ver se galho da direita ta vazio 
            if (atual.getDireita() == null){
                atual.setDireita(novo);
            }
            else{
                insereRec(novo, atual.getDireita()); //vai analisando as outras posições 
            }
        }
    }
    public String stringInOrder(){
        if (estaVazia()) return "Árvore Vazia";
        return stringRecInOrder(raiz);
            
    }

    // nao usa toString porque depende da maneira que ira percorrer 
    String stringRecInOrder( No atual){
        if (atual != null) //verificacao de seguranca 
            return stringRecInOrder(atual.getEsquerda()) +
            " " + atual.getInfo() + " " + 
            stringRecInOrder(atual.getDireita());
        return "";
    }

    public int nivel (){
        if (estaVazia()) return 0;
        return nivelRec(raiz);
    }
    int nivelRec( No atual){
        if (atual.getEsquerda() == null && atual.getDireita() == null) return 0; //nao tem filho nenhum 

        int nivelEsq=0, nivelDir=0; //para inicializar
        if (atual.getEsquerda() != null){
            nivelEsq =  nivelRec(atual.getEsquerda());
        }
        if (atual.getDireita() != null){
            nivelDir = nivelRec(atual.getDireita());
        }
       return nivelEsq > nivelDir ? nivelEsq + 1 : nivelDir + 1;

    }

    public int numeroNos (){
        if (estaVazia()) return 1;
        return numeroNosRec(raiz);
    }

    int numeroNosRec(No atual){
        if (atual == null) return 0;
        return numeroNosRec(atual.getEsquerda()) + 1 + numeroNosRec(atual.getDireita()); //total direita 
        
    }

    public int maior () {
        if (estaVazia()) return -1;
        No aux = raiz;
        while (aux.getDireita() != null) {
            aux = aux.getDireita();
        }
        return aux.getInfo();
    }
 
    public int chamaMaiorRec () {
        if (estaVazia()) return -1;
        return maiorRec(raiz);
    }
    int maiorRec (No atual) {
        if (atual.getDireita() == null) 
            return atual.getInfo();
        return maiorRec(atual.getDireita());
    }
    public int folhas () {
        if (estaVazia()) return 0;
        return folhasRec(raiz);
    }
 
    int folhasRec (No atual) {
        if (atual == null) return 0;
        if (atual.getEsquerda()==null && atual.getDireita()==null) 
            return 1;
        return folhasRec(atual.getEsquerda()) + folhasRec(atual.getDireita());
    }
 

    //a busca pelo proximo elemento  pode ser muito complicada, pois as ramificaçõespodem acontecer de varias maneiras; uma possibilidade  é percorrer a arvote "emOrdem" e buscas o elemento na lista
    
    // o curso é O(n) 

    // public int proximo (int i) { //imediatamente
    //     if (estaVazia()) return -1;
    //     //proximo elemento quando nao ha repeticao: 1. filho da direita se nao houver alguem a esquerda do seu filho ou 2. de cima 
    //     if (referencia(i) == null) return -1;
    // }
    
    // public No referencia (int i) {
    //     if (raiz.getInfo() == i) 
    //         return raiz;
    //     if (i > raiz.getInfo()) 
    //         return referenciaRec(i, raiz.getDireita());
    //     return refereciaRec(i, raiz.getEsquerda());
    // }


    public int proximo (int x){
        if (estaVazia()) return -1; //decisao de projeto 
        ArrayList<Integer> lista = new ArrayList<>();  //auto dimensiona 
        constroiLista (lista, raiz); //recursivo
        System.out.println(lista);
        if ( !lista.contains(x)) return -1; //se nao tem o valor na lista
        int posicao = lista.indexOf(x); //posicao do valor
        // if ( posicao == lista.size()-1) return -1; //se for o ultimo
        // return lista.get(posicao+1);

        return posicao == lista.size()-1 ? -1 : lista.get(posicao+1); 
    }

    void constroiLista (ArrayList lista, No atual){ //usar ArrayList garantir que tem uma classe que ja faz isso, int e promove para Integer -> API do Java ja se responsabiliza
        if (atual != null){
            constroiLista(lista, atual.getEsquerda());
            lista.add(atual.getInfo()); //sempre no final
            constroiLista(lista, atual.getDireita());
        }
    }

    public boolean buscaBinaria ( int x){
        if (estaVazia()) return false;
        return buscaBinariaRec(x, raiz);
    }

    boolean buscaBinariaRec (int x, No atual){
        if (atual == null) return false; //se nao achar
        if (atual.getInfo() == x) return true; //achou o valor que esta procurando
        if (x < atual.getInfo()) 
            return buscaBinariaRec(x, atual.getEsquerda()); //se for menor vai para esquerda
        return buscaBinariaRec(x , atual.getDireita()); //se for maior vai para direita
    }

}
