package voting_system_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import voting_system_app.model.User;

/**
 * @Alima-T 27.06.2022
 */
public interface UserRepo extends JpaRepository<User, Long> {

}
