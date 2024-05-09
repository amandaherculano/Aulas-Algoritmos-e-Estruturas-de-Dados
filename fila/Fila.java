// E: fila do que a agnt quiser, do que parametrizou
public class Fila<E>{

    //private pq não interessa ao usuário, apenas enfileirar ou não -> sem get e set
    private No<E> primeiro;
    private No<E> ultimo;
    //construtor padrão
   
    public boolean estaVazia(){
        //se primeiro é null fil esta vazia
        return primeiro == null;
    }

    public void enfilera (E elemento) {
        No<E> novo = new No<E>(elemento);
        if (estaVazia()) {
            //se estiver vazia primeiro é o novo
            primeiro = novo;
        }
        else {
            ultimo.setProximo(novo);
        }

        //ultimo é sempre o novo
        ultimo = novo;
    }
    // não existe remeove fim, apenas sai o inicio e insere o fim 

    public E desenfileira(){
        //tester se fila esta vazia dentro 
        if (estaVazia()) return null; //não existe é null 

        //atender o primeiro cliente, a informação dele, alem de ser o primeiro 
        E temp = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if(primeiro == null){
            ultimo = null;
        }

        return temp;
    }

    @Override 
    public String toString(){
        if (estaVazia()) return "fila vazia";
        No<E> aux = primeiro;
        String s = "";
        while (aux != ultimo){
            // o que ja tem e com - separando, ultimo nao tem
            s += aux + " -> ";
            aux = aux.getProximo(); //andar
        } 
        s += aux; //certeza que quando sai é o ultimo 
        return s;
    }
}


//No -> apenas uma é publica

//se quisar mudar tipo de elemneto da fila, muda no 

// elemento E qualquer, elemento generico (pode ser o que quiser, tipo generico)
class No <E> {
    private E info;
    private No <E> proximo;
    public No (E info) {
        setInfo(info);
        proximo = null; //por clareza
    }
    public E getInfo() {
        return info;
    }
    public No<E> getProximo() {
        return proximo;
    }
    public void setInfo (E info) {
        this.info = info;
    }
    public void setProximo (No <E> proximo) {
        this.proximo = proximo;
    }
    @Override
    public String toString() {
        //"" obriga o toSring do info ( mesma coisa que convert to String)  
        return "" + info;
    }
}
