public class TesteSemColisao {
    public static void main(String[] args) {
        Hash listaPessoas = new Hash(); //lista de pessoas tipo Hash 
    Pessoa p1 = new Pessoa("Ana", 2000);
    listaPessoas.insere(p1);
    if (listaPessoas.busca(p1)){
        System.out.println( p1.getNome() + " esta na lista");
    } else{
        System.out.println(p1.getNome() + " nao esta na lista");
    }

    Pessoa p2 = new Pessoa("Bia", 2010);
    if (listaPessoas.busca(p2)){
        System.out.println( p2.getNome() + " esta na lista");
    } else{
        System.out.println(p2.getNome() + " nao esta na lista");
    }
    Pessoa p3 = new Pessoa("Antonio", 2002);
    listaPessoas.insere(p3);
    System.out.println(listaPessoas);
    }
}
