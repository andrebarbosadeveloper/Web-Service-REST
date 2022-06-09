package EngSoftProjeto;

import EngSoftProjeto.Models.*;
import EngSoftProjeto.Repositories.ClienteRepository;
import EngSoftProjeto.Repositories.EmpregadoRepository;
import EngSoftProjeto.Repositories.ProjetoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private TarefaRepository tarefaRepository;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

       /* Cliente */

        Cliente cl= new Cliente();
        cl.setEmail("abcd@hohoh.com");
        cl.setNome("Joao B");

        clienteRepository.save(cl);

        /* Projeto */

        Projeto p1 = new Projeto();
        p1.setNome("Projeto ESOF");
        p1.setCliente(cl);

        /* Empregado    */

        Empregado emp = new Empregado();
        emp.setNome("Andre B");
        emp.setCargo(Cargo.DesenvolvedorJr);
        emp.custo(emp.getCargo());

        empregadoRepository.save(emp);

        Empregado emp1 = new Empregado();
        emp1.setNome("Jose N");
        emp1.setCargo(Cargo.AnalistaJr);
        emp1.custo(emp.getCargo());

        empregadoRepository.save(emp1);

        Empregado emp2 = new Empregado();
        emp2.setNome("Joao F");
        emp2.setCargo(Cargo.DesenvolvedorSr);
        emp2.custo(emp.getCargo());

        empregadoRepository.save(emp2);


        /* Tarefa */

        Tarefa tf = new Tarefa();

        //tf.setId(1L);
        tf.setEmpregado(emp);
        tf.setDuracao(60);
       // tarefaRepository.save(tf);

        Tarefa tf1 = new Tarefa();

        //tf1.setId(2L);
       tf1.setEmpregado(emp1);
        tf1.setDuracao(80);
    //    tarefaRepository.save(tf1);

        Tarefa tf2 = new Tarefa();

        //tf2.setId(3L);
        tf2.setEmpregado(emp2);
        tf2.setDuracao(120);
    //    tarefaRepository.save(tf2);

        //Nome do Projeto de cada tarefa no localhost
        p1.addTarefa(tf);
        p1.addTarefa(tf1);
        p1.addTarefa(tf2);

        projetoRepository.save(p1);

    }
}
