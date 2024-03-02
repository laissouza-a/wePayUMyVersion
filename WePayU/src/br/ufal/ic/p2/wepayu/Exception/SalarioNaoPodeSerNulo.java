package br.ufal.ic.p2.wepayu.Exception;

public class SalarioNaoPodeSerNulo extends Exception {
    public SalarioNaoPodeSerNulo(){
        super("Salario nao pode ser nulo.");
    }
}
