package csrent.repository;

import csrent.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceJpaRepository extends JpaRepository<Space, Integer> {
    public boolean existsByName(String name);
}
