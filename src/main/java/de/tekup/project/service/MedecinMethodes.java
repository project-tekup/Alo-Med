package de.tekup.project.service;

import java.util.List;

import de.tekup.project.models.MedecinEntity;
public interface MedecinMethodes {
	List<MedecinEntity> getAllEntities();
	MedecinEntity getEntityById(Integer id);
	MedecinEntity createMedecin(MedecinEntity entity);
	MedecinEntity modifyMedecin(Integer id, MedecinEntity newEntity);
	MedecinEntity deleteMedecinById(Integer id);


}
