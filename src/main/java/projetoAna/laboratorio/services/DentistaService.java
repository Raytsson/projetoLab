package projetoAna.laboratorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoAna.laboratorio.entities.Dentista;
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

    public Dentista insert(Dentista obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Dentista update(Long id, Dentista obj){
        Dentista entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Dentista entity, Dentista obj) {
        entity.setName(obj.getName());
        entity.setClinica(obj.getClinica());
    }

}
