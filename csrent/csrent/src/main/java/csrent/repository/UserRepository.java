package csrent.repository;

import csrent.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends CRUDMemory<User> {

    public UserRepository() {
//        data.add(new User(1, "Juan", "Administrador"));
//        data.add(new User(2, "Ana", "Editor"));
//        data.add(new User(3, "Luis", "Lector"));
//        data.add(new User(4, "Marta", "Invitado"));
    }

    @Override
    public User edit(User user) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().intValue() == user.getId().intValue()) {
                if (user.getName() != null) {
                    data.get(i).setName(user.getName());
                }
                if (user.getType() != null) {
                    data.get(i).setType(user.getType());
                }
                return data.get(i);
            }
        }
        return user;
    }
}
