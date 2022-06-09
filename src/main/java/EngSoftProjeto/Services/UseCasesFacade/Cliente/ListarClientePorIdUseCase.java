package EngSoftProjeto.Services.UseCasesFacade.Cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListarClientePorIdUseCase {
    private final ClienteRepository clienteRepository;

    public ListarClientePorIdUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
}
