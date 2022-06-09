package EngSoftProjeto.Services.UseCasesFacade.Empregado;

import EngSoftProjeto.Models.Empregado;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionaTarefaUseCase {

    private final EmpregadoRepository empregadoRepository;

    @Autowired
    public AdicionaTarefaUseCase(EmpregadoRepository empregadoRepository) {
        this.empregadoRepository = empregadoRepository;
    }

    public Optional<Empregado> adicionaTarefa(Long empregadoId, Tarefa tarefa){
        Optional<Empregado> optionalEmpregado= this.empregadoRepository.findById(empregadoId);
        if(optionalEmpregado.isPresent()){
            Empregado empregado= optionalEmpregado.get();
            int numeroTarefasAntes= empregado.getTarefas().size();
            empregado.addTarefa(tarefa);
            int numeroTarefasDepois= empregado.getTarefas().size();

            if(numeroTarefasAntes != numeroTarefasDepois){
                return Optional.of(empregado);
            }
        }
        return Optional.empty();
    }
}
