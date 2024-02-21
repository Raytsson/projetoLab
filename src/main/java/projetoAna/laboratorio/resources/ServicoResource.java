package projetoAna.laboratorio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projetoAna.laboratorio.entities.Protetica;
import projetoAna.laboratorio.entities.Servico;
import projetoAna.laboratorio.services.ProteticaService;
import projetoAna.laboratorio.services.ServicoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService service;

    @GetMapping
    public ResponseEntity<List<Servico>> findAll(){
        List<Servico> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id){
        Servico obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Servico> insertServico(@RequestBody Servico obj){
        obj = service.insertServico(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Servico> update(@PathVariable Long id, @RequestBody Servico obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
