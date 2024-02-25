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
    public Protetica insert(Protetica obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Protetica update(Long id, Protetica obj){
        Protetica entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Protetica entity, Protetica obj) {
        entity.setName(obj.getName());
        entity.setServico(obj.getServico());
    }

}
