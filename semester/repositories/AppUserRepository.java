package edu.cca.john.semester.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cca.john.semester.models.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>  {
	AppUser getAppUserByUserid(Long userid);
	AppUser findByEmail(String email);
	boolean existsByEmail(String email);
}
