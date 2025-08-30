package edu.cca.john.semester.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cca.john.semester.models.AppRole;
import edu.cca.john.semester.models.AppRoleDto;
import edu.cca.john.semester.services.AppRoleService;

@RestController
@RequestMapping("/semester/role")
public class AppRoleController {
	@Autowired
	private AppRoleService service;
	@GetMapping("/readroles")
	public List<AppRole> readRoles(){
		return service.readRoles();
	}
	@PostMapping("createrole")
	public ResponseEntity<String> createRole(@RequestBody AppRoleDto roleDto) {
		System.out.println("Testing....");
		service.createAppRole(roleDto);
		return ResponseEntity.ok("Role Created Successfully");
	}
	@PutMapping("updaterole")
	public ResponseEntity<String> updateRole(@RequestBody AppRoleDto roleDto) {
		service.updateAppRole(roleDto);
		return ResponseEntity.ok("Role Updated Successfully");
	}
	@DeleteMapping("deleterole")
	public ResponseEntity<String> deleteRole(@RequestParam Long rid) {
		service.deleteAppRole(rid);
		return ResponseEntity.ok("Role Deleted Successfully");
	}
	@GetMapping("/getrolebyid")
	public AppRole getRoleById(@RequestParam Long rid) {
		return service.getAppRoleByRoleId(rid);
	}
}
