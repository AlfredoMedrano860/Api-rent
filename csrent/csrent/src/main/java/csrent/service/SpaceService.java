package csrent.service;

import csrent.model.Space;
import csrent.repository.SpaceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceService {

    @Autowired
    SpaceJpaRepository repository;

    public List<Space> getAll(){
        return repository.findAll();
    }

    public Space add(Space space){
        return repository.save(space);
    }

    public Space getSpace(Integer id){ Optional<Space> space= repository.findById(id); if(space.isPresent()){ return space.get(); } return null; }

    public Space edit(Space space) {
        Optional<Space> localSpace = repository.findById(space.getId());

        if(localSpace.isPresent()){

            Space spaces=localSpace.get();

            if (space.getName() != null) {
                spaces.setName(space.getName());
            }

            if (space.getCapacity() != null) {
                spaces.setCapacity(space.getCapacity());
            }

            if (space.getType() != null) {
                spaces.setType(space.getType());
            }

            return repository.save(spaces);
        }
        return space;
    }

    public Space remove(Integer id){
        Space localSpace = repository.findById(id).get();
        if(localSpace != null){
            repository.deleteById(id);
            return localSpace;
        }
        return localSpace;
    }

    public Space update(Space space) {
        Space localSpace = repository.findById(space.getId()).get();

        localSpace.setName(space.getName());
        localSpace.setCapacity(space.getCapacity());
        localSpace.setType(space.getType());

        return repository.save(localSpace);
    }

    public Space search(Integer id){
        return repository.findById(id).get();
    }

    public boolean existsById(Integer id){
        return repository.existsById(id);
    }

    public boolean existsByName(String name){
        return repository.existsByName(name);
    }

}



