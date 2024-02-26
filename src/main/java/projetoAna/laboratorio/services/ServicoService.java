package projetoAna.laboratorio.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import projetoAna.laboratorio.entities.Servico;
import projetoAna.laboratorio.repositories.ServicoRepository;
import projetoAna.laboratorio.services.exceptions.DatabaseException;
import projetoAna.laboratorio.services.exceptions.ResourceNotFoundException;

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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Servico insertServico(Servico obj){
        return repository.save(obj);
    }

    public void delete(long id){
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Servico update(Long id, Servico obj){
        try {
            Servico entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Servico entity, Servico obj) {
        entity.setDescricao(obj.getDescricao());
        entity.setDataFechamento(obj.getDataFechamento());
        entity.setDentista(obj.getDentista());
        entity.setPaciente(obj.getPaciente());
        entity.setProtetica(obj.getProtetica());
    }
}
