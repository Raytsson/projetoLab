package projetoAna.laboratorio.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import projetoAna.laboratorio.entities.Clinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoAna.laboratorio.repositories.ClinicaRepository;
import projetoAna.laboratorio.services.exceptions.DatabaseException;
import projetoAna.laboratorio.services.exceptions.ResourceNotFoundException;

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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Clinica insert(Clinica obj){
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

    public Clinica update(Long id, Clinica obj){
        try {
            Clinica entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Clinica entity, Clinica obj) {
        entity.setName(obj.getName());
    }

}
