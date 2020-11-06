package de.tekup.project.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.tekup.project.models.CabinetaddresseEntity;
import de.tekup.project.models.MedecinEntity;
import de.tekup.project.models.PatientEntity;
import de.tekup.project.repositories.CabinetaddresseRepository;
import de.tekup.project.repositories.PatientReposotory;

@Service
public class PatientService  implements Patientmethodes{
	private PatientReposotory patientrepo;
	private CabinetaddresseRepository cabinerepo;
	public PatientService(PatientReposotory patientrepo, CabinetaddresseRepository cabinerepo) {
		super();
		this.patientrepo = patientrepo;
		this.cabinerepo = cabinerepo;
	}
	@Override
	public List<PatientEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return patientrepo.findAll();
	}
	@Override
	public PatientEntity getEntityById(Integer id) {
		Optional<PatientEntity> opt = patientrepo.findById(id);
		PatientEntity entity;
		if(opt.isPresent())
			entity= opt.get();
		else
			throw new NoSuchElementException("Patient with this Id is not found");
		return entity;
	}
	@Override
	public PatientEntity createPatient(PatientEntity entity) {
		CabinetaddresseEntity cab = entity.getAddresseliv();
		cabinerepo.save(cab);
		return patientrepo.save(entity);
	}
	@Override
	public PatientEntity modifyPatient(Integer id, PatientEntity newEntity) {
		PatientEntity oldpatient = this.getEntityById(id);
		if(newEntity.getCin() != 0)
			oldpatient.setCin(newEntity.getCin());
		if(newEntity.getNom() != null)
			oldpatient.setNom(newEntity.getNom());
		if(newEntity.getPrenom() != null)
			oldpatient.setPrenom(newEntity.getPrenom());
		if(newEntity.getPassword() != null)
			oldpatient.setPassword(newEntity.getPassword());
		
		CabinetaddresseEntity oldadd = oldpatient.getAddresseliv();
		CabinetaddresseEntity newadd = newEntity.getAddresseliv();
		if (newadd != null)
			if(newadd.getNumber() != 0)
				oldadd.setNumber(newadd.getNumber());
		if(newadd.getCity() != null)
			oldadd.setCity(newadd.getCity());
		if(newadd.getStreet() != null)
			oldadd.setStreet(newadd.getStreet());
			
			
		return patientrepo.save(oldpatient);
	}
	@Override
	public PatientEntity deletepatient(Integer id) {
		PatientEntity entity = this.getEntityById(id);
		patientrepo.deleteById(id);
		return entity;
	}
}
