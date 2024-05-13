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
}
