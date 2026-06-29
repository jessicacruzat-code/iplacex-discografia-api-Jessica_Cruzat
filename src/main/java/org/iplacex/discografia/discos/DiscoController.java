package org.iplacex.discografia.discos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DiscoController {

    @Autowired
    private IDiscoRepository discoRepo;

    @PostMapping("/discos")
    public ResponseEntity<Disco> HandleInsertDiscoRequest(@RequestBody Disco disco){

        Disco nuevo = discoRepo.save(disco);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("/discos/{id}")
    public ResponseEntity<Optional<Disco>> HandleGetDiscoRequest(@PathVariable String id){

        return ResponseEntity.ok(discoRepo.findById(id));
    }

    @GetMapping("/discos")
    public ResponseEntity<List<Disco>> HandleGetDiscosRequest(){

        return ResponseEntity.ok(discoRepo.findAll());

    }

    @PutMapping("/discos/{id}")
    public ResponseEntity<Disco> HandleUpdateDiscoRequest(
            @PathVariable String id,
            @RequestBody Disco disco){

        disco._id = id;

        Disco actualizado = discoRepo.save(disco);

        return ResponseEntity.ok(actualizado);

    }

    @DeleteMapping("/discos/{id}")
    public ResponseEntity<Void> HandleDeleteDiscoRequest(@PathVariable String id){

        discoRepo.deleteById(id);

        return ResponseEntity.noContent().build();

    }
}