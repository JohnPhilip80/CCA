package edu.cca.john.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cca.john.bookstore.models.AppUser;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
	AppUser getAppUserById(Long id);
	AppUser findByEmail(String email);
	boolean existsByEmail(String email);

}
