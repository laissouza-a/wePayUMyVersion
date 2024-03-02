package br.ufal.ic.p2.wepayu.Exception;

public class SalarioDeveSerNumerico extends Exception{
    public SalarioDeveSerNumerico(){
        super("Salario deve ser numerico.");
    }
}
