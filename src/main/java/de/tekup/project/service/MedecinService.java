package de.tekup.project.service;

import java.util.List; 
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.project.models.CabinetaddresseEntity;
import de.tekup.project.models.CarteIdentiteProfessionnelleElectronique;
import de.tekup.project.models.MedecinEntity;
import de.tekup.project.repositories.CabinetaddresseRepository;
import de.tekup.project.repositories.CarteidRepository;
import de.tekup.project.repositories.MedecinRepository;
@Service
public class MedecinService implements MedecinMethodes {

	private MedecinRepository repomedecin;
	private CabinetaddresseRepository repocabinet;
    private CarteidRepository repocarte;

@Autowired
	public MedecinService(MedecinRepository repomedecin, CabinetaddresseRepository repocabinet, CarteidRepository repocarte) {
		super();
		this.repomedecin = repomedecin;
		this.repocabinet = repocabinet;
		this.repocarte = repocarte;
	}

	@Override
	public List<MedecinEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return repomedecin.findAll();
	}

	@Override
	public MedecinEntity getEntityById(Integer id) {
		Optional<MedecinEntity> opt = repomedecin.findById(id);
		MedecinEntity entity;
		if(opt.isPresent())
			entity= opt.get();
		else
			throw new NoSuchElementException("Medecin with this Id is not found");
		return entity;
		
	}

	@Override
	public MedecinEntity createMedecin(MedecinEntity entity) {
		CabinetaddresseEntity cab = entity.getCabinetaddresse();
		CarteIdentiteProfessionnelleElectronique carte = entity.getCarteid();
		repocabinet.save(cab);
		repocarte.save(carte);
		return repomedecin.save(entity);
	}

	@Override
	public MedecinEntity modifyMedecin(Integer id, MedecinEntity newEntity) {
		MedecinEntity oldMedecin = this.getEntityById(id);
		if(newEntity.getCin() != 0)
			oldMedecin.setCin(newEntity.getCin());
		if(newEntity.getNom() != null)
			oldMedecin.setNom(newEntity.getNom());
		if(newEntity.getPrenom() != null)
			oldMedecin.setPrenom(newEntity.getPrenom());
		if(newEntity.getPassword() != null)
			oldMedecin.setPassword(newEntity.getPassword());
	 CabinetaddresseEntity oldAddress = oldMedecin.getCabinetaddresse();
     CabinetaddresseEntity newAddress = newEntity.getCabinetaddresse();
		if(newAddress != null) {
			// merge/fusion entre oldAddress et newwaddress
			if(newAddress.getNumber() != 0)
				oldAddress.setNumber(newAddress.getNumber());
			if(newAddress.getStreet() != null)
				oldAddress.setStreet(newAddress.getStreet());
			if(newAddress.getCity() != null)
				oldAddress.setCity(newAddress.getCity());
		}
		 CarteIdentiteProfessionnelleElectronique oldcarte = oldMedecin.getCarteid();
	     CarteIdentiteProfessionnelleElectronique newcarteid = newEntity.getCarteid();
			if(newcarteid != null) {
				// merge/fusion entre oldcarteid et newcarteid
				if(newcarteid.getNumidentite() != 0)
					oldcarte.setNumidentite(newcarteid.getNumidentite());
				if(newcarteid.getProfession() != null)
					oldcarte.setProfession(newcarteid.getProfession());
				if(newcarteid.getSpecialite() != null)
					oldcarte.setSpecialite(newcarteid.getSpecialite());
			}
		return repomedecin.save(oldMedecin);
	}

	@Override
	public MedecinEntity deleteMedecinById(Integer id) {
		MedecinEntity entity = this.getEntityById(id);
		repomedecin.deleteById(id);
		return entity;
	}
	
}
