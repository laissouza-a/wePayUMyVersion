package br.ufal.ic.p2.wepayu.Exception;

public class SalarioDeveSerNaoNegativo extends Exception {
    public SalarioDeveSerNaoNegativo(){
        super("Salario deve ser nao-negativo.");
    }
}
