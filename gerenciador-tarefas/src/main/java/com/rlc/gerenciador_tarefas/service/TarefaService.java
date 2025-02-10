package com.rlc.gerenciador_tarefas.service;

import com.rlc.gerenciador_tarefas.model.Tarefa;
import java.util.List;

public interface TarefaService {
    List<Tarefa> listarTodas();
    Tarefa buscarPorId(Long id);
    void inserir(Tarefa tarefa);
    void atualizar(Long id, Tarefa tarefa);
    void deletar(Long id);
    void concluirTarefa(Long id);
    List<Tarefa> filtrarPorStatus(Boolean concluida);
    void atualizarStatus(Long id, Boolean concluida);
    List<Tarefa> buscarPorDescricao(String descricao);
}
