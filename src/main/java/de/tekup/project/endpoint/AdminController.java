package de.tekup.project.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.project.models.AdminEntity;
import de.tekup.project.models.MedecinEntity;
import de.tekup.project.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	private AdminService adminservice;
	
	
	
	
	@Autowired
	public AdminController(AdminService adminservice) {
		super();
		this.adminservice = adminservice;
	}
	
	public List<AdminEntity> getAll(){
		return adminservice.getAllEntities();
	}
	
	@GetMapping("/{id}")
	public AdminEntity getById(@PathVariable("id") Integer id) {
		return adminservice.getEntityById(id);
	}
	
	@PostMapping
	public AdminEntity createadmin(@RequestBody AdminEntity admin1) {
		return adminservice.createadmin(admin1);
	}
	
	@PutMapping("/{id}")
	public AdminEntity modifymedecin(@PathVariable("id") Integer id, @RequestBody AdminEntity newadmin) {
		return adminservice.modifyadmin(id, newadmin);
	}
	
	@DeleteMapping("/{id}")
	public AdminEntity deleteById(@PathVariable("id") Integer id) {
		return adminservice.deleteadmin(id);
	}

	

}
