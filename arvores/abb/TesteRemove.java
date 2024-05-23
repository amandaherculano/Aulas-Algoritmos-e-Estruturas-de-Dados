public class TesteRemove {
    public static void main(String[] args) {
        ABB abb =  new ABB();
        abb.insere(40);
        abb.insere(20);
        abb.insere(60);
        abb.insere(10);
        abb.insere(30);
        abb.insere(50);
        abb.insere(70);
        abb.insere(5);
        abb.insere(15);
        abb.insere(75);
        abb.insere(72);
        abb.insere(71);
        abb.insere(65); 
        System.out.println(abb.stringInOrder());
        abb.remove(20);
        System.out.println(abb.stringInOrder());
        abb.remove(70);
        System.out.println(abb.stringInOrder());
    }
}
