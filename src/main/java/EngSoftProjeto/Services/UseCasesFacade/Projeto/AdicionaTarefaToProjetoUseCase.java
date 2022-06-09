package EngSoftProjeto.Services.UseCasesFacade.Projeto;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionaTarefaToProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    @Autowired
    public AdicionaTarefaToProjetoUseCase(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }
    public Optional<Projeto> adicionaTarefa(Long id, Tarefa tarefa){
        Optional<Projeto> optionalProjeto= projetoRepository.findById(id);
        if(optionalProjeto.isPresent()){
            Projeto projeto= optionalProjeto.get();
            int numeroTarefasAntes= projeto.tarefas.size();
            projeto.addTarefa(tarefa);
            int numeroTarefasDepois= projeto.tarefas.size();

            if(numeroTarefasAntes != numeroTarefasDepois){
                return Optional.of(projeto);
            }
        }
        return Optional.empty();
    }

}
