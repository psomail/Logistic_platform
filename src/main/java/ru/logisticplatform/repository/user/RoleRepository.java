package ru.logisticplatform.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.logisticplatform.model.user.Role;

/**
 * Repository interface that extends {@link JpaRepository} for class {@link Role}.
 *
 * @author Sergei Perminov
 * @version 1.0
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

   }

