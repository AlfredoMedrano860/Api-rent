package csrent.repository;

import csrent.model.Space;
import org.springframework.stereotype.Repository;

@Repository
public class SpaceRepository extends CRUDMemory<Space>{

    public SpaceRepository() {
        data.add(new Space(1,"Grabacion In","Cabina de Grabacion",  20));
        data.add(new Space(2,"TV Group","Estudio de Television",  100));
        data.add(new Space(3,"Ballet Vero","Salon de Ballet",  50));
        data.add(new Space(4,"Esteban Record","Estudio de Grabacion",  40));
    }

    @Override
    public Space edit(Space space) {
        for (Space element: data) {
            if (element.getId().intValue() == space.getId().intValue()) {
                if (space.getCapacity() != null) {
                    element.setCapacity(space.getCapacity());
                }

                if(space.getType() != null){
                    element.setType(space.getType());

                }

                if(space.getName() != null){
                    element.setName(space.getName());
                }
                return element;
            }
        }
        return space;
    }


}
