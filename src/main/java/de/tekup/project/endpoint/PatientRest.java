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
import de.tekup.project.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientRest {
	private PatientService  patientservice;
@Autowired
	public PatientRest(PatientService patientservice) {
		super();
		this.patientservice = patientservice;
	}
@GetMapping
public List<PatientEntity> getAll(){
	return patientservice.getAllEntities();
}

@GetMapping("/{id}")
public PatientEntity getById(@PathVariable("id") Integer id) {
	return patientservice.getEntityById(id);
}

@PostMapping
public PatientEntity createpatient(@RequestBody PatientEntity patient) {
	return patientservice.createPatient(patient);
}

@PutMapping("/{id}")
public PatientEntity modifypatient(@PathVariable("id") Integer id, @RequestBody PatientEntity newpatient) {
	return patientservice.modifyPatient(id, newpatient);
}

@DeleteMapping("/{id}")
public PatientEntity deleteById(@PathVariable("id") Integer id) {
	return patientservice.deletepatient(id);
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
	return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
}

	
	
	

}
