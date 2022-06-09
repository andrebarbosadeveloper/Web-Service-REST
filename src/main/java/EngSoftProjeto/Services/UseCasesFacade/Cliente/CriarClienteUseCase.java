package EngSoftProjeto.Services.UseCasesFacade.Cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ClienteRepository;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CriarClienteUseCase {
    private final ClienteRepository clienteRepository;
    private final ProjetoRepository projetoRepository;

    @Autowired
    public CriarClienteUseCase(ClienteRepository clienteRepository, ProjetoRepository projetoRepository) {
        this.clienteRepository = clienteRepository;    //explicador
        this.projetoRepository = projetoRepository;
    }

    public Optional<Cliente> criarCliente(Cliente cliente) {
        Optional<Cliente> optionalCliente=clienteRepository.findById(cliente.getId());
        if(optionalCliente.isEmpty()){
            clienteRepository.save(cliente);
            List<Projeto> projetos=new ArrayList<>();
            cliente.getProjetos().forEach(projeto -> {
                Optional<Projeto> optionalProjeto=projetoRepository.findById(projeto.getId());
                if(optionalProjeto.isPresent()){
                    projetos.add(projeto);
                    cliente.addProjeto(projeto);
                    //projeto.setCliente(cliente);
                    projetoRepository.save(optionalProjeto.get());
                }
            });
            cliente.setProjetos(projetos);
            return Optional.of(clienteRepository.save(cliente));
        }
        return Optional.empty();
    }
}
