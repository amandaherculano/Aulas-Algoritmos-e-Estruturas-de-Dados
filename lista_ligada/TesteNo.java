public class TesteNo {
    public static void main(String[] args) {
        No no1 = new No(10);
        No no2 = new No(20);

        System.out.println("no 1: " +  no1);
        System.out.println("no 2: " +  no2);

        no1.setProximo(no2);
        // proximo elemento depois do no1 é o no2, um atributo apontar para o no2

        System.out.println("e agora?? "+ no1.getProximo());
        // devolve referencia do no 2, espera que exiba 20

        no2.setProximo(no2);
        // aponta para ele mesmo

        System.out.println("e agora?? "+ no2.getProximo());
    }
}
