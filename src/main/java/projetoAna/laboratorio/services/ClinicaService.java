package projetoAna.laboratorio.services;

import projetoAna.laboratorio.entities.Clinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoAna.laboratorio.repositories.ClinicaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository repository;

    public List<Clinica> findAll(){
        return repository.findAll();
    }

    public Clinica findById(Long id){
        Optional<Clinica> obj = repository.findById(id);
        return obj.get();
    }

}
