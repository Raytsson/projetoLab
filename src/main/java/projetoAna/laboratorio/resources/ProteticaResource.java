package projetoAna.laboratorio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projetoAna.laboratorio.entities.Protetica;
import projetoAna.laboratorio.entities.Servico;
import projetoAna.laboratorio.services.ProteticaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/proteticas")
public class ProteticaResource {

    @Autowired
    private ProteticaService service;

    @GetMapping
    public ResponseEntity<List<Protetica>> findAll(){
        List<Protetica> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Protetica> findById(@PathVariable Long id){
        Protetica obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    public ResponseEntity<Protetica> insertServico(@RequestBody Protetica obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Protetica> update(@PathVariable Long id, @RequestBody Protetica obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
