public class No {
    private int info;
    private No proximo;

    // construtor do nó apenas se for guardar uma informação
    public No (int info){
        // usa mesmo nome do atributo e parametro, boas praticas
        // this.info = info;
        // this é "p1"
        setInfo(info);
        proximo = null;  //por clareza
    }
    
    public int getInfo(){
        return info;
    }

    // devolver a referencia de um no   
    public No getProximo(){
        return proximo;
        // devolve endereco, refernecia de quem esta na frente, melhor amigo de uma pessoa é uma pessoa 
    }

    public void setInfo(int info){

        // tirar ambiguidade 
        // construtor e setinfo estão fazendo a memsma coisa -> complica se tiver alguma regra de negocio
        // se tiver alguma regra, deixa no set e chamar o set no construtor, deixa set se virar "stInfo(info)"
        this.info=info;
    }

    public void setProximo(No proximo){
        this.proximo=proximo;

    }


    @Override
    public String toString(){
        return "|" + info + "|->";
    }
}