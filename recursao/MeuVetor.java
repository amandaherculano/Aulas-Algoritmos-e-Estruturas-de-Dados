import java.util.Random;
public class MeuVetor {
    private double[] v;
    private int ultimaPos;
 
    //construtor
    public MeuVetor (int capacidade) {
        v = new double[capacidade];
        ultimaPos = -1;
    }
    //métodos de acesso, Getters: buscar valor 
    public int getUltimaPos () {
        return ultimaPos;
    }
    public double[] getV() {
        return v;
    }
    //métodos modificadores
    //Setters: atribuir para determinado atributo (void = vazio) e no () o valor que quer atribuir
    // void porque não irá retornar nada
    // irá atribuir essa pos para a ultia posicao daquele vetor, então obrigatorio dar esse parametro

    public void setUltimaPos(int pos) {
         //condição no ()
         // nao pode neviar valor negativo nem posicao que seja maior que o tamanho dele 
        if (pos>=0 && pos<v.length) {
            ultimaPos = pos;
        }
        else {
            //-1 para ver a última pos, comeca no 0 então retirar um para saber ultima pos, tamanho=40 para ultimo numero 39

            // representa a ultima posicao de fato
            ultimaPos = v.length-1;
        }
    }

    public boolean add(int i) {
        
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    public boolean estaCheio () {
        return ultimaPos == v.length - 1;
    }
    public boolean estaVazio () {
        // se for -1 não existem nem um elemento na posicao 0 
        return ultimaPos == -1;
    }
    public void adiciona (int e) {
        if(estaCheio()){
            redimensiona(v.length*2);
        }
        v[++ultimaPos] = e;
    }
    public void adiciona (double e) {
        if(estaCheio()) redimensiona(v.length*2);
        v[++ultimaPos] = e;
    }
    //sobrecarga do adiciona com custo de arrasto
    public void adiciona (double e, int pos) {

        
        if(estaCheio()){
            redimensiona(v.length*2);//alocando um vetor com o dobreo do tamanho original
        }
        v[++ultimaPos] = e;  
        if (pos > ultimaPos) v[++ultimaPos] = e;
        int i;
        for (i = ultimaPos; i>=pos; i--) {
            v[i+1] = v[i];
        } 
        v[i+1] = e;
        ultimaPos++;
    }
    public double remove () {
        if  (estaVazio()) return 0;
        double aux = v[ultimaPos--];
        if (v.length>=10 && ultimaPos<=v.length/4){
            //copiando todos os elementos do vetor antigo para o novo
            redimensiona(v.length/2);
        }
        return aux;
    }
    public double remove(int posicao) {
        if (estaVazio() || posicao > ultimaPos) return 0;
        double aux = v[posicao];
        for (int i = posicao; i<ultimaPos; i++)
            v[i] = v[i+1];
        ultimaPos--;
        if (v.length >= 10 && ultimaPos <= v.length / 4) {
            redimensiona(v.length/2);
        }
        return aux;
    }
    public void adicionaPos (int e, int posicao) {
        if(estaCheio()){
            redimensiona(v.length*2);
        }
        v[posicao] = e;
    }

    public int contaElemento(int e){
        int contador = 0;
        for ( int i = 0; i<ultimaPos; i++){
            if(v[i]==e){
                contador++;
            }
        }

        return contador;

    }

    // public ArrayList instancias(){

    //     for(int i =0; i<v.length; i++){
    //         if(v[i])
    //     }

    //     ArrayList lista = new ArrayList();
    //     return lista;
    // }
    

    public int removePrimeiraOcorrencia (int x) {
        boolean achou = false;
        int i = 0;
        int result = -1;
        while (i<v.length && !achou)
            if (v[i] == x)
                achou = true;
            else 
                i++;
        if (achou) {
            for (int j=i; j<ultimaPos; j++)
                v[j] = v[j+1];
            ultimaPos--;
            result = i;
            if (ultimaPos <= v.length/4)
                redimensiona(v.length/2);
        }
        return result;
    } 


    public int removeTodasOcorrencias (int x) {

        // o que muda: não para quando acha 
        boolean achou = false;
        int i = 0;
        int result = -1;
        while (i<v.length && !achou)
            if (v[i] == x){
                achou = true;
                for (int j=i; j<ultimaPos; j++){
                    v[j] = v[j+1];
                    ultimaPos--;
                    result = i;
                }
                i++;
            }
            if (ultimaPos <= v.length/4)
                redimensiona(v.length/2);
        
        return result;
    } 

    public int removeTodas(double elemento) {
        if (estaVazio()) return 0;
        int cont = 0;
        for (int i = ultimaPos; i >= 0; i--) {
            if (v[i] == elemento) {
                // Move elements to cover the removed element
                for (int j = i; j < ultimaPos; j++) {
                    v[j] = v[j + 1];
                }
                ultimaPos--; // Decrement last position
                cont++; // Increment count of removed elements
            }
        }
        if (v.length >= 10 && ultimaPos <= v.length / 4) {
            redimensiona(v.length / 2); // Resize if necessary
        }
        return cont; // Return the number of removed elements
    }

    public int indicePrimeiraOcorrencia (int x) {
        boolean achou = false;
        int i = 0;
        int indice;

        while (i<v.length && !achou){
            if (v[i] == x){
                achou = true;
                indice = i;
                return indice + 1  ;
            }
            else 
                i++;
        }     
        return 0;
    } 



    public int remove (double elemento) {
        if (estaVazio()) return 0;
        int cont = 0;
        for (int i=ultimaPos; i>=0; i--) {
            if (v[i] == elemento) {
                //arrasta
                for (int j=i; j<ultimaPos; j++)
                    v[j] = v[j+1];
                ultimaPos--;
                cont++;
            }
        }
        if (v.length >= 10 && ultimaPos <= v.length / 4) {
            redimensiona(v.length/2);
        }
        return cont;
    } 
    private void redimensiona (int novaCapacidade) {
        double[] temp= new double [novaCapacidade];
        for (int i=0; i<=ultimaPos; i++) {
            temp[i] = v[i];
        }
        v = temp;
    }
    @Override
    public String toString () {
        String s = "";
        if (estaVazio()) {
            s = s + "esta vazio";
        }
        else {
            for (int i=0; i<=ultimaPos; i++) {
                // formato que ira exibir
                s = s + String.format("%.0f ", v[i]);
            }
        }
        s = s + "\n";
        return s;
    }
    public void resetVetor () {
        ultimaPos = -1;
    }
    public void preencheVetor() {
        Random r = new Random();
        resetVetor();
        while (!estaCheio()) {

            //alto nivel de abstracao ->melhor manuntencao 

            //adiciona(Math.random());
            //adiciona(r.nextDouble());
            //adiciona(r.nextInt());
            adiciona(r.nextInt(v.length*10) + 1);
        }
    }
    public void preencheVetor (int limite) {
        Random r = new Random();
        resetVetor();
        while (!estaCheio()) {
            adiciona(r.nextInt(limite));
        }
    }
    public int bubbleSort () {
        int cont = 0;
        for (int i=1; i<v.length; i++) {
            for (int j=0; j<v.length-i; j++) {
                cont++;
                // melhor caso nao interessa, medio deve fazer muitos testes DEVE VER O PIOR CASO
                if (v[j] > v[j+1]) {
                    // troca 
                    // temporário seré feito 1 
                    // ou pode não usar auxiliar e processar info -> ou pafa memoria ou processamento
                    double aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
        return cont;
    }
    public void insertionsort () {
        // Esta função rearranja o vetor v[0..n-1]
        // em ordem crescente.
        for (int j = 1; j < v.length; ++j) {
            double x = v[j];
            int i;
            for (i = j-1; i >= 0 && v[i] > x; --i) {
                v[i+1] = v[i];
            }
            v[i+1] = x;
        }
    }
     // ao contrario, descobre a posicao e SELECIONA a posicao para ele
    public void selectionsort () {
        for (int i = 0; i < v.length-1; ++i) {
            int min = i;

            //teste que otimiza valores, melhor porém quick superior
            for (int j = i+1; j < v.length; ++j) {
                if (v[j] < v[min]) { 
                    min = j;
                }
            }
            double x = v[i]; 
            v[i] = v[min]; 
            v[min] = x;
        }
    }

    //não é publico porque interessa apenas para área interna, o quick 
    int partition( int p, int r){
        double x = v[r]; //pivo é o ultimo elemento do vetor
        int i = p -1;
        for( int j = p; j < r; j++){
            if (v[j] <=x){
                i = i + 1;
                //ou pode fazer double aux = v[i++]
                double aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }
        i = i + 1;
        //trocando pivo
        v[r] = v[i];
        v[i] = x;
        return i; //retorna pivo
    }

    public void quick( int p, int r){
        //pelo menos duas posicoes 
        // System.out.println("p= " + p + ", r = " + r);
        if ( p< r){
            int q = partition(p, r);
            //chama o quick para os pedacos, antes e depois do pivô, que foram separados no partition
            // System.out.println("q = " + q);
            quick(p, q-1);
            quick(q+1, r);
        }
    }
    
}

// tudo da classe math é static, atributos de classe não precisa instanciar objetos 
// chamada do metodo associada a classe 
// estava tudo int passou para double -> tipo primitivo
// ArrayList<E> pode ter qualquer coisa, define elemento qualquer e instancia para classe de interesse -> não admite tipo primirto, lista de qualquer coisa, <E> é objeto 


// random: clasee do pacote java ultil -> importar 
// randon: métodos de instancia deve nomear para usar 
