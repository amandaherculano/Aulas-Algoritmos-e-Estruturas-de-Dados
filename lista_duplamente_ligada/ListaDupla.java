public class ListaDupla {
    NoDuplo primeiro;
    NoDuplo ultimo;
    //construtor padrão
    public boolean estaVazia () {
        return primeiro == null;
    }
    public void insereInicio (int info) {
        NoDuplo novo = new NoDuplo(info);
        if (estaVazia()) {
            ultimo = novo;
        }
        else {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }
    public void insereFim(int info) {
        NoDuplo novo = new NoDuplo(info);
        if (estaVazia()) {
            primeiro = novo;
        }
        else{
            novo.setAnterior(ultimo);
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }
    public int removeInicio () {
        int temp = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null) { // tinha um só
            ultimo = null;
        }
        else {
            primeiro.setAnterior(null);
        }
        return temp;
    }
    public int removeFim() {
        int temp = ultimo.getInfo();
        ultimo = ultimo.getAnterior();
        if (ultimo == null) {
            primeiro = null;
        }
        else{
            ultimo.setProximo(null);
        }
        return temp;
    }
    
    public void insereElementoPosicao (int info, int pos) {

        
        if (estaVazia() || pos == 1) {
            insereInicio(info);
        }
        else { // encontrar a posicao
            NoDuplo aux = primeiro;
            int cont = 1;
            while (aux != ultimo && cont < pos) {
                aux = aux.getProximo();
                cont++;
            }
            if (aux == ultimo) {
                insereFim(info);
            }
            else {
                NoDuplo novo = new NoDuplo(info);
                novo.setProximo(aux);
                novo.setAnterior(aux.getAnterior());
                novo.getProximo().setAnterior(novo);
                novo.getAnterior().setProximo(novo);
            }
        }
    }
    @Override
    public String toString() {
        String s = "";
        if (estaVazia()) {
            s += "lista vazia";
        }
        else {
            s += "//<= ";
            NoDuplo aux = primeiro;
            while (aux != null) {
                s += aux + " = ";
                aux = aux.getProximo(); 
            }
            s += ">//";
        }
        return s;
    }
}