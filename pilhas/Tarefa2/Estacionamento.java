import java.util.Scanner;

public class Estacionamento {
    public static void main(String[] args) {
        int quantidadeMaxima;
        int quantidadeAtual = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n*ESTACIONAMENTO COM PILHA!*\nDigite a quantidade máxima de carros neste estacionamento: ");
        quantidadeMaxima = scanner.nextInt();

        Pilhas<Carro> estacionamento = new Pilhas<Carro>(); 

        int opcao;

        do {
            System.out.println("\nO que deseja fazer?\n1. Adicionar carro;\n2. Remover carro;\n3. Consultar se o carro esta no estacionamento;\n0. Encerrar");
            opcao = scanner.nextInt();
            if (opcao == 1) { //add
                if (quantidadeAtual < quantidadeMaxima){
                    System.out.println("Digite a placa do carro (4 números): ");
                    int placaNovo = scanner.nextInt();
                    Carro carroNovo = new Carro(placaNovo);
                    estacionamento.push(carroNovo);
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
                Pilhas<Carro> rua = new Pilhas<Carro>(); 
                while (!estacionamento.estaVazia() && !achou){
                    No<Carro> carroAtual = estacionamento.topo; //percorrendo a pilha
                    if (carroAtual.getInfo().getPlaca() == placaRetirado){ 
                        achou = true;
                        System.out.println("O carro " + carroAtual + " foi retirado do estacionamento"); //nao
                        estacionamento.pop(carroAtual.getInfo()); 
                        quantidadeAtual = quantidadeAtual - 1;

                        while (!rua.estaVazia() && achou){
                                
                            estacionamento.push(rua.pop(rua.topo.getInfo()));
                            estacionamento.topo.getInfo().setManobras();
                            // System.out.println("Manobras: " + estacionamento.topo.getInfo().getManobras());
                            // System.out.println("Rua: "+ rua);
                            // System.out.println("Estacionamento: " + estacionamento);
                        }
                    }else{ 
                        rua.push(estacionamento.pop(carroAtual.getInfo()));
                    }
                }
                if (!achou){
                    System.out.println("O carro não está no estacionamento");
                } 
            // }
            } else if (opcao == 3) { //consultar
                int posicao = 1;
                System.out.println("Digite a placa do carro que deseja consultar: ");
                int placaConsultado = scanner.nextInt();
                boolean achou = false;
                Pilhas<Carro> rua = new Pilhas<Carro>(); 
                while (!estacionamento.estaVazia() && !achou){
                    No<Carro> carroAtual = estacionamento.topo; //percorrendo a pilha
                    if (carroAtual.getInfo().getPlaca() == placaConsultado){ 
                        achou = true;     
                        System.out.println(carroAtual.getInfo());
                        System.out.println("E ele está na posição: " + posicao); 
                        while (!rua.estaVazia() && achou){
                            estacionamento.push(rua.pop(rua.topo.getInfo()));
                            // System.out.println("Rua: "+ rua);
                            // System.out.println("Estacionamento: " + estacionamento);
                        }
                    }else{ 
                        posicao = posicao + 1;
                        rua.push(estacionamento.pop(carroAtual.getInfo()));
                    }
                }
                if (!achou){
                    System.out.println("O carro não está no estacionamento");
                }
            } else if (opcao != 0) {
                System.out.println("Digite uma das opções");
            }
        } while (opcao != 0);
        scanner.close();

        System.out.println(estacionamento);
        System.out.println("A quantidade de carros no estacionamento: " + quantidadeAtual);
    }
}