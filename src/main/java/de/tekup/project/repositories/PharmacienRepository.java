package de.tekup.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.project.models.PharmacienEntity;

public interface PharmacienRepository extends JpaRepository<PharmacienEntity, Integer> {

}
