package br.ufal.ic.p2.wepayu.service;

import br.ufal.ic.p2.wepayu.Exception.*;
import br.ufal.ic.p2.wepayu.models.Empregado;

import java.util.UUID;

import static br.ufal.ic.p2.wepayu.Sistema.lista;
import static br.ufal.ic.p2.wepayu.service.Validacoes.isNumeric;
import static br.ufal.ic.p2.wepayu.service.Validacoes.validaGetAtributoEmpregado;

public class EmpregadoService {

    public String GerarId(){
        String id = UUID.randomUUID().toString();
        return id;
    }

    public String criarEmpregado(String nome, String endereco, String tipo, String salario, String comissao) throws Exception, IdentificacaoNaoPodeSerNula {
        if (tipo.equalsIgnoreCase("comissionado"))
            throw new Exception("Tipo nao aplicavel.");

        String id = GerarId();

        Validacoes.validarEmpregado(nome,endereco,tipo,salario,comissao);

        Empregado empregado = new Empregado(id,nome,endereco,tipo, salario,comissao);

        lista.put(id,empregado);

         return id;
    }

    public String criarEmpregado(String nome, String endereco, String tipo, String salario) throws Exception, IdentificacaoNaoPodeSerNula {
        if (!tipo.equalsIgnoreCase("comissionado"))
            throw new Exception("Tipo nao aplicavel.");

        String id = GerarId();
        Validacoes.validarEmpregado(nome,endereco, tipo,salario);

        Empregado empregado = new Empregado(id,nome,endereco,tipo, salario);

        lista.put(id,empregado);
        return id;
    }

    public String getAtributoEmpregado(String id, String atributo) throws Exception, IdentificacaoNaoPodeSerNula {
        validaGetAtributoEmpregado(id, atributo);
        Empregado empregado = lista.get(id);

        if (id.isEmpty())
            throw new IdentificacaoNaoPodeSerNula();

        if (empregado == null)
            throw new EmpregadoNaoExisteException();

        if(atributo.equals("nome")){
            return empregado.getNome();
        }
        if(atributo.equals("tipo")){
            return empregado.getTipo();
        }

        if(atributo.equals("salario")){
            String salarioStr = empregado.getSalario();
            if (isNumeric(salarioStr)) {
                double salario = Double.parseDouble(salarioStr);
                if (salario % 1 == 0) { // se for inteiro
                    return String.format("%.0f,00", salario);
                } else { //se for decimal
                    return String.format("%.2f", salario).replace(".", ",");
                }
            } else {
                return salarioStr; // Retornar a string original se não for um número
            }
        }
        if(atributo.equals("comissao")){
            if (empregado.getTipo().equalsIgnoreCase("comissionado"))
                return empregado.getComissao();

            throw new EmpregadoNaoeComissionado();
        }
        if(atributo.equals("sindicalizado")){
            if(empregado.getSindicalizado()){
                return "true";
            }
            else{
                return "false";
            }
        }

        if(atributo.equals("endereco")){
            return empregado.getEndereco();
        }
        else throw new Exception("Atributo nao existe.");
    }
}
