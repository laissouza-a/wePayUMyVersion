package br.ufal.ic.p2.wepayu.service;

import br.ufal.ic.p2.wepayu.Exception.*;

import static br.ufal.ic.p2.wepayu.Sistema.lista;


public class Validacoes {

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void validarEmpregado(String nome, String endereco, String tipo, String salario) throws nomeNaoPodeSerNulo, EnderecoNaoPodeSerNulo, TipoInvalido, SalarioDeveSerNumerico, SalarioNaoPodeSerNulo, SalarioDeveSerNaoNegativo, IdentificacaoNaoPodeSerNula {
        validaNome(nome);
        validaEndereco(endereco);
        validaTipo(tipo);
        validaSalario(salario);
    }
    public static void validarEmpregado(String nome, String endereco, String tipo, String salario, String comissao) throws EnderecoNaoPodeSerNulo, TipoInvalido, SalarioDeveSerNumerico, SalarioNaoPodeSerNulo, SalarioDeveSerNaoNegativo, ComissaoDeveSerNumerica, ComissaoDeveSerNaoNegativa, ComissaoNaoPodeSerNula, nomeNaoPodeSerNulo, IdentificacaoNaoPodeSerNula {
        validaNome(nome);
        validaEndereco(endereco);
        validaTipo(tipo);
        validaSalario(salario);
        validaComissao(comissao);
    }
    static void validaGetAtributoEmpregado(String id, String atributoRequerido) throws Exception, IdentificacaoNaoPodeSerNula {
        validaAtributo(id,atributoRequerido);
    }
    private static void validaAtributo(String id, String atributoRequerido) throws Exception {
       validarExistenciaAtributo(atributoRequerido);
        if (atributoRequerido.equals("comissao")){
            if (!lista.get(id).getTipo().equals("comissionado"))
                throw new EmpregadoNaoeComissionado();
        }
    }
    public static void validaNome(String nome) throws nomeNaoPodeSerNulo {
        if (nome == null || nome.isEmpty()) {
            throw new nomeNaoPodeSerNulo();
        }
    }
    public static void validaEndereco(String endereco) throws EnderecoNaoPodeSerNulo {
        if (endereco == null || endereco.isEmpty()) {
            throw new EnderecoNaoPodeSerNulo();
        }
    }
    public static void validaTipo(String tipo) throws TipoInvalido {
        if (!tipo.equalsIgnoreCase("comissionado") && !tipo.equalsIgnoreCase("horista") && !tipo.equalsIgnoreCase("assalariado")){
            throw new TipoInvalido();
        }
    }

    public static void validaSalario(String salario) throws SalarioDeveSerNaoNegativo, SalarioDeveSerNumerico, SalarioNaoPodeSerNulo {
        if (salario.isEmpty())
            throw new SalarioNaoPodeSerNulo();

        if (isNumeric(salario))
            throw new SalarioDeveSerNumerico();

        if (salario.charAt(0) == '-') {
            throw new SalarioDeveSerNaoNegativo();
        }
    }
    public static void validaComissao(String comissao) throws ComissaoDeveSerNaoNegativa, ComissaoNaoPodeSerNula, ComissaoDeveSerNumerica {
        if (comissao.isEmpty())
            throw new ComissaoNaoPodeSerNula();

        if(comissao.charAt(0) == '-')
            throw new ComissaoDeveSerNaoNegativa();

        if (isNumeric(comissao))
            throw new ComissaoDeveSerNumerica();
    }
    public static void validaId(String id) throws IdentificacaoNaoPodeSerNula, EmpregadoNaoExisteException {
        if (id.isEmpty())
            throw new IdentificacaoNaoPodeSerNula();

        if (lista.get(id) == null)
            throw new EmpregadoNaoExisteException();
    }

    public static void qualquerStringNula(String id, String message) throws Exception {
        if (id.isEmpty())
            throw new Exception(message + " nao pode ser nula.");
    }
    public static void validaValorComissao(String valor) throws ComissaoNaoPodeSerNula, ComissaoDeveSerNaoNegativa, ComissaoDeveSerNumerica {

        if (valor == null || valor.isEmpty()) {
            throw new ComissaoNaoPodeSerNula();
        }
        if (valor.charAt(0) == '-') {
            throw new ComissaoDeveSerNaoNegativa();
        }

        // Verifica se a comissão é um número
        for (char c : valor.toCharArray()) {
            if (!Character.isDigit(c) && c != ',') {
                throw new ComissaoDeveSerNumerica();
            }
        }
    }
    public static void validarExistenciaAtributo(String atributo) throws Exception {
        switch (atributo.toLowerCase()) {
            case "nome":
            case "endereco":
            case "tipo":
            case "salario":
            case "sindicalizado":
            case "comissao":
            case "metodopagamento":
            case "banco":
            case "agencia":
                break;
            default:
                throw new Exception("Atributo nao existe.");
        }
    }

}
