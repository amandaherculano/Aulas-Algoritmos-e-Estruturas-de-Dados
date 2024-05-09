public class FilaGenerica <E> {
    private E[] dados;  //container
    private int primeiro;
    private int ultimo;
    private int tamanho;

    //fila nascer de duas maneiras diferentes: construtor sem nada, capacidade minima OU usuario escolher 

    public static final int CAPACIDADE_MINIMA = 10; //algo com caixa alta, snakecase -> CONSTANTE, constante é final, static de classe não instancia, final nao pode ser modificada, nem sobrescrito 

    public FilaGenerica (int capacidade){
        if (capacidade > 10)
            dados = (E[]) new Object [capacidade];
        else 
            dados = (E[]) new Object [CAPACIDADE_MINIMA];
        primeiro = 0;
        ultimo = dados.length -1;
        tamanho = 0;
    }

    public FilaGenerica (){
        // dados = new int[CAPACIDADE_MINIMA]; //leitura mais facil quando tem nome para coisas, melhor do que aparecer apenas um 10 
        // //insersao sempre na frente, vai ficando para tras
        // primeiro = 0;
        // ultimo = dados.length;
        // tamanho = 0;

        this(CAPACIDADE_MINIMA);
    }

    //sem get e set para controles, porem envetualmente pode querer mostra fila de dados MAS SEM MODIFICAR 

    // public int[] getDados() { //exibir vetor 
    //     return dados;
    // } 
    
    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia(){ //para poder remover
        return tamanho == 0;
    }

    public boolean estaCheia(){ //para poder remover
        return tamanho == dados.length;
    }

    int proximaPosicao ( int posicao){
        return (posicao + 1 ) % dados.length;
    }

    public boolean enfileira( E i ){ //boolean para retornar se a fila estiver cheia 
        if (estaCheia()) return false;
        ultimo = proximaPosicao(ultimo); //do ultimo pega qual seria sua proxima posicao e atribui 
        dados[ultimo] = i; //na posicao do ultimo atulizado recebe i
        tamanho++;
        return true;
    }

    public E desenfilera(){
        if (estaVazia()) return null;
        E temp =  dados[primeiro]; //quem saiu da fila, antigo primeiro
        primeiro = proximaPosicao(primeiro); //anda com o primeiro 
        tamanho--;
        return temp;
    }

    //java docs: add devolve boolean se conseguir fazer adciona elemento na fila e pool remove o primeiro porém devolve X 
    @Override

    public String toString(){
        //testes
        if (estaCheia()) return "fila esta vazia";
        String s = "";
        int cont = primeiro;

        do {
            s = s + dados[cont] + " ";
            cont = proximaPosicao(cont);
        } while (cont != proximaPosicao(ultimo) ); //proxima para pegar o ULTIMO 
        return s;
    }

    public void mostraVetor() {
        if (estaVazia()) 
            System.out.print ("_ _ _ _ _ _ _ _ _ _ ");
        else if (primeiro <= ultimo) {
            for (int i=0; i<primeiro; i++)
                System.out.print ("_ ");
            for (int i=primeiro; i<=ultimo; i++)
                System.out.print (dados[i] + " ");
            for (int i=ultimo+1; i<dados.length; i++)
                System.out.print ("_ ");
        }
        else {
            for (int i=0; i<=ultimo; i++)
                System.out.print (dados[i] + " ");
            for (int i=ultimo + 1; i< primeiro; i++)
                System.out.print ("_ ");
            for (int i = primeiro; i<dados.length; i++)
                System.out.print (dados[i] + " ");
        }
        System.out.println();
    }

}


