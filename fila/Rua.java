public class Rua {
    public static void main(String[] args) {
        Carro c1 = new Carro("ABC1234", 2010);
        Carro c2 =  new Carro("XYZ4567", 2002);

        Fila<Carro> f = new Fila<> (); //identificou fila do que é 
        System.out.println(f);
        f.enfilera(c1);
        System.out.println(f);
        f.enfilera(c2);
        System.out.println(f);
        
        //como não precisa dos objetos carros, não precisa guardar na variavel, ja cria com a referencia 
        f.enfilera(new Carro("MNP5678", 2026));
        System.out.println(f);

        System.out.println(f.desenfileira() + " saiu da fila");
        System.out.println(f);
    }
}
