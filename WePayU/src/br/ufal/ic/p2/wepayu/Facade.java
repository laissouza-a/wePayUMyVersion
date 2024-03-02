package br.ufal.ic.p2.wepayu;

import br.ufal.ic.p2.wepayu.Exception.EmpregadoNaoExisteException;
import br.ufal.ic.p2.wepayu.Exception.IdentificacaoNaoPodeSerNula;
import br.ufal.ic.p2.wepayu.models.Empregado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Facade {
    Sistema sistema = new Sistema();
    public void encerrarSistema(){}
    public void zerarSistema(){
        sistema.zerarSistema();
    }

    public String criarEmpregado(String nome, String endereco, String tipo, String salario) throws Exception, IdentificacaoNaoPodeSerNula {
       return Sistema.empregadoService.criarEmpregado(nome, endereco, tipo, salario);
    }

    public String criarEmpregado(String nome, String endereco, String tipo, String salario, String comissao) throws Exception, IdentificacaoNaoPodeSerNula {
      return Sistema.empregadoService.criarEmpregado(nome, endereco, tipo, salario, comissao);
    }

    public String getAtributoEmpregado(String emp, String atributo) throws Exception, IdentificacaoNaoPodeSerNula {
       return Sistema.empregadoService.getAtributoEmpregado(emp,atributo);
    }

}
