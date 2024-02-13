package projetoAna.laboratorio.config;

import projetoAna.laboratorio.entities.Clinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import projetoAna.laboratorio.entities.Dentista;
import projetoAna.laboratorio.entities.Paciente;
import projetoAna.laboratorio.entities.Servico;
import projetoAna.laboratorio.repositories.ClinicaRepository;
import projetoAna.laboratorio.repositories.DentistaRepository;
import projetoAna.laboratorio.repositories.PacienteRepository;
import projetoAna.laboratorio.repositories.ServicoRepository;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private DentistaRepository dentistaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public void run(String... args) throws Exception {

        Clinica clinica1 = new Clinica(null, "Maroubo");
        Clinica clinica2 = new Clinica(null, "Diamantes");
        Clinica clinica3 = new Clinica(null, "Ruby");

        clinicaRepository.saveAll(Arrays.asList(clinica1, clinica2,clinica3));

        Dentista den1 = new Dentista(null,"fulano", clinica1);
        Dentista den2 = new Dentista(null,"ciclano", clinica2);
        Dentista den3 = new Dentista(null,"beltrano",clinica3);
        Dentista den4 = new Dentista(null,"fuxicano",clinica2 );

        dentistaRepository.saveAll(Arrays.asList(den1));
        dentistaRepository.saveAll(Arrays.asList(den2));
        dentistaRepository.saveAll(Arrays.asList(den3));
        dentistaRepository.saveAll(Arrays.asList(den4));

        Paciente pac1 = new Paciente(null, "pac1", 23, "A2" );
        Paciente pac2 = new Paciente(null, "pac2", 25, "A3" );
        Paciente pac3 = new Paciente(null, "pac3", 67, "A5" );
        Paciente pac4 = new Paciente(null, "pac4", 56, "B2" );

        pacienteRepository.saveAll(Arrays.asList(pac1));
        pacienteRepository.saveAll(Arrays.asList(pac2));
        pacienteRepository.saveAll(Arrays.asList(pac3));
        pacienteRepository.saveAll(Arrays.asList(pac4));

        Servico serv1 = new Servico(null,"descricao do problema", LocalDate.now(), LocalDate.of(2024,02,27));

        servicoRepository.saveAll(Arrays.asList(serv1));

    }


}
