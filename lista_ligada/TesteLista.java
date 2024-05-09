public class TesteLista  {
    public static void main(String[] args) {
        Lista lista = new Lista();
        System.out.println(lista);

        for (int i=1; i< 10; i+=2){
            lista.insereInicio(i);
            System.out.println(lista);
        }



        for (int i =2; i<=10; i+=2){
            lista.insereFim(i);
            System.out.println(lista);
        }
        //impares no inicio 
        //insersoes de fim, pares no fim

        if (lista.estaVazia()){
            System.out.println("lista vazia");
        }else{
            System.out.println(lista.removeInicio() + " foi removido do inicio");
            System.out.println(lista);
        }

        lista.inserePosicao(20 , 5);
        lista.inserePosicao(20 , 7);
        System.out.println(lista);

        int contar = lista.contarElemento(5);
        System.out.println(contar);


        System.out.println(lista.primeiraOcorrencia(20));
        lista.removePosicao(3);
        System.out.println("Removido");
        System.out.println(lista);
        lista.removePrimeira(20);
        System.out.println(lista);

        lista.removeTodas(20);
        System.out.println(lista);
        System.out.println(lista.removeTodas(20));

    }

    

}
