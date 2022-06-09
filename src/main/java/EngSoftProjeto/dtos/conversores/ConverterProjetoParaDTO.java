package EngSoftProjeto.dtos.conversores;


import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.dtos.ProjetoResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ConverterProjetoParaDTO implements Conversor<ProjetoResponseDTO, Projeto>{

    @Override
    public ProjetoResponseDTO converter(Projeto projeto) {
            ProjetoResponseDTO projetoResponseDTO= new ProjetoResponseDTO();
            projetoResponseDTO.setId(projeto.getId());
            projetoResponseDTO.setNome(projeto.getNome());
            projetoResponseDTO.setTarefas(projeto.getTarefas());

            return projetoResponseDTO;
    }
}
