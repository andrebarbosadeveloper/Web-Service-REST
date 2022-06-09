package EngSoftProjeto.Services.UseCasesFacade.Cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Services.ClienteService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImplementacao implements ClienteService {

    private final AdicionaProjetoClienteUseCase adicionarProjetoUseCase;
    private final CriarClienteUseCase criarClienteUseCase;


    public ClienteServiceImplementacao(AdicionaProjetoClienteUseCase adicionarProjetoUseCase, CriarClienteUseCase criarClienteUseCase) {
        this.adicionarProjetoUseCase = adicionarProjetoUseCase;
        this.criarClienteUseCase = criarClienteUseCase;
    }

    @Override
    public Optional<Cliente> adicionaProjeto(Long clienteId, Projeto projeto) {
        return adicionarProjetoUseCase.adicionaProjeto(clienteId,projeto);
    }

    @Override
    public Optional<Cliente> criarCliente(Cliente converter) {
        return criarClienteUseCase.criarCliente(converter);
    }


}
