public class Pilhas <Info>{
    public No<Info> topo;

    //construtor padrão 
    public boolean estaVazia(){
        return topo == null;
    }

    public void push (Info info){
        No <Info> novo = new No<Info> (info);
        if (!estaVazia()){
            novo.setProximo(topo);
        }
        topo = novo;
    }
    public void esvaziar() {
        topo = null;
    }


    //muda o pop: conseguimos devolver null, pilha fica mais robusta 

    public Info pop(Carro carro){
        //se estiver vazia -> resposta válida para responder para o usuário
        //antes fazia teste na aplicação, pois iria ter que devolver -1 
        if (estaVazia()){
            return null;
        }

        
        Info info = topo.getInfo();
        topo = topo.getProximo();
        return info;

    }

    @Override
    public String toString(){
        if (estaVazia()){
            return "pilha vazia";
        }else{
            //concatenação é empilhamento
            String s = "";
            //ní qualificado
            No <Info> no = topo;
            while ( no!= null){
                //concatenação \n efeito de empilhamento
                s += no + "\n";
                //andar
                no =  no.getProximo();
            }
            return s;
        }
    }
}
