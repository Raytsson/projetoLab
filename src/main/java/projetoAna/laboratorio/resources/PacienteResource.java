package projetoAna.laboratorio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projetoAna.laboratorio.entities.Paciente;
import projetoAna.laboratorio.services.PacienteService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {

    @Autowired
    private PacienteService service;

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll(){
        List<Paciente> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{ìd}")
    public ResponseEntity<Paciente> findById(@PathVariable Long id){
        Paciente obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Paciente> insert(@RequestBody Paciente obj){
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
    public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody Paciente obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
