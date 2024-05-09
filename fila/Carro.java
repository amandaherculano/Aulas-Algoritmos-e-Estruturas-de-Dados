public class Carro {
    private String placa;
    private int anoFab;

    //construtor do carro 
    public Carro ( String placa, int anoFab){
        this.anoFab = anoFab;
        this.placa = placa;
    }

    //criado com botão direito, "Ação de Origem" + criar get e set e toStrign padrão 
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnoFab() {
        return anoFab;
    }

    public void setAnoFab(int anoFab) {
        this.anoFab = anoFab;
    }

    @Override
    public String toString() {
        return "[placa=" + placa + ", anoFab=" + anoFab + "]";
    }
}
