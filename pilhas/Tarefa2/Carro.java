import java.time.Instant;
import java.time.Duration;

public class Carro {
    int placa;
    int manobras;
    Instant dataHoraCriacao;

    public Carro (int placa) {
        this.placa = placa;
        manobras = 0;
        this.dataHoraCriacao = Instant.now();
    }

    public long getTempoDesdeCriacao() {
        Instant agora = Instant.now();
        Duration duracao = Duration.between(dataHoraCriacao, agora);
        return duracao.getSeconds();
    }

    @Override
    public String toString () {
        return placa + " com " + manobras + " manobras, esta há " + getTempoDesdeCriacao() + " segundos na pilha";
    }
}


