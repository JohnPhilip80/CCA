package edu.cca.john.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cca.john.bookstore.models.Book;
import edu.cca.john.bookstore.services.BookDBService;
import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/book/db/api")
public class BookDBController {
	@Autowired
	private BookDBService service;
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest req){
		return (CsrfToken) req.getAttribute("_csrf");
	}
	@GetMapping("/getbookname")
	public String getBookName(HttpServletRequest req) {
		return service.getBookName() + req.getSession().getId();
	}
	@GetMapping("/readbooks")
	public List<Book> readBooks() {
		return service.readBooks();
	}
	@PostMapping("/createbook")
	public String createBook(@RequestBody Book book) {
		service.createBook(book);
		return "Book Created Successfully";
	}
	@PutMapping("/updatebook")
	public String updateBook(@RequestBody Book book) {
		service.updateBook(book);
		return "Book Updated Successfully";
	}
	@DeleteMapping("/deletebook")
	public String deleteBook(@RequestParam Long bno) {
		service.deleteBook(bno);
		return "Book Deleted Successfully";
	}
	@GetMapping("/getbookbybno")
	public Book getBookByBno(@RequestParam Long bno) {
		return service.getBookByBno(bno);
	}
}