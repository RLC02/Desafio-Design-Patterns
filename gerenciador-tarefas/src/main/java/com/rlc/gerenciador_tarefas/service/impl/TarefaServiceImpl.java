package com.rlc.gerenciador_tarefas.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rlc.gerenciador_tarefas.model.Tarefa;
import com.rlc.gerenciador_tarefas.repository.TarefaRepository;
import com.rlc.gerenciador_tarefas.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Override
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    @Override
    public Tarefa buscarPorId(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.orElse(null);
    }

    @Override
    public void inserir(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
    }

    @Override
    public void atualizar(Long id, Tarefa tarefa) {
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);
        if (tarefaExistente.isPresent()) {
            tarefa.setId(id);
            tarefaRepository.save(tarefa);
        }
    }

    @Override
    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }

    @Override
    public void concluirTarefa(Long id) {
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);
        if (tarefaExistente.isPresent()) {
            Tarefa tarefa = tarefaExistente.get();
            tarefa.setConcluida(true);
            tarefaRepository.save(tarefa);
        }
    }

    @Override
    public List<Tarefa> filtrarPorStatus(Boolean concluida) {
        return tarefaRepository.findAll().stream()
                .filter(tarefa -> tarefa.isConcluida() == concluida)
                .collect(Collectors.toList());
    }

    @Override
    public void atualizarStatus(Long id, Boolean concluida) {
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);
        if (tarefaExistente.isPresent()) {
            Tarefa tarefa = tarefaExistente.get();
            tarefa.setConcluida(concluida);
            tarefaRepository.save(tarefa);
        }
    }

    @Override
    public List<Tarefa> buscarPorDescricao(String descricao) {
        return tarefaRepository.findAll().stream()
                .filter(tarefa -> tarefa.getDescricao().contains(descricao))
                .collect(Collectors.toList());
    }
}
