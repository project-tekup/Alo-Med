package de.tekup.project.endpoint;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.project.models.MedecinEntity;
import de.tekup.project.service.MedecinService;

@RestController
@RequestMapping("/medecin")
public class MedecinRest {

	private MedecinService servicemedecin;

	public MedecinRest(MedecinService servicemedecin) {
		super();
		this.servicemedecin = servicemedecin;
	}
	@GetMapping
	public List<MedecinEntity> getAll(){
		return servicemedecin.getAllEntities();
	}
	
	@GetMapping("/{id}")
	public MedecinEntity getById(@PathVariable("id") Integer id) {
		return servicemedecin.getEntityById(id);
	}
	
	@PostMapping
	public MedecinEntity createmedecin(@RequestBody MedecinEntity medecin) {
		return servicemedecin.createMedecin(medecin);
	}
	
	@PutMapping("/{id}")
	public MedecinEntity modifymedecin(@PathVariable("id") Integer id, @RequestBody MedecinEntity newmedecin) {
		return servicemedecin.modifyMedecin(id, newmedecin);
	}
	
	@DeleteMapping("/{id}")
	public MedecinEntity deleteById(@PathVariable("id") Integer id) {
		return servicemedecin.deleteMedecinById(id);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
}
