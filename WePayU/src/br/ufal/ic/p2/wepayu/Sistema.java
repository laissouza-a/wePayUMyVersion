package br.ufal.ic.p2.wepayu;

import br.ufal.ic.p2.wepayu.models.Empregado;
import br.ufal.ic.p2.wepayu.service.EmpregadoService;

import java.util.HashMap;

public class Sistema {

    public static HashMap<String, Empregado> lista = new HashMap<>();
    public static EmpregadoService empregadoService = new EmpregadoService();

    public void zerarSistema() {
        lista.clear();
    }
}
