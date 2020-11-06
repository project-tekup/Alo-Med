package de.tekup.project.endpoint;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
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

import de.tekup.project.models.PatientEntity;
import de.tekup.project.models.PharmacienEntity;
import de.tekup.project.service.Pharmacieservice;

@RestController
@RequestMapping("/api/ph")
public class PharmacienController {
private Pharmacieservice phservice;

@Autowired
public PharmacienController(Pharmacieservice phservice) {
	super();
	this.phservice = phservice;
}

@GetMapping
public List<PharmacienEntity> getAll(){
	return phservice.getAllEntities();
}

@GetMapping("/{id}")
public PharmacienEntity getById(@PathVariable("id") Integer id) {
	return phservice.getEntityById(id);
}

@PostMapping
public PharmacienEntity createpatient(@RequestBody PharmacienEntity ph) {
	return phservice.createPharmacien(ph);
}

@PutMapping("/{id}")
public PharmacienEntity modifypatient(@PathVariable("id") Integer id, @RequestBody PharmacienEntity newph) {
	return phservice.modifyPHarmacien(id, newph);
}


@DeleteMapping("/{id}")
public PharmacienEntity deleteById(@PathVariable("id") Integer id) {
	return phservice.deletepharmacien(id);
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
	return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
}
	
	
	
}
