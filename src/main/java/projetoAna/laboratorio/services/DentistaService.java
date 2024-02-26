package projetoAna.laboratorio.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import projetoAna.laboratorio.entities.Dentista;
import projetoAna.laboratorio.repositories.DentistaRepository;
import projetoAna.laboratorio.services.exceptions.DatabaseException;
import projetoAna.laboratorio.services.exceptions.ResourceNotFoundException;

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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Dentista insert(Dentista obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Dentista update(Long id, Dentista obj){
        try {
        Dentista entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Dentista entity, Dentista obj) {
        entity.setName(obj.getName());
        entity.setClinica(obj.getClinica());
    }

}
