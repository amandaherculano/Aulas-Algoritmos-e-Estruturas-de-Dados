import java.util.Scanner;

public class Estacionamento {
    public static void main(String[] args) {
        int quantidadeMaxima;
        int quantidadeAtual = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade máxima de carros neste estacionamento: ");
        quantidadeMaxima = scanner.nextInt();

        Pilhas<Carro> estacionamento = new Pilhas<Carro>(); 

        int opcao;

        do {
            System.out.println("O que deseja fazer?\nDigite 1 para adicionar carro,\nDigite 2 para remover carro\nDigite 3 para consultar se o carro esta no estacionamento\n0 encerra");
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
                Carro carroRetirado = new Carro(placaRetirado);
                if (carroRetirado.estaEstacionado == false) {
                    System.out.println("O carro não está no estacionamento");
                }else{
                    boolean achou = false;
                    Pilhas<Carro> rua = new Pilhas<Carro>(); 
                    while (!estacionamento.estaVazia() && !achou){
                        No<Carro> carroAtual = estacionamento.topo; //percorrendo a pilha
                        if (carroAtual.getInfo().getPlaca() == placaRetirado){ 
                            achou = true;
                            System.out.println("O carro " + carroAtual + "foi retirado do estacionamento"); //nao
                            estacionamento.pop(carroAtual.getInfo()); 
                            quantidadeAtual = quantidadeAtual - 1;
                            carroRetirado.estaEstacionado = false;

                            while (!rua.estaVazia() && achou){
                                    
                                estacionamento.push(rua.pop(carroAtual.getInfo()));
                                carroAtual.getInfo().setManobras();
                                System.out.println("Manobras: " + carroAtual.getInfo().manobras);
                                System.out.println("Rua: "+ rua);
                                System.out.println("Estacionamento: " + estacionamento);
                            }
                        }else{ 
                            rua.push(estacionamento.pop(carroAtual.getInfo()));
                            // System.out.println(rua);
                        }
                    }
                }
            } else if (opcao == 3) { //consultar
                // int posicao;
                // System.out.println("Digite a placa do carro que deseja consultar: ");
                // int placaConsultado = scanner.nextInt();
                // Carro carroConsultado = new Carro(placaConsultado);
                // if (carroConsultado.estaEstacionado == true) {
                //     System.out.println("O carro está no estacionamento");
                //     //TODO qual posicao
                //     boolean achou = false;
                //     while (!estacionamento.estaVazia() && !achou){
                //         Carro carroAtual = estacionamento.pop(carroConsultado); //percorrendo a pilha
                //         if (carroAtual.getPlaca() == placaConsultado){ //se for o topo
                //             achou = true;
                //             posicao = 1;
                //             System.out.println("O carro está na posição: " + posicao);
                //         }else{
                //             Pilhas<Carro> rua = new Pilhas<Carro>();  //tirar APENAS QUANDO MANOBRAR
                //             rua.push(estacionamento.pop(carroRetirado));
                //         }
                //     }

                // } else {
                //     System.out.println("O carro não está no estacionamento");
                // }
            } else if (opcao != 0) {
                System.out.println("Digite uma das opções");
            }
        } while (opcao != 0);
        scanner.close();

        System.out.println(estacionamento);
        System.out.println("A quantidade de carros no estacionamento: " + quantidadeAtual);
    }
}