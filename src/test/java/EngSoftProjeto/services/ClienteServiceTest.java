package EngSoftProjeto.services;


import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Services.ClienteService;
import EngSoftProjeto.Services.UseCasesFacade.Cliente.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ClienteServiceImplementacao.class)
class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @MockBean
    private AdicionaProjetoClienteUseCase adicionaProjetoClienteUseCase;

    @MockBean
    private CriarClienteUseCase criarClienteUseCase;


    @Test
    void criarCliente(){

        Cliente cliente= new Cliente();
        cliente.setEmail("pedroasd@miejkm.com");
        cliente.setNome("Pedro");

        when(criarClienteUseCase.criarCliente(cliente)).thenReturn(Optional.of(cliente));

        assertTrue(clienteService.criarCliente(cliente).isPresent());

    }

    @Test
    void adicionaProjeto(){

        Cliente cliente= new Cliente();
        cliente.setEmail("pedroasd@miejkm.com");
        cliente.setNome("Pedro");

        Projeto projeto = new Projeto();
        projeto.setNome("ESOF");
        projeto.setCliente(cliente);

        //Verifica se o UseCase retorna o tipo de objeto pretendido
        when(adicionaProjetoClienteUseCase.adicionaProjeto(cliente.getId(),projeto)).thenReturn(Optional.of(cliente));

        assertTrue(clienteService.adicionaProjeto(cliente.getId(),projeto).isPresent());

    }





}
