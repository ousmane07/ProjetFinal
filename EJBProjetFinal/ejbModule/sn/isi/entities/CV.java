package sn.isi.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity implementation class for Entity: CV
 *
 */
@Entity

public class CV implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private int age;
	@Column
	private String adresse;
	@Column
	private String email;
	@Column
	private int telephone;
	@Column
	private String specialite;
	@Column
	private String niveauetude;
	@Column
	private String expeprof;
	
	private static final long serialVersionUID = 1L;

	public CV() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public int getTelephone() {
		return this.telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}   
	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}   
	public String getNiveauetude() {
		return this.niveauetude;
	}

	public void setNiveauetude(String niveauetude) {
		this.niveauetude = niveauetude;
	}   
	public String getExpeprof() {
		return this.expeprof;
	}

	public void setExpeprof(String expeprof) {
		this.expeprof = expeprof;
	}
   
}
