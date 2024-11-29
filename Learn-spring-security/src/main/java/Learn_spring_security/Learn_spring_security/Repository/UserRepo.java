package Learn_spring_security.Learn_spring_security.Repository;

import Learn_spring_security.Learn_spring_security.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<user, Integer> {

    user findByUsername(String username);
}
