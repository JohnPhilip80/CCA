package edu.cca.john.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cca.john.bookstore.models.Book;
@Repository
public interface BookDBRepository extends JpaRepository<Book,Long> {
	Book getBookByBno(Long bno);
}