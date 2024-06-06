import java.util.Scanner;

public class Estacionamento {
    public static void main(String[] args) {
        int quantidadeMaxima;
        int quantidadeAtual = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Oie!!\nSó um comentário antes de começarmos, para realizar este exercício o estacionamento foi entendido em um formato de U.  Dessa forma faria sentido entende-lo  como uma fila mas principalmente isso significa que sempre que um carro  precisa ser retirado e ele não está no começo da fila,  a ordem da fila irá mudar, isso porque não faria sentido  mover todos os carros apenas para preservar a ordem.\nBom era isso, beijinhos <3");
        System.out.println("\n*ESTACIONAMENTO COM FILA!*\nDigite a quantidade máxima de carros neste estacionamento: ");
        quantidadeMaxima = scanner.nextInt();

        Fila<Carro> estacionamento = new Fila<Carro>(); 
        int opcao;

        do {
            System.out.println("\nO que deseja fazer?\n1. Adicionar carro;\n2. Remover carro;\n3. Consultar se o carro esta no estacionamento;\n0. Encerrar");
            opcao = scanner.nextInt();
            if (opcao == 1) { //add
                if (quantidadeAtual < quantidadeMaxima){
                    System.out.println("Digite a placa do carro (4 números): ");
                    int placaNovo = scanner.nextInt();
                    Carro carroNovo = new Carro(placaNovo);
                    estacionamento.enfileira(carroNovo);
                    quantidadeAtual = quantidadeAtual + 1;
                    System.out.println("Ocupação atual: "+ quantidadeAtual + ", máximo: " + quantidadeMaxima);
                }
                else{
                    System.out.println("O estacionamento esta lotado");
                }
            
            } else if (opcao == 2) { //remover 
                System.out.println("Digite a placa do carro que deseja retirar do estacionamento: ");
                int placaRetirado = scanner.nextInt();
                boolean achou = false;
                Fila<Carro> rua = new Fila<Carro>();
                while (!estacionamento.estaVazia() && !achou){
                    No<Carro> carroAtual = estacionamento.primeiro; //percorrendo a pilha
                    if (carroAtual.getInfo().getPlaca() == placaRetirado){ 
                        achou = true;
                        estacionamento.desenfileira();
                        quantidadeAtual = quantidadeAtual - 1;
                        System.out.println("O carro " + carroAtual + " foi retirado do estacionamento"); //nao
                        while (!rua.estaVazia() && achou){
                            estacionamento.enfileira(rua.desenfileira());
                            estacionamento.ultimo.getInfo().setManobras();
                            System.out.println("Manobras do primeiro pra sair (ultimo): " + estacionamento.ultimo.getInfo().getManobras());
                            System.out.println("Rua: "+ rua);
                            System.out.println("Estacionamento: " + estacionamento);
                            System.out.println("quantidade: " + quantidadeAtual );
                        }
                    }else{ 
                        rua.enfileira(estacionamento.desenfileira());
                    }
                }
                if (!achou){
                    System.out.println("O carro não está no estacionamento");
                } 
            } else if (opcao == 3) { //consultar
                int posicao = 1;
                System.out.println("Digite a placa do carro que deseja consultar: ");
                int placaConsultado = scanner.nextInt();
                boolean achou = false;
                int primeiroCarro = estacionamento.primeiro.getInfo().getPlaca();
                Fila<Carro> rua = new Fila<Carro>(); 
                while (!estacionamento.estaVazia() && !achou){
                    No<Carro> carroAtual = estacionamento.primeiro; //percorrendo a pilha
                    if (carroAtual.getInfo().getPlaca() == placaConsultado){ 
                        achou = true;     
                        System.out.println(carroAtual.getInfo());
                        System.out.println("E ele está na posição: " + posicao); 
                        while (!rua.estaVazia() && achou){
                            estacionamento.enfileira(rua.desenfileira());
                            // System.out.println("Rua: "+ rua);
                            // System.out.println("Estacionamento: " + estacionamento);
                        }
                    }else{ 
                        posicao = posicao + 1;
                        rua.enfileira(estacionamento.desenfileira());
                    }
                }
                while (estacionamento.primeiro.getInfo().getPlaca() != primeiroCarro){
                    rua.enfileira(estacionamento.desenfileira());
                    estacionamento.enfileira(rua.desenfileira());
                }
                if (!achou){
                    System.out.println("O carro não está no estacionamento");
                }
            // } else if (opcao != 0) {
            //     System.out.println("Digite uma das opções");
            }else if( opcao == 4){
                System.out.println(estacionamento);
            }
        } while (opcao != 0);
        scanner.close();

        System.out.println(estacionamento);
        System.out.println("A quantidade de carros no estacionamento: " + quantidadeAtual);
    }
}