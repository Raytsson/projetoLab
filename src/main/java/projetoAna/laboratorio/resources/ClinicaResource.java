package projetoAna.laboratorio.resources;

import org.springframework.web.bind.annotation.PathVariable;
import projetoAna.laboratorio.entities.Clinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoAna.laboratorio.services.ClinicaService;

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
}
