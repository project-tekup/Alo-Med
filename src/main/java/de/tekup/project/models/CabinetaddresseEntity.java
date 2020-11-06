package de.tekup.project.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class CabinetaddresseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private int number ;
	private String street;
	private String city;
	@OneToOne(mappedBy = "cabinetaddresse",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private MedecinEntity medecin ;
	@OneToOne(mappedBy = "addresseliv",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private PatientEntity patient;
	@OneToOne(mappedBy = "pharmacieadresse",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private PharmacienEntity pharmacien;
}
