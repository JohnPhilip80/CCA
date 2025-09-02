package edu.cca.john.bookstore.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserDetailsRepository extends JpaRepository<AppUser,Long> {
	AppUser getAppUserByEmail(String userName);
}