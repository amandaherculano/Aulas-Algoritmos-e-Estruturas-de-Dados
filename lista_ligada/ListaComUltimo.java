public class ListaComUltimo extends Lista {
    private No ultimo;
    // construtor padrão
    public No getUltimo(){
        return ultimo;
    }

    @Override
    public void insereFim(int i){
        No novo = new No(i);
        
        if (estaVazia()){
            setPrimeiro(novo);
        }else{
            ultimo.setProximo(novo);
        }
        // independe do if else
        ultimo = novo;

    }
}
