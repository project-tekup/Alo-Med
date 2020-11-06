package de.tekup.project.service;

import java.util.List;
import de.tekup.project.models.PatientEntity;

public interface Patientmethodes {
	List<PatientEntity> getAllEntities();
	PatientEntity getEntityById(Integer id);
	PatientEntity createPatient(PatientEntity entity);
	PatientEntity modifyPatient(Integer id,PatientEntity newEntity);
    PatientEntity deletepatient(Integer id);

}
