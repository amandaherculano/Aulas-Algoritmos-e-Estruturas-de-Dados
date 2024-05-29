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

    public int getPlaca() {
        return placa;
    }
    public int getManobras() {
        return manobras;
    }
    public void setManobras() {
        manobras = manobras + 1;
    }
    public Instant getDataHoraCriacao() {
        return dataHoraCriacao;
    }
    public void setDataHoraCriacao(Instant dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }
    public long getTempoDesdeCriacao() {
        Instant agora = Instant.now();
        Duration duracao = Duration.between(dataHoraCriacao, agora);
        return duracao.getSeconds();
    }

    @Override
    public String toString () {
        return placa + " com " + getManobras() + " manobras, esta há " + getTempoDesdeCriacao() + " segundos na pilha";
    }
}