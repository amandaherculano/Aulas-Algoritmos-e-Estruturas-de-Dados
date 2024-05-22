import java.util.Scanner;
import java.util.Random;

public class Estacionamento {
    public static void main(String[] args) {
        int quantidade;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a quantidade de carros: ");
        quantidade = scanner.nextInt();
        Pilhas<Carro> estacionamento = new Pilhas<Carro>();
        Pilhas<Carro> rua = new Pilhas<Carro>();

        Random random = new Random();

        for ( int i = 0; i < quantidade; i++){
            int placa = random.nextInt(9999); // Gera um número aleatório entre 0 e 9999
            Carro carro = new Carro(placa);
            estacionamento.push(carro);
        }

        for ( int i = 0; i < quantidade; i++){
            System.out.println("Digite a placa do carro (4 números): ");
            int placa = scanner.nextInt();
            Carro carro = new Carro(placa);
            estacionamento.push(carro);
        }

        System.out.println("Digite a placa do carro que deseja retirar do estacionemento: ");
        int placaRetirado = scanner.nextInt();
        Carro carroRetirado = new Carro(placaRetirado);
        estacionamento.pop(carroRetirado);
        rua.push(carroRetirado);
        System.out.println(estacionamento);
        scanner.close();
    }
}