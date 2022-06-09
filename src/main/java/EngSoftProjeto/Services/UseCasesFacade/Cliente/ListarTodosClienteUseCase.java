package EngSoftProjeto.Services.UseCasesFacade.Cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ListarTodosClienteUseCase {

    private final ClienteRepository clienteRepository;

    public ListarTodosClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        List<Cliente> clientes=new ArrayList<>();
        clienteRepository.findAll().forEach(clientes::add);
        return clientes;
    }
}
