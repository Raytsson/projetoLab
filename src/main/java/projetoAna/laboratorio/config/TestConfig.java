package projetoAna.laboratorio.config;

import projetoAna.laboratorio.entities.Clinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import projetoAna.laboratorio.entities.Dentista;
import projetoAna.laboratorio.repositories.ClinicaRepository;
import projetoAna.laboratorio.repositories.DentistaRepository;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private DentistaRepository dentistaRepository;

    @Override
    public void run(String... args) throws Exception {

        Clinica clinica1 = new Clinica(null, "Maroubo");
        Clinica clinica2 = new Clinica(null, "Diamantes");
        Clinica clinica3 = new Clinica(null, "Ruby");

        clinicaRepository.saveAll(Arrays.asList(clinica1, clinica2,clinica3));

        Dentista den1 = new Dentista(null,"fulano", clinica1);
        Dentista den2 = new Dentista(null,"ciclano", clinica2);
        Dentista den3 = new Dentista(null,"beltrano",clinica3);
        Dentista den4 = new Dentista(null,"fuxicano",clinica2);

        dentistaRepository.saveAll(Arrays.asList(den1));
        dentistaRepository.saveAll(Arrays.asList(den2));
        dentistaRepository.saveAll(Arrays.asList(den3));
        dentistaRepository.saveAll(Arrays.asList(den4));

    }


}
