package de.tekup.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.project.models.MedecinEntity;

public interface MedecinRepository extends JpaRepository<MedecinEntity, Integer>{
	
}
