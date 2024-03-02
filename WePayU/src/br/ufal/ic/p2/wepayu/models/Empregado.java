package br.ufal.ic.p2.wepayu.models;

import br.ufal.ic.p2.wepayu.Exception.EmpregadoNaoExisteException;

public class Empregado {

    private String id;
    private String nome;
    private String endereco;
    private String tipo;
    private String salario;
    private String comissao;
    private boolean sindicalizado = false;

    private boolean comissionado;

    public Empregado(String id, String nome, String endereco, String tipo, String salario, String comissao) {
       this.id=id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipo = tipo;
        this.salario = salario;
        this.comissao = comissao;
        this.comissionado= true;
    }

    public Empregado(String id,String nome, String endereco, String tipo, String salario) throws EmpregadoNaoExisteException {
        this.id=id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipo = tipo;
        this.salario = salario;
        this.comissionado= false;
        this.sindicalizado = sindicalizado;


    }

    public String getNome() {
        return nome;
    }
    public void setNome(String Nome) {this.nome = Nome;}

    public String getEndereco() {return endereco;}
    public void setEndereco(String Endereco) {this.endereco = Endereco;}

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String Tipo) {this.tipo = Tipo;}
    public String getId(){return id;}

    public String getSalario() {
        return salario;
    }
    public void setSalario(String Salario) {this.salario = Salario;}

    public String getComissao() {
        return comissao;
    }
    public void setComissao(String NovaComissao) {this.comissao = NovaComissao;}

    public boolean getSindicalizado() {
        return sindicalizado;
    }
}
