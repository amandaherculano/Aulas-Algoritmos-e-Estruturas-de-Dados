public class NovoHash {
    private final String mapa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //nao pode ser alterada, constante final
    private Lista[] tabela; //array de pessoas 
    public NovoHash(){
        tabela = new Lista[26]; //inicializa o array com 26 posicoes
        for (int i = 0; i < 26; i++){
            tabela[i] = new Lista(); //cada posicao do array é uma lista
        }
    }
    public void insere(Pessoa pessoa){
        char primeiraLetra = pessoa.getNome().charAt(0); //pega a primeira letra do nome da pessoa
        int posicao = mapa.indexOf(primeiraLetra); //pega a posicao da letra no mapa
        tabela[posicao].insere(pessoa); //cada posicao do meu vetor é uma lista de pessoas
    }
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 26; i++){
            s += tabela[i] + "\n";
        }
        return s;
    }
}
