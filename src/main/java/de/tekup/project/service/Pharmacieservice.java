package de.tekup.project.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.tekup.project.models.CabinetaddresseEntity;
import de.tekup.project.models.PatientEntity;
import de.tekup.project.models.PharmacienEntity;
import de.tekup.project.repositories.CabinetaddresseRepository;
import de.tekup.project.repositories.PharmacienRepository;

@Service
public class Pharmacieservice {
	
	private PharmacienRepository repopharmacie;
	private CabinetaddresseRepository repocabinet;

	public Pharmacieservice(PharmacienRepository repopharmacie,CabinetaddresseRepository repocabinet) {
		super();
		this.repopharmacie = repopharmacie;
		this.repocabinet= repocabinet;
	}
	
	public List<PharmacienEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return repopharmacie.findAll();
	}
	public PharmacienEntity getEntityById(Integer id) {
		Optional<PharmacienEntity> opt = repopharmacie.findById(id);
		PharmacienEntity entity;
		if(opt.isPresent())
			entity= opt.get();
		else
			throw new NoSuchElementException("Patient with this Id is not found");
		return entity;
	}
	
	public PharmacienEntity createPharmacien(PharmacienEntity entity) {
		CabinetaddresseEntity cab = entity.getPharmacieadresse();
		repocabinet.save(cab);
		return repopharmacie.save(entity);
	}
	public PharmacienEntity modifyPHarmacien(Integer id, PharmacienEntity newEntity) {
		PharmacienEntity oldpatient = this.getEntityById(id);
		if(newEntity.getCin() != 0)
			oldpatient.setCin(newEntity.getCin());
		if(newEntity.getNom() != null)
			oldpatient.setNom(newEntity.getNom());
		if(newEntity.getPrenom() != null)
			oldpatient.setPrenom(newEntity.getPrenom());
		if(newEntity.getPassword() != null)
			oldpatient.setPassword(newEntity.getPassword());
		
		CabinetaddresseEntity oldadd = oldpatient.getPharmacieadresse();
		CabinetaddresseEntity newadd = newEntity.getPharmacieadresse();
		if (newadd != null)
			if(newadd.getNumber() != 0)
				oldadd.setNumber(newadd.getNumber());
		if(newadd.getCity() != null)
			oldadd.setCity(newadd.getCity());
		if(newadd.getStreet() != null)
			oldadd.setStreet(newadd.getStreet());
			
			
		return repopharmacie.save(oldpatient);
	}
	
	public PharmacienEntity deletepharmacien(Integer id) {
		PharmacienEntity entity = this.getEntityById(id);
		repopharmacie.deleteById(id);
		return entity;
	}
}
