package projetoAna.laboratorio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoAna.laboratorio.entities.Paciente;
import projetoAna.laboratorio.services.PacienteService;

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

}
