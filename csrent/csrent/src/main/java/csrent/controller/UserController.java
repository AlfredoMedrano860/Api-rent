package csrent.controller;

import csrent.dto.UserDTO;
import csrent.model.User;
import csrent.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    private List<User> users;

    public UserController() {
        // users = new ArrayList<User>();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<User> users = service.getAll();
        if (users == null || users.isEmpty()) {
            return ResponseEntity.ok("No hay usuarios registrados para retornar.");
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody User user) {
        if (service.existsByName(user.getName())) {
            return ResponseEntity.status(HttpStatus.FOUND).body("El usuario con nombre: " + user.getName() + ", ya se encuentra registrado.");
        }

        User created = service.add(user);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se creó el usuario.");
    }

//    @PostMapping("/Register")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO user, BindingResult result) {
//        if(result.hashErrors()){
//            return ResponseEntity.ok("Hay error");
//        }
//        if (service.existsByName(user.getName())) {
//            return ResponseEntity.status(HttpStatus.FOUND).body("El usuario con nombre: " + user.getName() + ", ya se encuentra registrado.");
//        }
//
//        User created = service.add(user);
//        if (created != null) {
//            return ResponseEntity.status(HttpStatus.CREATED).body(created);
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se creó el usuario.");
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        if (service.existsById(id)) {
            return ResponseEntity.ok(service.search(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<?> putUser(@RequestBody User user) {
        if (service.existsById(user.getId())) {
            return ResponseEntity.ok(service.update(user));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ese id (" + user.getId() + ") no se encuentra registrado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        if (service.existsById(id)) {
            return ResponseEntity.ok(service.remove(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ese id (" + id + ") no se encuentra registrado.");
    }

    @PatchMapping
    public ResponseEntity<?> patchUser(@RequestBody User user) {
        if (service.existsById(user.getId())) {
            return ResponseEntity.ok(service.edit(user));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ese id (" + user.getId() + ") no se encuentra registrado.");
    }

}
