package csrent.service;

import csrent.model.Space;
import csrent.model.User;
import csrent.repository.UserJpaRepository;
import csrent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserJpaRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User add(User user) {
        return repository.save(user);
    }

    public User edit(User user) {
        Optional<User> userExist = repository.findById(user.getId());
        if (userExist.isPresent()) {
            User userDb = userExist.get();

            if (user.getName() != null) {
                userDb.setName(user.getName());
            }

            if (user.getType() != null) {
                userDb.setType(user.getType());
            }

            return repository.save(userDb);
        }
        return user;
    }

    public User remove(Integer id) {
        User localUser = repository.findById(id).get();
        if (localUser != null) {
            repository.deleteById(id);
            return localUser;
        }
        return localUser;
    }

    public User update(User user) {
        User localUser = repository.findById(user.getId()).get();

        localUser.setName(user.getName());
        localUser.setType(user.getType());

        return repository.save(localUser);
    }

    public User search(Integer id){
        return repository.findById(id).get();
    }

    public boolean existsById(Integer id){
        return repository.existsById(id);
    }

    public boolean existsByName(String name){
        return repository.existsByName(name);
    }

    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

//    public boolean existsByEmail(String email) {
//        return repository.existsByEmail(email);
//    }

}
