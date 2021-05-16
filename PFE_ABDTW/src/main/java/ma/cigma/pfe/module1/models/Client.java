package ma.cigma.pfe.module1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TCLIENTS")
@Getter  // JAR = LOMBOK.JAR
@Setter
public class Client {
	 // Primary Key @IdClass @EmbeddedId
	// Generation de l'ID.
	// AutoIncrement +1 => (1) IDENTITY
	// SEQUENCE +10 CREER UNE SEQUENCE DONNE CLIENT_SEQ + pas=10 => (2) SEQUENCE
	// SEQUENCE (ORACLE) . PAS DANS MYSQL (+10)
	// TABLE hibernate_sequences : Gerer l'ID increment +10 => (3) TABLE
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="nom_client")
	private String nom;
	private String cin;
	@Transient // La colonne total ne doit etre créee dans la table TCLIENTS
	private int total;
	
}
