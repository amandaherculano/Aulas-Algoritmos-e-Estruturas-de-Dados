public class ABB {
    private No raiz;
    boolean estaVazia(){
        return raiz ==  null;  //retorna teste da raiz 
    }

    //passa valores e spo depois de ver que nó nao existe cria o nó
    //pois se ja existir não ter que jogar fora

    public void insere( int i){
        if (estaVazia()){
            raiz = new No(i);
        }
        else{
            insereRec(i, raiz);
        }
    }
    public void insereRec(int i, No atual){
        if ( i == atual.getInfo()){
            atual.somaQuantidade();
        }
        else if(i < atual.getInfo()){
            if( atual.getEsquerda() == null){
                atual.setEsquerda(new No(i));   //cria no neste instante
            }
            else{
                insereRec(i, atual.getEsquerda());
            }
        }
        else{
            if (atual.getDireita() == null){
                atual.setDireita(new No(i));
            }
            else{
                insereRec(i, atual.getDireita());
            }
        }
    }

    public String stringEmOrdem(){
        if (estaVazia()){
            return "Árvore vazia";
        }
        else{
            return stringEmOrdemRec(raiz);
        }
    }
    public String stringEmOrdemRec(No atual){
        if (atual == null){
            return "";
        }
        else{ 
            String s = "";
            s += stringEmOrdemRec(atual.getEsquerda());
            
            for ( int i = 1; i<= atual.getQuantidade(); i++){
                s += atual.getInfo() + " ";
            }
            s +=  stringEmOrdemRec(atual.getDireita());
            return s;
        }
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
        if (atual == null) return 0; //nao tem filho nenhum retorno 0
        return numeroNosRec(atual.getEsquerda()) + 1 + numeroNosRec(atual.getDireita()); //investiga direita, sob=ma 1 da raiza, investiga esquerda, se for null soma 0  e sobe a soma 
        
    }
}
