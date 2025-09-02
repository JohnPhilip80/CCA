package edu.cca.john.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import edu.cca.john.bookstore.models.AppUser;
import edu.cca.john.bookstore.models.AppUserDto;
import edu.cca.john.bookstore.repositories.AppUserRepository;

@Service
public class AppUserService {
	@Autowired
	private AppUserRepository repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<AppUser> readAppUsers()
	{
		return repo.findAll();
	}
	
	public void createAppUser(AppUserDto appUserDto) 
	{
		AppUser appUser = new AppUser();
		appUser.setName(appUserDto.getName());
		appUser.setEmail(appUserDto.getEmail());
		appUser.setPassword(appUserDto.getPassword());
		appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
		appUser.setUserroles(appUserDto.getUserroles());
		repo.save(appUser);
	}
	public void updateAppUser(AppUserDto appUserDto) 
	{
		AppUser appUser = new AppUser();
		appUser.setId(appUserDto.getId());
		appUser.setName(appUserDto.getName());
		appUser.setEmail(appUserDto.getEmail());
		appUser.setPassword(appUserDto.getPassword());
		appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
		appUser.setUserroles(appUserDto.getUserroles());
		repo.save(appUser);
	}
	public void deleteAppUser(Long id)
	{
		repo.deleteById(id);
	}
	public AppUser getAppUserById(Long id) {
		return repo.getAppUserById(id);
	}
}
