package de.tekup.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.project.models.CarteIdentiteProfessionnelleElectronique;

public interface CarteidRepository  extends JpaRepository<CarteIdentiteProfessionnelleElectronique, Integer>{

}
