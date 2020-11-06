package de.tekup.project.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.project.models.AdminEntity;  
import de.tekup.project.repositories.AdminRepository;

@Service
public class AdminService {

	private AdminRepository adminrepo;
@Autowired
	public AdminService(AdminRepository adminrepo) {
		super();
		this.adminrepo = adminrepo;
	}
public List<AdminEntity> getAllEntities() {
	// TODO Auto-generated method stub
	return adminrepo.findAll();
}

public AdminEntity getEntityById(Integer id) {
	Optional<AdminEntity> opt = adminrepo.findById(id);
	AdminEntity entity;
	if(opt.isPresent())
		entity= opt.get();
	else
		throw new NoSuchElementException("Admin with this Id is not found");
	return entity;
}

public AdminEntity createadmin(AdminEntity entity) {
	return adminrepo.save(entity);
}

public AdminEntity deleteadmin(Integer id) {
	AdminEntity entity = this.getEntityById(id);
	adminrepo.deleteById(id);
	return entity;
}
public AdminEntity modifyadmin(Integer id, AdminEntity newEntity) {
	AdminEntity entity = this.getEntityById(id);
	if(newEntity.getId() != 0)
		entity.setId(newEntity.getId());
	if(newEntity.getPassword() != null)
		entity.setPassword(newEntity.getPassword());
	if(newEntity.getUsername()!= null)
		entity.setUsername(newEntity.getPassword());
	return adminrepo.save(entity);
	
}
}