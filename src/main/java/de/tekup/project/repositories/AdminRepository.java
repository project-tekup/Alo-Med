package de.tekup.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.project.models.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
	
	
	

}
