package br.com.airline.companhia.core.application.port.in;

import br.com.airline.companhia.core.domain.Companhia;

public interface CompanhiaServicePort {

  Companhia adicionar(Companhia companhia);

  Companhia buscar(Integer id);

  Companhia atualizar(Integer id, Companhia companhia);

  void ativarCompanhia(Integer id);

  void inativarCompanhia(Integer id);
}
