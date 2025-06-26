package csrent.repository;

import csrent.model.Space;
import csrent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
    public boolean existsByName(String name);
    public User findByEmail(String email);
}
