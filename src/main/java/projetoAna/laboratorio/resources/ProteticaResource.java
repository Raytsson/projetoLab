package projetoAna.laboratorio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoAna.laboratorio.entities.Protetica;
import projetoAna.laboratorio.services.ProteticaService;

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

}
