import java.util.Scanner;
import java.util.Random;

public class Estacionamento {
    public static void main(String[] args) {
        int quantidade;
        int quantidadeMaxima;
        int quantidadeAtual;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade máxima de carros neste estacionamento: ");
        quantidadeMaxima = scanner.nextInt();

        Pilhas<Carro> estacionamento = new Pilhas<Carro>();
        quantidadeAtual = 0;
        Pilhas<Carro> rua = new Pilhas<Carro>();

        // Random random = new Random();

        // System.out.println("Digite a quantidade de carros que deseja inserir: ");
        // quantidade = scanner.nextInt();
        // if ( quantidade < quantidadeMaxima){
        //     for ( int i = 0; i < quantidade; i++){
        //         System.out.println("Digite a placa do carro (4 números): ");
        //         int placaNovo = scanner.nextInt();
        //         Carro carroNovo = new Carro(placaNovo);
        //         estacionamento.push(carroNovo);
        //         quantidadeAtual =+ 1;
                
        //     for ( int i = 0; i < quantidade; i++){
        //      int placa = random.nextInt(9999); // Gera um número aleatório entre 0 e 9999
        //      Carro carro = new Carro(placa);
        //      estacionamento.push(carro);
        //     }
        //     }
        // }else{
        //     System.out.println("O estacionamento esta lotado!");
        // }

        System.out.println("O que deseja fazer?\nDigite 1 para adcionar carro,\nDigite 2 para remover carro\nDigite 3 para consultar se o carro esta no estacionamento\n0 encerra");
        int opcao = scanner.nextInt();
        if ( opcao == 1){ //add
            if (quantidadeAtual < quantidadeMaxima){
                System.out.println("Digite a placa do carro (4 números): ");
                int placaNovo = scanner.nextInt();
                Carro carroNovo = new Carro(placaNovo);
                estacionamento.push(carroNovo);
                quantidadeAtual =+ 1;
            }
            else{
                System.out.println("O estacionamento esta lotado");
            }
        }
        else if( opcao == 2){ //remover 


            //ver se esta
            System.out.println("Digite a placa do carro que deseja retirar do estacionemento: ");
            int placaRetirado = scanner.nextInt();
            Carro carroRetirado = new Carro(placaRetirado);
            estacionamento.pop(carroRetirado);
            rua.push(carroRetirado);
            quantidadeAtual =- 1;
        }
        else if ( opcao == 3){ //consultar

        }
        else if(opcao ==0 ){
            scanner.close();
        }
        else{
            System.out.println("Digite uma das opções");
        }
        System.out.println(estacionamento);
        System.out.println(quantidadeAtual);
    }
}