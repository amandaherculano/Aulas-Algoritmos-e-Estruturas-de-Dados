public class Lista {
    // head cabeca da lista
    private No primeiro;

    // lista nasce vazia 
    // construtor padrao, zera tudo 

    public boolean estaVazia(){
        return primeiro == null;
        // tem if embutido 
    }

    // novo no apont para o que esta em primeiro e depois troca o primeiro
    // NOVO APONTA PARA O P PRIMEIRO 
    public void insere(Pessoa info){
        No novo = new No(info);
        if (!estaVazia()){
            novo.setProximo(primeiro);
        }
        primeiro = novo;
    }

    @Override
    public String toString(){
        String s = "lista: ";
        if (estaVazia()){
            s += "vazia";
        }else{
            //percorrer a lista ate o final, acesso sequencial do comeco ate achar nulo
            No aux = primeiro; //copia do 1endereco, se posicionou e pegou 
            while (aux != null){
                s += aux;
                aux = aux.getProximo();//consulta o proximo 
            }
        } 
        return s + "//\n";
    }

    public void insereFim(Pessoa info){
        No novo = new No(info);
        if (estaVazia()){
            primeiro = novo;
        }else{
            No aux = primeiro;
            while (aux.getProximo() != null){ //percorre até o ultimo
                aux = aux.getProximo(); 
            }
            aux.setProximo(novo);

        }
    }
    public Pessoa remove(){
        Pessoa temp = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        return temp;
    }
}


