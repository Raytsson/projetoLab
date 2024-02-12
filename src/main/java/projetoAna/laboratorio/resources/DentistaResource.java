package projetoAna.laboratorio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoAna.laboratorio.entities.Clinica;
import projetoAna.laboratorio.entities.Dentista;
import projetoAna.laboratorio.services.ClinicaService;
import projetoAna.laboratorio.services.DentistaService;

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
}
