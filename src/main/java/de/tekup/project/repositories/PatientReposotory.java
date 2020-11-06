package de.tekup.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.project.models.PatientEntity;

public interface PatientReposotory extends JpaRepository<PatientEntity, Integer>{

}
