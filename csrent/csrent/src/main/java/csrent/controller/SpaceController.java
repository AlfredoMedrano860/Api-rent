package csrent.controller;

import csrent.model.Space;

import csrent.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/space")
public class SpaceController {
    @Autowired
    SpaceService service;

    private List<Space> spaces;

    public SpaceController() {
        //spaces= new ArrayList<Space>();

    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Space> spaces = service.getAll();
        if(spaces==null || spaces.isEmpty()){
           return ResponseEntity.ok("No hay espacio creativo para retornar");
        }
        return ResponseEntity.ok(service.getAll());

        }

    @PostMapping
    public ResponseEntity<?> postSpace(@RequestBody Space space) {
        if(service.existsByName(space.getName())){
            return ResponseEntity.status(HttpStatus.FOUND).body("El espacion con nombre:" + space.getName()+", se encuetra registrado.");
        }

        Space created = service.add(space);
        if(created != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se creó el space.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSpaceById(@PathVariable Integer id) {
        if (service.existsById(id)) {
            return ResponseEntity.ok(service.search(id));
        }
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El espacio con id"+id+", no se encuetra registrado.")
       // return ResponseEntity.ok("El espacio con id"+id+", no se encuetra registrado.");
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<?> putSpace(@RequestBody Space space) {
        if(service.existsById(space.getId())){
            return ResponseEntity.ok(service.update(space));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ese id ("+getSpaceById(space.getId())+") no se encuentra registrado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpace(@PathVariable Integer id) {
        if(service.existsById(id)){
            return ResponseEntity.ok(service.remove(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ese id ("+ id +") no se encuentra registrado.");
    }

    @PatchMapping
    public ResponseEntity<?> patchSpace (@RequestBody Space space) {
        if(service.existsById(space.getId())) {
            return ResponseEntity.ok(service.edit(space));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ese id ("+ space.getId() +") no se encuentra registrado.");
    }

    }

