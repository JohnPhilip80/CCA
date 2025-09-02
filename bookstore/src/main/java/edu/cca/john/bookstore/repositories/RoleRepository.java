package edu.cca.john.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cca.john.bookstore.models.AppRole;
import edu.cca.john.bookstore.models.ERole;

@Repository
public interface RoleRepository extends JpaRepository<AppRole,Long> {
	AppRole getAppRoleByRoleid(Long id);
	AppRole getAppRoleByName(ERole name);
}
