package edu.cca.john.semester.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.cca.john.semester.models.AppRole;
import edu.cca.john.semester.models.ERole;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
	AppRole getAppRoleByRoleid(Long id);
	AppRole getAppRoleByName(ERole roleName);
}
