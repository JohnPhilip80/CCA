package edu.cca.john.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cca.john.bookstore.models.AppRole;
import edu.cca.john.bookstore.models.AppRoleDto;
import edu.cca.john.bookstore.repositories.RoleRepository;


@Service
public class AppRoleService {
	@Autowired
	private RoleRepository repo;
	
	public List<AppRole>readRoles(){
		return repo.findAll();
	}
	public void createAppRole(AppRoleDto roleDto) {
		repo.save(new AppRole(roleDto.getName(),roleDto.getDescription()));
	}
	public void updateAppRole(AppRoleDto roleDto) {
		repo.save(new AppRole(roleDto.getRoleid(),roleDto.getName(),roleDto.getDescription()));
	}
	public void deleteAppRole(Long roleId) {
		repo.deleteById(roleId);
	}
	public AppRole getAppRoleByRoleId(Long roleId) {
		return repo.getAppRoleByRoleid(roleId);
	}
}