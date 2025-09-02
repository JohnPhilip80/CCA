package edu.cca.john.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cca.john.bookstore.models.Book;
import edu.cca.john.bookstore.models.BookDto;
import edu.cca.john.bookstore.services.BookDBService;
import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/book/ui")
public class BookUIController {
	@Autowired
	private BookDBService service;
	
	@GetMapping({"","/"})
	public String showHomePage(Model model, HttpServletRequest req) {
		model.addAttribute("myBook","Welcome to Spring Boot!");
		model.addAttribute("mySession",req.getSession().getId());
		return "/book/homePage.html";
	}
	
	
	
	@GetMapping("/readbooks")
	public String readBooks(Model model, HttpServletRequest req) {
		List<Book> books = service.readBooks();
		model.addAttribute("books",books);
		model.addAttribute("mySession",req.getSession().getId());
		return "/book/bookList.html";
	}
	
	@GetMapping("/createbook")
	public String createBook(Model model, HttpServletRequest req) {
		BookDto bookDto = new BookDto();
		bookDto.setAuthor("TestAuthor");
		bookDto.setTitle("TestTitle");
		model.addAttribute("bookDto",bookDto);
		model.addAttribute("isNew",true);
		model.addAttribute("mySession",req.getSession().getId());
		return "/book/bookDetail.html";
	}
	@PostMapping("/createbook")
	public String createBook(@ModelAttribute BookDto bookDto) {
		Book book = new Book(bookDto.getTitle(),bookDto.getAuthor(),bookDto.getPrice());
		service.createBook(book);
		return "redirect:/book/ui/readbooks";
	}
	
	
	@GetMapping("/updatebook")
	public String updateBook(Model model, @RequestParam Long bno, HttpServletRequest req) {
		Book book = service.getBookByBno(bno);
		BookDto bookDto = new BookDto();
		bookDto.setBno(book.getBno());
		bookDto.setTitle(book.getTitle());
		bookDto.setAuthor(book.getAuthor());
		bookDto.setPrice(book.getPrice());
		model.addAttribute(bookDto);
		model.addAttribute("isNew",false);
		model.addAttribute("mySession",req.getSession().getId());
		return "/book/bookDetail.html";
	}
	@PostMapping("/updatebook")
	public String updateBook(@RequestParam Long bno, @ModelAttribute BookDto bookDto) {
		Book book = service.getBookByBno(bno);
		book.setTitle(bookDto.getTitle());
		book.setAuthor(bookDto.getAuthor());
		book.setPrice(bookDto.getPrice());
		service.updateBook(book);
		return "redirect:/book/ui/readbooks";
	}
	
	@GetMapping("/deletebook")
	public String deleteBook(@RequestParam Long bno) {
		service.deleteBook(bno);
		return "redirect:/book/ui/readbooks";
	}
	@GetMapping("/readbook")
	public String readBook(@RequestParam Long bno,Model model, HttpServletRequest req) {
		Book book = service.getBookByBno(bno);
		BookDto bookDto = new BookDto();
		bookDto.setBno(book.getBno());
		bookDto.setTitle(book.getTitle());
		bookDto.setAuthor(book.getAuthor());
		bookDto.setPrice(book.getPrice());
		model.addAttribute(bookDto);
		model.addAttribute("mySession",req.getSession().getId());
		return "/book/bookRead.html";
	}
}