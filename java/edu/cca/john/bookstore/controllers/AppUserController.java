package edu.cca.john.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cca.john.bookstore.models.AppUser;
import edu.cca.john.bookstore.models.AppUserDto;
import edu.cca.john.bookstore.services.AppUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/book/user/api")
public class AppUserController {
	@Autowired
	private AppUserService service;
	@GetMapping("/readusers")
	public List<AppUser> readUsers() {
		return service.readAppUsers();
	}
	@PostMapping("/createuser")
	public String createUser(@RequestBody AppUserDto appUserDto) {
		service.createAppUser(appUserDto);
		return "User Created Successfully";
	}
	@PutMapping("/updateuser")
	public String updateUser(@RequestBody AppUserDto appUserDto) {
		service.updateAppUser(appUserDto);
		return "User Updated Successfully";
	}
	@DeleteMapping("/deleteuser")
	public String deleteUser(@RequestParam Long id) {
		service.deleteAppUser(id);
		return "User Deleted Successfully";
	}
	@GetMapping("/getuserbyid")
	public AppUser getUserByUserId(@RequestParam Long id) {
		return service.getAppUserById(id);
	}
}