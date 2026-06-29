package org.iplacex.discografia.artistas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class ArtistaController {

    @Autowired
    private IArtistaRepository artistaRepo;
    
    @PostMapping("/artistas")
    public ResponseEntity<Artista> HandleInsertArtistaRequest(@RequestBody Artista artista){

    Artista nuevo = artistaRepo.save(artista);

    return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);

    }

    @GetMapping("/artistas/{id}")
    public Optional<Artista> HandleGetArtistaRequest(@PathVariable String id){

    return artistaRepo.findById(id);

    }

    @GetMapping("/artistas")
    public List<Artista> HandleGetArtistasRequest(){

    return artistaRepo.findAll();

    }

    @PutMapping("/artistas/{id}")
    public Artista HandleUpdateArtistaRequest(@PathVariable String id,
                                          @RequestBody Artista artista){

    artista._id = id;

    return artistaRepo.save(artista);

    }

    @DeleteMapping("/artistas/{id}")
    public void HandleDeleteArtistaRequest(@PathVariable String id){

    artistaRepo.deleteById(id);

    }
}
