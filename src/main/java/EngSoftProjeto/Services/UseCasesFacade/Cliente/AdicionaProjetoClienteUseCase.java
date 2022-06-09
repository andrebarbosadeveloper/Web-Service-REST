package EngSoftProjeto.Services.UseCasesFacade.Cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionaProjetoClienteUseCase {

    private final ClienteRepository clienteRepository;

    @Autowired
    public AdicionaProjetoClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Optional<Cliente> adicionaProjeto(Long clienteId, Projeto projeto) {
        Optional<Cliente> optionalCliente=this.clienteRepository.findById(clienteId);
        if(optionalCliente.isPresent()){
            Cliente cliente=optionalCliente.get();
            int quantidadeProjetosAntes =cliente.getProjetos().size();
            cliente.addProjeto(projeto);
            int quantidadeProjetosDepois=cliente.getProjetos().size();
            if(quantidadeProjetosAntes!=quantidadeProjetosDepois) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

}
