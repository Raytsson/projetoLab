package projetoAna.laboratorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoAna.laboratorio.entities.Clinica;
import projetoAna.laboratorio.entities.Dentista;
import projetoAna.laboratorio.repositories.ClinicaRepository;
import projetoAna.laboratorio.repositories.DentistaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {

    @Autowired
    private DentistaRepository repository;

    public List<Dentista> findAll(){
        return repository.findAll();
    }

    public Dentista findById(Long id){
        Optional<Dentista> obj = repository.findById(id);
        return obj.get();
    }

}
