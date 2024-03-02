package br.ufal.ic.p2.wepayu.Exception;

public class ComissaoNaoPodeSerNula extends Exception{
    public ComissaoNaoPodeSerNula(){
        super("Comissao nao pode ser nula.");
    }
}
