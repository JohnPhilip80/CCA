package edu.cca.john.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cca.john.bookstore.models.Book;
import edu.cca.john.bookstore.repositories.BookDBRepository;

@Service
public class BookDBService {
	@Autowired
	private BookDBRepository repoDB;
	
	public List<Book> readBooks(){
		return repoDB.findAll();
	}
	public void createBook(Book book) {
		repoDB.save(book);
	}
	public void updateBook(Book book) {
		repoDB.save(book);
	}
	public void deleteBook(Long bno) {
		repoDB.deleteById(bno);
	}
	public Book getBookByBno(Long bno) {
		return repoDB.getBookByBno(bno);
	}
	public String getBookName() {
		return "Testing Session ID";
	}

}