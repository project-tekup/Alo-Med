package de.tekup.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "Medecin")
@ToString(exclude = "cabinetaddresse")
public class MedecinEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmedecin;
	@Column(length = 8,nullable = false,unique = true)
	private int cin ;
	@Column(length = 80,nullable = false)
	private String nom ;
	@Column(length = 80,nullable = false)
	private String prenom ;
	private String password ;
	@OneToOne
	private CabinetaddresseEntity cabinetaddresse;
	@OneToOne
	private CarteIdentiteProfessionnelleElectronique carteid;
	
}
