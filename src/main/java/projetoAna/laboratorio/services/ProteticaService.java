package projetoAna.laboratorio.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import projetoAna.laboratorio.entities.Protetica;
import projetoAna.laboratorio.repositories.ProteticaRepository;
import projetoAna.laboratorio.services.exceptions.DatabaseException;
import projetoAna.laboratorio.services.exceptions.ResourceNotFoundException;

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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Protetica insert(Protetica obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Protetica update(Long id, Protetica obj) {
        try {
            Protetica entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Protetica entity, Protetica obj) {
        entity.setName(obj.getName());
        entity.setServico(obj.getServico());
    }

}
