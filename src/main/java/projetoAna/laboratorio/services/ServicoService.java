package projetoAna.laboratorio.services;

import org.apache.catalina.User;
import org.hibernate.sql.Update;
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

    public Servico insertServico(Servico obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Servico update(Long id, Servico obj){
        Servico entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Servico entity, Servico obj) {
        entity.setDescricao(obj.getDescricao());
        entity.setDataFechamento(obj.getDataFechamento());
        entity.setDentista(obj.getDentista());
        entity.setPaciente(obj.getPaciente());
        entity.setProtetica(obj.getProtetica());
    }
}
