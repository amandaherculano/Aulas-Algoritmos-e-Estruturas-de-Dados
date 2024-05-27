public class Hash {
    private final String mapa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //nao pode ser alterada, constante final
    private Pessoa[] tabela; //array de pessoas 
    public Hash(){
        tabela = new Pessoa[26]; //inicializa o array com 26 posicoes
    }
    public void insere (Pessoa pessoa){
        char primeiraLetra = pessoa.getNome().charAt(0); //pega a primeira letra do nome da pessoa
        int posicao = mapa.indexOf(primeiraLetra); //pega a posicao da letra no mapa
        tabela[posicao] = pessoa; //insere a pessoa na posicao do array
    }

    public boolean busca(Pessoa pessoa){
        char primeiraLetra = pessoa.getNome().charAt(0);
        int posicao = mapa.indexOf(primeiraLetra);
        if (pessoa.equals(tabela[posicao])) return true;
        return false;
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
