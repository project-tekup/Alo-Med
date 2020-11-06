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
public class CarteIdentiteProfessionnelleElectronique {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int numidentite;
    private String profession;
    private String specialite;
    @OneToOne(mappedBy = "carteid",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private MedecinEntity medecin;
    
    
}
