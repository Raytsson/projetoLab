package projetoAna.laboratorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoAna.laboratorio.entities.Protetica;
import projetoAna.laboratorio.repositories.ProteticaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProteticaService {

    @Autowired
    private ProteticaRepository repository;

    public List<Protetica> findAll() {
        return  repository.findAll();
    }

    public Protetica findById(Long id){
        Optional<Protetica> obj = repository.findById(id);
        return obj.get();
    }
}
