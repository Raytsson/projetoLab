package projetoAna.laboratorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoAna.laboratorio.entities.Servico;
import projetoAna.laboratorio.repositories.ServicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public List<Servico> findAll() {
        return  repository.findAll();
    }

    public Servico findById(Long id){
        Optional<Servico> obj = repository.findById(id);
        return obj.get();
    }
}
