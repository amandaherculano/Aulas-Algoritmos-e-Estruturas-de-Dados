public class No {
    private int info;
    private int quantidade;
    private No esquerda;
    private No direita;
    
    public No(int info) {
        this.info = info;
        this.quantidade = 1;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public int getQuantidade() { //sem set para nao mexerem 
        return quantidade;
    }

    public void somaQuantidade() { //incrementa
        quantidade ++;
    }
    public void subtraiQuantidade(){ //removendo nó
        quantidade --;
    }

    @Override
    public String toString() { //lista Json
        return "[info=" + info + ", quantidade=" + quantidade + "]";
    }

    

}
