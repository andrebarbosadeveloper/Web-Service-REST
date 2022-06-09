package EngSoftProjeto.Services;

import EngSoftProjeto.Models.Empregado;
import EngSoftProjeto.Models.Tarefa;

import java.util.Optional;

public interface EmpregadoService {

    //Cria Empregado
    Optional<Empregado> criaEmpregado(Empregado converter);

    //Adiciona Tarefa a Empregado
    Optional<Empregado> adicionaTarefa(Long id, Tarefa tarefa);

    //Update de uma tarefa->NAO IMPLEMENTADO.TEMOS OUTRO EXEMPLO
    Optional<Empregado> atualizarTarefaDuracao(Long empregadoId, Long tarefaId, int duracao);

    //Remocao de uma Tarefa->NAO IMPLEMENTADO
    Optional<Empregado> removerTarefa(Long empregadoId, Long tarefaId);
}
