package Pilhas.pilha_sobre_lista_generica;

public class Carta {
    int valor;
    String naipe;
    public Carta (int valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }
    @Override
    public String toString () {
        return valor + " de " + naipe;
    }
}