public class Lista {
    // head cabeca da lista
    private No primeiro;

    // lista nasce vazia 
    // construtor padrao, zera tudo 

    public No getPrimeiroNo(){
        return primeiro;
        //atributo de controle da lista -> principio do menor privilegio, deixa tudo fechado, se precisar abre
        // sem set para primeiro, por seguranca, par anao consguir mudar, se abrir pode perder o primeiro e perde tudo 
    }

    public boolean estaVazia(){
        return primeiro == null;
        // tem if embutido 
    }

    // novo no apont para o que esta em primeiro e depois troca o primeiro
    // NOVO APONTA PARA O P PRIMEIRO 
    public void insereInicio(int info){
        No novo = new No(info);
        if (!estaVazia()){
            novo.setProximo(primeiro);
        }
        primeiro = novo;
    }

    public void inserePosicao(int info, int posicao) {
        No novo = new No(info);
        if (posicao <= 0) {
            insereInicio(info); // If position is 0 or negative, insert at the beginning
        } else {
            No atual = primeiro;
            No anterior = null;
            int cont = 0;
            while (atual != null && cont < posicao) {
                anterior = atual;
                atual = atual.getProximo();
                cont++;
            }
            if (cont == posicao) {
                novo.setProximo(atual);
                if (anterior != null) {
                    anterior.setProximo(novo);
                } else {
                    primeiro = novo; // If previous node is null, means insertion at the beginning
                }
            } else {
                // If position is greater than the size of the list, insert at the end
                insereFim(info);
            }
        }
    }

    public int contarElemento( int e){
        No atual = primeiro;
        int contagem = 0;
        while (atual != null){
            if (atual.getInfo() == e){
                contagem++;
            }
            atual = atual.getProximo();
        }
        return contagem;
    }

    public int primeiraOcorrencia(int e){
        No atual = primeiro;
        int cont = 0;
        int posicao =0;
        boolean achou = false;
        while( atual != null && !achou){
            if (atual.getInfo() == e){
                posicao = cont+1;
                achou =true;
            }
            atual = atual.getProximo();
            cont++;
        } 
        if (posicao == 0){
            System.out.println("O elemento não esta na lista");
        }
        return posicao;
    } 


    public int removePosicao(int pos){

        if (estaVazia() || pos < 0){
            return 0;
        }
        if (pos == 0){
            primeiro = primeiro.getProximo();
            return 1;
        }
        No atual = primeiro;
        No anterior = null;
        int cont = 0;

        //localiza
        while(atual != null && cont < pos){
            anterior = atual;
            atual = atual.getProximo();
            cont ++;
        }
        // posicao fora da lista
        if (atual == null){
            return 0;
        }
        anterior.setProximo(atual.getProximo());
        return 1;
    }

    public int removePrimeira(int e){
        No atual = primeiro;
        No anterior = null;
        boolean achou = false;

        while( atual != null && !achou){
            
            if(atual.getInfo() == e){     
                anterior.setProximo(atual.getProximo());
                achou = true;
                return 1;
            }
            anterior = atual;
            atual = atual.getProximo();
        } return 0;
    }

    public int removeTodas(int e){
        No atual = primeiro;
        No anterior = null;
        int contagem =0;

        while ( atual.getProximo() != null){
            if (atual.getInfo() == e){
                anterior.setProximo(atual.getProximo());
                contagem++;
                return 1;
            }
            anterior = atual;
            atual = atual.getProximo();
        } return 3;
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

    public void insereFim(int info){
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

    
    public int removeInicio(){
        int temp = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        return temp;
    }

    public int removeFim(){
        int temp;
        if( primeiro.getProximo() == null ){ //lista tem um elemento só
            temp = primeiro.getInfo();
            primeiro = null;

        }else{
            No aux = primeiro;
            while (aux.getProximo().getProximo() != null){
                aux = aux.getProximo();
                // quando sair tem ctza que esta na penultima posicao
                // le de tras para frente 
            }
            temp = aux.getProximo().getInfo();
            aux.setProximo(null);
        }
        return temp;
    }

    }


