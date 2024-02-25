package projetoAna.laboratorio.resources;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projetoAna.laboratorio.entities.Clinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import projetoAna.laboratorio.services.ClinicaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clinicas")
public class ClinicaResource {

    @Autowired
    private ClinicaService service;

    @GetMapping
    public ResponseEntity<List<Clinica>> findAll(){
        List<Clinica> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<Clinica> findById(@PathVariable Long id){
        Clinica obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Clinica> insert(@RequestBody Clinica obj){
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
    public ResponseEntity<Clinica> update(@PathVariable Long id, @RequestBody Clinica obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
