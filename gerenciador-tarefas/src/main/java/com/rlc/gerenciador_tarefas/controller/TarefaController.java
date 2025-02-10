package com.rlc.gerenciador_tarefas.controller;

import com.rlc.gerenciador_tarefas.model.Tarefa;
import com.rlc.gerenciador_tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id);
    }

    @PostMapping
    public void inserir(@RequestBody Tarefa tarefa) {
        tarefaService.inserir(tarefa);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefaService.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
    }

    @PutMapping("/{id}/concluir")
    public void concluirTarefa(@PathVariable Long id) {
        tarefaService.concluirTarefa(id);
    }

    @GetMapping("/status/{concluida}")
    public List<Tarefa> filtrarPorStatus(@PathVariable Boolean concluida) {
        return tarefaService.filtrarPorStatus(concluida);
    }

    @PatchMapping("/{id}/status")
    public void atualizarStatus(@PathVariable Long id, @RequestBody Boolean concluida) {
        tarefaService.atualizarStatus(id, concluida);
    }

    @GetMapping("/descricao/{descricao}")
    public List<Tarefa> buscarPorDescricao(@PathVariable String descricao) {
        return tarefaService.buscarPorDescricao(descricao);
    }
}
