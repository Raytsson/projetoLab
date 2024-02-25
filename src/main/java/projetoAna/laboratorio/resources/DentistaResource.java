package projetoAna.laboratorio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projetoAna.laboratorio.entities.Dentista;
import projetoAna.laboratorio.entities.Paciente;
import projetoAna.laboratorio.services.DentistaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaResource {

    @Autowired
    private DentistaService service;

    @GetMapping
    public ResponseEntity<List<Dentista>> findAll(){
        List<Dentista> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<Dentista> findById(@PathVariable Long id){
        Dentista obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Dentista> insert(@RequestBody Dentista obj){
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
    public ResponseEntity<Dentista> update(@PathVariable Long id, @RequestBody Dentista obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
