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
}
