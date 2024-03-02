package br.ufal.ic.p2.wepayu.Exception;

public class IdentificacaoNaoPodeSerNula extends Throwable {
    public IdentificacaoNaoPodeSerNula(){
        super("Identificacao do empregado nao pode ser nula.");
    }
}
