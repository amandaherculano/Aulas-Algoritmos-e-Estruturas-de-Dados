public class NoDuplo{
    private int info;
    private NoDuplo anterior;
    private NoDuplo proximo;

    // construtor não padrão 
    public NoDuplo(int info){
        setInfo(info);
        setAnterior(null);
        setProximo(null);
    }

    // padrao 
    public int getInfo(){
        return info;
    }

    public NoDuplo getAnterior(){
        return anterior;
    }

    public NoDuplo getProximo(){
        return proximo;
    }

    // se tivesse validação estaria aqui 
    // set sempre void

    public void setInfo(int info){
        this.info = info;
    }

    public void setAnterior(NoDuplo anterior){
        this.anterior = anterior;
    }

    public void setProximo(NoDuplo proximo ){
        this.proximo = proximo;
    }

    // caixinha 
    // "anotacao"
    // assinatura do metodo não pode ser alterada 
    // compilador sabe que não pode mexer ali 
    @Override
    public String toString(){
        return "|" + info + "|";
    }



}